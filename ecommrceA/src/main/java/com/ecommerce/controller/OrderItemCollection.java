package com.ecommerce.controller;

import java.sql.SQLException;
import java.util.List;

import com.ecommerce.dao.CustomerDao;
import com.ecommerce.dao.OrderItemDao;
import com.ecommerce.model.Customer;
import com.ecommerce.model.OrderItem;
import com.ecommerce.model.Product;

public class OrderItemCollection implements ICollection<OrderItem> {
	private OrderItemDao orderItemDao;
	private static OrderItemCollection orderItemCollection;
	public List<OrderItem> orderItemList;
	

	private OrderItemCollection() {
		super();
		this.orderItemDao=OrderItemDao.getOrderItemDao();
	}
	public static OrderItemCollection getOrderItemCollection() {
		if(orderItemCollection==null) {
			synchronized(OrderItemCollection.class) {
				if(orderItemCollection==null) {
					orderItemCollection=new OrderItemCollection();
				}
			}
		}
		return orderItemCollection;
	}
	@Override
	public List<OrderItem> findAll() throws SQLException {
		return this.orderItemDao.findAll();
	}

	@Override
	public OrderItem findOne(int id) throws SQLException {
		return this.orderItemDao.findOne(id);
	}

	@Override
	public boolean createNew(OrderItem customer) throws SQLException {
		return this.orderItemDao.createNew(customer);
	}

	@Override
	public boolean findOneAndDelete(int id) throws SQLException {
		return this.orderItemDao.findOneandDelete(id);
	}

	@Override
	public boolean findOneAndUpdate(int id, OrderItem customer) throws SQLException {
		return this.orderItemDao.findOneandUpdate(id, customer);
	}

}
