package com.ecommerce.controller;

import java.sql.SQLException;
import java.util.List;

import com.ecommerce.model.Customer;

public class CustomerController implements IController<Customer>{
	
	private static CustomerController customerController;
	private CustomerCollection customerCollection;
	
	public CustomerController(){
		super();
		this.customerCollection=CustomerCollection.getCustomerCollection();
		
	}
	
	public static CustomerController getCustomerController() {
		if(customerController==null) {
			synchronized(CustomerController.class) {
				if(customerController==null) {
					customerController=new CustomerController();
				}
			}
		}
		return customerController;
	}


	@Override
	public List<Customer> findAll() throws SQLException {
		return customerCollection.findAll();
	}

	@Override
	public Customer findOne(int id) throws SQLException {
		return customerCollection.findOne(id);
	}

	@Override
	public boolean createNew(Customer customer) throws SQLException {
		return customerCollection.createNew(customer);
	}

	@Override
	public boolean findOneAndDelete(int id) throws SQLException {
		return customerCollection.findOneAndDelete(id);
	}

	@Override
	public boolean findOneAndUpdate(int id, Customer customer) throws SQLException {
		return customerCollection.findOneAndUpdate(id, customer);
	}

}
