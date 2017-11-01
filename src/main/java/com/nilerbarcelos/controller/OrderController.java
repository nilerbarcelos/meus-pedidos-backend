package com.nilerbarcelos.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nilerbarcelos.model.Order;
import com.nilerbarcelos.service.OrderService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(method = POST)
	public ResponseEntity<Order> postOrder(@RequestBody Order order) {
		orderService.insert(order);
		return new ResponseEntity<Order>(order, HttpStatus.CREATED);
	}

	@RequestMapping(method = GET, value = "/profitability")
	public ResponseEntity<String> getProfitability(@RequestParam("itemPrice") double itemPrice,
			@RequestParam("productPrice") double productPrice) {
		String profitability = orderService.calculateProbitability(itemPrice, productPrice);
		return new ResponseEntity<String>(JSONObject.quote(profitability), HttpStatus.OK);
	}

	@RequestMapping(method = GET)
	public ResponseEntity<List<Order>> getOrders() {
		List<Order> orders = orderService.getAllOrders();
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}

	@RequestMapping(method = GET, value = "/{id}")
	public ResponseEntity<Order> getOrder(@PathVariable Long id) {
		Order order = orderService.getOrder(id);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}

}
