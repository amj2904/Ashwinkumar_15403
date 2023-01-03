package com.ecommerce.controller;

import java.sql.SQLException;
import java.util.List;

import com.ecommerce.model.Orders;

public class OrdersController implements IController<Orders> {
	private static OrdersController ordersController;
	private   OrdersCollection ordersCollection;
	

	private OrdersController() {
		super();
		this.ordersCollection=OrdersCollection.getOrdersCollection();
	}
	public static OrdersController getOrdersController () {
		if(ordersController==null) {
			synchronized (OrdersController.class) {
				if(ordersController==null) {
					ordersController= new OrdersController();
				}
				
			}
		}
		return ordersController;
	}
	
	@Override
	public List<Orders> findAll() throws SQLException {
		return ordersCollection.findAll();
	}

	@Override
	public Orders findOne(int id) throws SQLException {
		return ordersCollection.findOne(id);
	}

	@Override
	public boolean createNew(Orders product) throws SQLException {
		return ordersCollection.createNew(product);
	}

	@Override
	public boolean findOneAndDelete(int id) throws SQLException {
		return ordersCollection.findOneAndDelete(id);
	}

	@Override
	public boolean findOneAndUpdate(int id, Orders product) throws SQLException {
		return ordersCollection.findOneAndUpdate(id, product);
	}

}
