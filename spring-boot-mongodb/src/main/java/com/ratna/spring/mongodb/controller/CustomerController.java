package com.ratna.spring.mongodb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.ratna.spring.mongodb.exceptions.NoCustomersDataException;
import com.ratna.spring.mongodb.exceptions.NoPaymentsDataException;
import com.ratna.spring.mongodb.model.Customers;
import com.ratna.spring.mongodb.model.Payments;
import com.ratna.spring.mongodb.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/get/customers/by/address/{address}")
	public List<Customers> findByAddress(@PathVariable String address) {
		try {
			return customerService.findByAddress(address);
		} catch (NoCustomersDataException e) {
			throw new NoCustomersDataException("No customers data available");
		}
	}

	@GetMapping("/get/customers/rentals/{title}")
	public List<Customers> findByRentals(@PathVariable String title) {
		try {
			return customerService.findByRentals(title);
		} catch (NoCustomersDataException e) {
			throw new NoCustomersDataException("No customers data available");
		}
	}

	@GetMapping("/get/payments/by/name/{firstName}")
	public List<Payments> findByFirstName(@PathVariable String firstName) {
		try {
			return customerService.findByFirstName(firstName);
		} catch (NoPaymentsDataException e) {
			throw new NoPaymentsDataException("No payments data available");
		}
	}

}
