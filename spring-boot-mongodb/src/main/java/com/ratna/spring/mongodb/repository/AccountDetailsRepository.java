package com.ratna.spring.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ratna.spring.mongodb.model.AccountDetails;

@Repository
public interface AccountDetailsRepository extends MongoRepository<AccountDetails, Integer> {

	@Query("{'regionDetails.area':?0}")
	public List<AccountDetails> findByRegionDetails(String area);

	List<AccountDetails> findByAccountType(String accountType);

}
