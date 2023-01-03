package com.ecommerce.controller;

import java.sql.SQLException;
import java.util.List;

import com.ecommerce.model.OrderItem;


public class OrderItemController implements IController<OrderItem> {
	
	private static OrderItemController orderItemController;
	private static  OrderItemCollection orderItemCollection;
	

	private OrderItemController() {
		super();
		this.orderItemCollection=OrderItemCollection.getOrderItemCollection();
	}
	public static OrderItemController getOrderItemController() {
		if(orderItemController==null) {
			synchronized (OrderItemController.class) {
				if(orderItemController==null) {
					orderItemController= new OrderItemController();
				}
				
			}
		}
		return orderItemController;
	}


	@Override
	public  List<OrderItem> findAll() throws SQLException {
		return orderItemCollection.findAll();
	}

	@Override
	public OrderItem findOne(int id) throws SQLException {
		return orderItemCollection.findOne(id);
	}

	@Override
	public boolean createNew(OrderItem product) throws SQLException {
		return orderItemCollection.createNew(product);
	}

	@Override
	public boolean findOneAndDelete(int id) throws SQLException {
		return orderItemCollection.findOneAndDelete(id);
	}

	@Override
	public boolean findOneAndUpdate(int id, OrderItem product) throws SQLException {
		return orderItemCollection.findOneAndUpdate(id, product);
	}

}
