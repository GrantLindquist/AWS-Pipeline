package com.gcu.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.data.entity.OrderEntity;

/*
 *  RowMapper is interface that maps rows of SQL result set.
 *  Functions on per-row basis
 */
public class OrderRowMapper implements RowMapper<OrderEntity>
{
	// Maps values of one row
	@Override
	public OrderEntity mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		return new OrderEntity(rs.getString("ORDER_NO"), rs.getString("PRODUCT_NAME"),
				rs.getFloat("PRICE"), rs.getInt("QUANTITY"), rs.getLong("ID"));
	}
	
}
