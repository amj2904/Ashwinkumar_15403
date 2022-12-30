package com.training.WebsiteEcommerce.controller;

import java.sql.SQLException;
import java.util.List;

import com.training.WebsiteEcommerce.dao.CustomerDao;
import com.training.WebsiteEcommerce.model.Customer;



public class CustomerCollection implements ICollection<Customer> {
	
	
	private static CustomerCollection customerCollection;
	private CustomerDao dao;
	private List<Customer> customerlist;
	
	private CustomerCollection() {
		this.dao=CustomerDao.getCustomerDao();
	}
	public static CustomerCollection getCustomerCollection() {
		if(customerCollection==null) {
			synchronized (CustomerCollection.class) {
				if(customerCollection==null) {
					customerCollection=new CustomerCollection();
				}
				
			}
		}
		return customerCollection;
	}
	

	public List<Customer> findAll() throws SQLException {
		customerlist=dao.findAll();
		return customerlist;
	}

	public Customer findOne(int id) throws SQLException {
		Customer customer=dao.findOne(id);
		return customer;
	}

	public boolean createNew(Customer customer) throws SQLException {
		return dao.createNew(customer);
	}

	public boolean findOneAndDelete(int id) throws SQLException {
		return dao.findOneAndDelete(id);
	}

	public boolean findOneAndUpdate(int id, Customer customer) throws SQLException {
		return dao.findOneAndUpdate(id, customer);
	}

}
