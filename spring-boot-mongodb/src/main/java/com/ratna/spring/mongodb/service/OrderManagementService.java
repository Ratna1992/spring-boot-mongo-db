package com.ratna.spring.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratna.spring.mongodb.exceptions.NoUserOrderDataException;
import com.ratna.spring.mongodb.model.User;
import com.ratna.spring.mongodb.repository.OrderManagementRepository;

@Service
public class OrderManagementService implements OrderManagementServiceInterface {

	@Autowired
	OrderManagementRepository orderManagementRepository;

	public User placeOrder(User user) throws NoUserOrderDataException {
		return orderManagementRepository.save(user);
	}

	public List<User> fetchOrder() throws NoUserOrderDataException {
		return orderManagementRepository.findAll();
	}

}
