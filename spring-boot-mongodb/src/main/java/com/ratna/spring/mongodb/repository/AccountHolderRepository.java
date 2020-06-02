package com.ratna.spring.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ratna.spring.mongodb.model.AccountHolder;

public interface AccountHolderRepository extends MongoRepository<AccountHolder, Integer> {
}
