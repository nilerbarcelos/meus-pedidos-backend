package com.nilerbarcelos.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nilerbarcelos.model.Customer;
import com.nilerbarcelos.service.CustomerService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping(method = GET)
	public ResponseEntity<?> getCustomers() {
		Collection<Customer> customers;
		try {
			customers = customerService.getCustomers();
		} catch (Exception message) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message.getMessage());
		}
		return new ResponseEntity<Collection<Customer>>(customers, HttpStatus.OK);
	}
}
