package com.ecommerce.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.ecommerce.model.Customer;



public class CustomerDaoTest {
	private Customer customer;
	private CustomerDao customerDao;
	@BeforeEach()
	public void beforeEach() {
		customer=new Customer(33,"as","a@gmail.com");
		customerDao=new CustomerDao();
	}
	@Test
	public void testCreateCustomer() {
		Assertions.assertTrue(customerDao.createNew(customer));
	}
	@Disabled
	@Test
	public void testFindAllNotNull() {
		Assertions.assertNotNull(customerDao.findAll());
	}
	@Disabled
	@Test
	public void testFindOneNotNull() {
		customer=customerDao.findOne(50);
		Assertions.assertNotNull(customer);
		System.out.println("id=49 |"+customer);
	}
	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(customerDao.findOneandDelete(40));
	}
	@Disabled
	@Test
	public void testFindOneAndUpdate() {
		customer.setcName("ashwin");
		Assertions.assertTrue(customerDao.findOneandUpdate(42, customer));
	}
}
