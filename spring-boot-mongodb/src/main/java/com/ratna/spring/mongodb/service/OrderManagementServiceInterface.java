package com.ratna.spring.mongodb.service;

import java.util.List;

import com.ratna.spring.mongodb.model.User;

public interface OrderManagementServiceInterface {

	public User placeOrder(User user);

	public List<User> fetchOrder();

}
