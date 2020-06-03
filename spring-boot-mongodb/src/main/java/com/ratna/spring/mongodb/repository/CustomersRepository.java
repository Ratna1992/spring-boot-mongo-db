package com.ratna.spring.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ratna.spring.mongodb.model.Customers;

@Repository
public interface CustomersRepository extends MongoRepository<Customers, Integer> {

	List<Customers> findByAddress(String address);

	@Query("{'rentals.filmTitle':?0}")
	List<Customers> findByRentals(String filmTitle);

	List<Customers> findByFirstName(String firstName);

}
