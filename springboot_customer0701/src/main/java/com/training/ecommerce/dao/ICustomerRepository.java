package com.training.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.ecommerce.model.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

}
