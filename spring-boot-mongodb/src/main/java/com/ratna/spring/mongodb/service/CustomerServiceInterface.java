package com.ratna.spring.mongodb.service;

import java.util.List;

import com.ratna.spring.mongodb.model.Customers;
import com.ratna.spring.mongodb.model.Payments;

public interface CustomerServiceInterface {

	List<Customers> findByAddress(String address);

	List<Customers> findByRentals(String title);

	List<Payments> findByFirstName(String firstName);
}
