package com.nilerbarcelos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nilerbarcelos.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> { 
	
}
