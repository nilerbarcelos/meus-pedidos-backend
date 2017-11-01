package com.nilerbarcelos.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nilerbarcelos.model.Product;
import com.nilerbarcelos.service.ProductService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping(method = GET)
	public ResponseEntity<?> getProducts() {
		Collection<Product> products;
		try {
			products = productService.getProducts();
		} catch (Exception message) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message.getMessage());
		}
		return new ResponseEntity<Collection<Product>>(products, HttpStatus.OK);
	}
}
