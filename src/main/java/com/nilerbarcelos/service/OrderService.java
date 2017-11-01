package com.nilerbarcelos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nilerbarcelos.model.Order;
import com.nilerbarcelos.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public Order insert(Order order) {
		order.getItems().forEach(x -> x.setOrder(order));
		return orderRepository.save(order);
	}
	
	public String calculateProbitability(final double itemPrice, final double productPrice) {
		if (itemPrice > productPrice)
			return "Rentabilidade Ótima";
		else if (productPrice - (productPrice * 0.10) < itemPrice)
			return "Rentabilidade Boa";
		else
			return "Rentabilidade Ruim";
	}
	
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}
	
	public Order getOrder(Long id) {
		return orderRepository.findOne(id);
	}
	
}
