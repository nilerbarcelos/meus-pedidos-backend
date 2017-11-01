package com.nilerbarcelos.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nilerbarcelos.model.Customer;
import com.nilerbarcelos.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	public Collection<Customer> getCustomers() {
		return customerRepository.findAll();
	}
}
