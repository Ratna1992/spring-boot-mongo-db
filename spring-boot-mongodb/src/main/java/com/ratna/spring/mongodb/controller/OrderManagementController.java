package com.ratna.spring.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ratna.spring.mongodb.exceptions.NoUserOrderDataException;
import com.ratna.spring.mongodb.model.User;
import com.ratna.spring.mongodb.service.OrderManagementService;

@RestController
public class OrderManagementController {
	@Autowired
	OrderManagementService orderManagementService;

	@PostMapping("/placeorder")
	public User placeOrder(@RequestBody User user) {
		try {
			return orderManagementService.placeOrder(user);
		} catch (NoUserOrderDataException e) {
			throw new NoUserOrderDataException("Unable tp place order for products ::" + user.getProducts());
		}
	}

	@GetMapping("/fetchorder")
	public List<User> fetchorder() {
		try {
			return orderManagementService.fetchOrder();
		} catch (NoUserOrderDataException e) {
			throw new NoUserOrderDataException("No user data available");
		}
	}

}
