package com.ratna.spring.mongodb.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratna.spring.mongodb.exceptions.NoCustomersDataException;
import com.ratna.spring.mongodb.exceptions.NoPaymentsDataException;
import com.ratna.spring.mongodb.model.Customers;
import com.ratna.spring.mongodb.model.Payments;
import com.ratna.spring.mongodb.repository.CustomersRepository;

@Service
public class CustomerService implements CustomerServiceInterface {

	@Autowired
	CustomersRepository customersRepository;

	@Override
	public List<Customers> findByAddress(String address) throws NoCustomersDataException {
		return customersRepository.findByAddress(address);
	}

	@Override
	public List<Customers> findByRentals(String title) throws NoCustomersDataException {
		List<Customers> findByRentals = customersRepository.findByRentals(title);
		findByRentals.forEach(obj -> {
			obj.getRentals().removeIf(rent -> !rent.getFilmTitle().equalsIgnoreCase(title));
		});
		return findByRentals;

	}

	@Override
	public List<Payments> findByFirstName(String firstName) throws NoPaymentsDataException {
		return customersRepository.findByFirstName(firstName).stream().flatMap(obj -> obj.getRentals().stream())
				.flatMap(obj -> obj.getPayments().stream()).collect(Collectors.toList());
	}

}
