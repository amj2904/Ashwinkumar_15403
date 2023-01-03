package com.ecommerce.controller;

import java.sql.SQLException;
import java.util.List;
import com.ecommerce.dao.CustomerDao;
import com.ecommerce.model.Customer;

public class CustomerCollection implements ICollection<Customer> {

	private CustomerDao customerDao;
	private static CustomerCollection customerCollection;
	public List<Customer> customersList;
	
	private CustomerCollection() {
		super();
		this.customerDao=CustomerDao.getCustomerDao();
	}
	
	public static CustomerCollection getCustomerCollection() {
		if(customerCollection==null) {
			synchronized(CustomerCollection.class) {
				if(customerCollection==null) {
					customerCollection=new CustomerCollection();
				}
			}
		}
		return customerCollection;
	}
	
	@Override
	public List<Customer> findAll() throws SQLException {
		
		return this.customerDao.findAll();
	}

	@Override
	public Customer findOne(int id) throws SQLException {
		return this.customerDao.findOne(id);
	}

	@Override
	public boolean createNew(Customer customer) throws SQLException {
		return this.customerDao.createNew(customer);
	}

	@Override
	public boolean findOneAndDelete(int id) throws SQLException {
		return this.customerDao.findOneandDelete(id);
	}

	@Override
	public boolean findOneAndUpdate(int id, Customer customer) throws SQLException {
		return this.customerDao.findOneandUpdate(id, customer);
	}

}
