package com.ratna.spring.mongodb.service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ratna.spring.mongodb.model.Stores;

@Repository
public interface StoresRepository extends MongoRepository<Stores, Integer> {

}
