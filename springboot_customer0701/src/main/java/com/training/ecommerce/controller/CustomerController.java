package com.training.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.ecommerce.dto.CustomerData;
import com.training.ecommerce.model.Customer;
import com.training.ecommerce.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping
	public List<CustomerData> findAll() {
		return customerService.findAll();
	}

	@GetMapping("/customer/{id}")
	public CustomerData findById(@PathVariable Long id) {
		return customerService.findById(id);
	}

	@PostMapping("/customer")
	public CustomerData create(@RequestBody CustomerData customerData) {
		return customerService.create(customerData);

	}

	@DeleteMapping("customer/{id}")
	public boolean delete(@PathVariable Long id) {
		return customerService.delete(id);
	}

	@PutMapping("customer/{id}")
	public CustomerData updateCustomer(@RequestBody CustomerData customerData, @PathVariable("id") Long customerId) {
		return customerService.updateCustomer(customerData, customerId);

	}

}
