package com.gcu.buisness;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.OrdersDataService;
import com.gcu.data.entity.OrderEntity;
import com.gcu.model.OrderModel;

@Service
public class OrdersBusinessService implements OrdersBusinessServiceInterface
{
	@Autowired
	OrdersDataService service;
	
	@Override
	public List<OrderModel> getOrders()
	{
	   // Get all all the Entity Orders
	    List<OrderEntity> ordersEntity = service.findAll();
	   // Iterate over the Entity Orders and create a list of Domain Orders
	    List<OrderModel> ordersDomain = new ArrayList<OrderModel>();
	    for (OrderEntity entity : ordersEntity)
	    {
	        ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(), entity.getProductName ( ), entity.getPrice(), entity.getQuantity()));
	    }
	   // Return list of Domain Orders
	    return ordersDomain;
	}
	
	public void init()
	{
		System.out.println("Hello from OrdersBusinessService.init()");
	}
	
	public void destroy()
	{
		System.out.println("Hello from OrdersBusinessService.destroy()");
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
	}
}
