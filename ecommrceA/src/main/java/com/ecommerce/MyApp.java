package com.ecommerce;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.ecommerce.controller.CustomerController;
import com.ecommerce.controller.OrderItemController;
import com.ecommerce.controller.OrdersController;
import com.ecommerce.controller.ProductController;
import com.ecommerce.model.Customer;
import com.ecommerce.model.OrderItem;
import com.ecommerce.model.Orders;
import com.ecommerce.model.Product;

public class MyApp {

	public static void main(String[] args) throws Exception {
		
		OrderItemController orderItemController = OrderItemController.getOrderItemController();
		ProductController productController = ProductController.getProductController();
		CustomerController customerController = CustomerController.getCustomerController();
		OrdersController ordersController = OrdersController.getOrdersController();
		Scanner sc = new Scanner(System.in);
		System.out.println("1.) Display Product");
		System.out.println("2.) Order Placed");
		System.out.println("3.) Display Orders");
		System.out.println("4.) OrderItem");
//		System.out.println("5.) Find and Delete");
//		System.out.println("6.) Exit");

		System.out.println("Please Enter your choice :");
		int choice = sc.nextInt();
		System.out.println(choice);

		switch (choice) {

		case 1:
			List<Product> list = productController.findAll();
			for (Product product : list) {
				System.out.println(product);
			}
			break;
			
		case 2:

			Date date = new Date();  
	        Timestamp ts=new Timestamp(date.getTime());  
			List<OrderItem> orderItems=new ArrayList<>();
			Product product=null;
			OrderItem orderItem=null;
			System.out.println("How Many Products you want to Order");
			int no=sc.nextInt();
			System.out.println("Enter Customer ID :");
			int cId=sc.nextInt();
			Customer customer=customerController.findOne(cId);
			Orders orders = new Orders(ts, customer);
			for(int i=0;i<no;i++) {
				System.out.println("Enter the Product Id to Order :");
				int id=sc.nextInt();
				product=productController.findOne(id);
				System.out.println("Enter Product Quantities :");
				int quantity=sc.nextInt();
				
				 orderItem = new OrderItem(product, quantity, orders);
				
				 orderItems.add(orderItem);
			}
			
			orders.setOrderItem(orderItems);
			boolean orderss=ordersController.createNew(orders);
			for (OrderItem item:orderItems)
			{
				boolean itemcreated=orderItemController.createNew(item);
				
				
			}
				break;
		
		case 3:
			List<Orders> list1 = ordersController.findAll();
			for (Orders orders2 : list1) {
				System.out.println(orders2);
				break;
			}
		case 4:
			List<OrderItem> list3 = orderItemController.findAll();
			for (OrderItem OrderItem : list3) {
				System.out.println(OrderItem);
				break;
			}

		}
	}
}
