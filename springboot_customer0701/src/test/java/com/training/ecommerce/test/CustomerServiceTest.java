package com.training.ecommerce.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.ecommerce.dto.CustomerData;
import com.training.ecommerce.service.CustomerService;

@SpringBootTest
public class CustomerServiceTest {
	@Autowired
	private CustomerService customerService;
	CustomerData customerData;

	@BeforeEach
	public void beforeEach() {

		customerData = new CustomerData();
		customerData.setCustomerId(2l);
		customerData.setCustomerName("ashwinkumar");
		customerData.setCustomerAddress("mulund west");
		customerData.setCustomerEmail("As@mastek.com");

	}

	@Test
	public void testFindAllNotNull() {
		assertNotNull(customerService.findAll());
	}

	@Test
	public void testCreateNew() {
		assertNotNull(customerService.create(customerData));
	}

	@Test
	public void testFindOneNotNull() {
		Long id = 2l;
		assertNotNull(customerService.findById(id));
	}

	@Test
	public void testFindOneAndDelete() {
		Long id = 3l;
		assertTrue(customerService.delete(id));
	}

	@Test
	public void testFindOneAndUpdate() {
		Long id = 2l;
		assertNotNull(customerService.updateCustomer(customerData, id));
	}

}
