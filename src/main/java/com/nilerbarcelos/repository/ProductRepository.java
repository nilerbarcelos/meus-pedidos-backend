package com.nilerbarcelos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nilerbarcelos.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
