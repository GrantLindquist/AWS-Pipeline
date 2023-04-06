package com.gcu.buisness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.gcu.model.OrderList;
import com.gcu.model.OrderModel;

/* 
 * @RestController is a convenience annotation for creating
 * Restful controllers. It adds the @Controller and @ResponseBody
 * annotations. 
 * 
 * Converts response to JSON or XML
 */
@RestController
/* 
 * @RequestMapping maps requests into specific handler classes or
 * methods
 */
@RequestMapping("/service")
public class OrdersRestService
{
	// Inject this bean into OrdersRestService bean using @Autowired
	@Autowired
	OrdersBusinessServiceInterface service;
	
	/*
	 * The @GetMapping is a shortcut for @RequestMapping.
	 * 
	 * Produces = MediaType.APPLICATION_JSON_VALUE means that produced 
	 * response will be converted into JSON.
	 */	
	@GetMapping(path="/getjson", produces={MediaType.APPLICATION_JSON_VALUE})
	public List<OrderModel> getOrdersAsJson()
	{
		return service.getOrders();
	}
	
	@GetMapping(path="/getxml", produces={MediaType.APPLICATION_XML_VALUE})
	public OrderList getOrdersAsXml()
	{
		OrderList list = new OrderList();
		list.setOrders(service.getOrders());
		return list;
	}
}
