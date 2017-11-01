package com.nilerbarcelos.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nilerbarcelos.model.Product;
import com.nilerbarcelos.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Collection<Product> getProducts() {
		return productRepository.findAll();
	}
}
