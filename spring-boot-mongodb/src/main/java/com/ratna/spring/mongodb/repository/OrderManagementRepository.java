package com.ratna.spring.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ratna.spring.mongodb.model.User;

@Repository
public interface OrderManagementRepository extends MongoRepository<User, Integer> {

}
