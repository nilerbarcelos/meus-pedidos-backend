package com.nilerbarcelos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nilerbarcelos.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
