package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;

@Service
public class OrdersDataService implements DataAccessInterface
{
	@Autowired
	private OrdersRepository ordersRepository;

	public OrdersDataService(OrdersRepository ordersRepository)
	{
	    this.ordersRepository = ordersRepository;
	}
	/**
	 * CRUD: finder to return a single entity
	 */
	public OrderEntity findById(int id)
	{
	    return null;
	}

	/**
	* CRUD: finder to return all entities
	*/
	public List<OrderEntity> findAll()
	{
	    List<OrderEntity> orders = new ArrayList<OrderEntity>();
	    try
	    {
	       // Get all all the Entity Orders
	       Iterable<OrderEntity> ordersIterable = ordersRepository.findAll();
	       // Convert to a List and return the List
	       orders = new ArrayList<OrderEntity>();
	       ordersIterable.forEach(orders::add);
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	    
	   // Return the List
	   return orders;
	  }

	public boolean create(OrderEntity order)
	{
	    try
	    {
	        this.ordersRepository.save(order);
	    }
	   catch (Exception e)
	    {
	        e.printStackTrace();
	        return false;
	    }
	    return true;
	    }

	@Override
	public boolean create(Object t) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean update(Object t) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean delete(Object t) {
		// TODO Auto-generated method stub
		return false;
	}
}