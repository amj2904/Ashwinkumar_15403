package com.training.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.training.ecommerce.dao.ICustomerRepository;
import com.training.ecommerce.dto.CustomerData;

import com.training.ecommerce.model.Customer;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;

	// DTO=>Entity
	private Customer getCustomerEntity(CustomerData customerData) {
		Customer customer = new Customer();
		customer.setCustomerId(customerData.getCustomerId());
		customer.setCustomerName(customerData.getCustomerName());
		customer.setCustomerEmail(customerData.getCustomerEmail());
		customer.setCustomerAddress(customerData.getCustomerAddress());
		return customer;
	}

//	Entity=>DTO
	private CustomerData getCustomerData(Customer customer) {
		CustomerData customerData = new CustomerData();
		customerData.setCustomerId(customer.getCustomerId());
		customerData.setCustomerName(customer.getCustomerName());
		customerData.setCustomerEmail(customer.getCustomerEmail());
		customerData.setCustomerAddress(customer.getCustomerAddress());

		return customerData;

	}

	@Override
	public List<CustomerData> findAll() {

		List<CustomerData> customerDataList = new ArrayList<>();
		List<Customer> customers = customerRepository.findAll();
		customers.forEach(customer -> {
			customerDataList.add(getCustomerData(customer));
		});

		return customerDataList;
	}

	@Override
	public CustomerData findById(Long id) {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		if (customerOptional == null) {
			new EntityNotFoundException("Customer Not Found");

		}
		return getCustomerData(customerOptional.get());
	}

	@Override
	public CustomerData create(CustomerData customerData) {
		Customer customer = getCustomerEntity(customerData);

		return getCustomerData(customerRepository.save(customer));
	}

	@Override
	public boolean delete(Long id) {

		Customer customer = customerRepository.findById(id).get();
		if (customer != null) {
			customerRepository.deleteById(id);
			return true;

		} else {
			return false;
		}

	}

	public CustomerData updateCustomer(CustomerData customerData, Long productId) {
		Customer customer = customerRepository.findById(productId).get();
		if (customer != null) {
			customer.setCustomerName(customerData.getCustomerName());
			customer.setCustomerEmail(customerData.getCustomerEmail());
			customer.setCustomerAddress(customerData.getCustomerAddress());
			customerRepository.save(customer);

			return getCustomerData(customer);
		} else {
			return null;
		}

	}

}
