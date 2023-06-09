package com.gcu.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * @XmlRootElement maps a class to an XML element.
 * When a top-level class is annotated with this, then 
 * its value is represented as an XML element in the
 * XML doc
 */
@XmlRootElement(name="orders")
public class OrderList 
{
	private List<OrderModel> orders = new ArrayList<OrderModel>();
	
	/* 
	 * Maps a JavaBean property to the XML element
	 * derived from property name.
	 * 
	 * Maps a field or property to an XML element 
	 * which should be within the XML Root Element
	 */
	@XmlElement(name="order")
	public List<OrderModel> getOrders()
	{
		return this.orders;
	}
	
	public void setOrders(List<OrderModel> orders)
	{
		this.orders = orders;
	}
	
}
