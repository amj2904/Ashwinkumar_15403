package com.ecommerce.controller;

import java.sql.SQLException;
import java.util.List;

import com.ecommerce.dao.OrdersDao;
import com.ecommerce.dao.ProductDao;
import com.ecommerce.model.Orders;
import com.ecommerce.model.Product;

public class OrdersCollection implements ICollection<Orders> {
	private static OrdersCollection ordersCollection;
	private static OrdersDao ordersDao;
	private List<Orders> ordersList;


	private OrdersCollection() {
		super();
		this.ordersDao=OrdersDao.getOrdersDao();
	}

	public static OrdersCollection getOrdersCollection() {
		if (ordersCollection == null) {
			synchronized (OrdersCollection.class) {
				if (ordersCollection == null) {
					ordersCollection = new OrdersCollection();
				}

			}
		}
		return ordersCollection;
	}
	
	@Override
	public List<Orders> findAll() throws SQLException {
		ordersList = ordersDao.findAll();
		return ordersList;
	}

	@Override
	public Orders findOne(int id) throws SQLException {
		Orders orders = ordersDao.findOne(id);
		return orders;
	}

	@Override
	public boolean createNew(Orders product) throws SQLException {
		return ordersDao.createNew(product);
	}

	@Override
	public boolean findOneAndDelete(int id) throws SQLException {
		return ordersDao.findOneandDelete(id);
	}

	@Override
	public boolean findOneAndUpdate(int id, Orders product) throws SQLException {
		return ordersDao.findOneandUpdate(id, product);
	}

}
