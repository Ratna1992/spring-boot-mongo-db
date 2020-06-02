package com.ratna.spring.mongodb.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.ratna.spring.mongodb.model.AccountDetails;
import com.ratna.spring.mongodb.model.AccountHolder;
import com.ratna.spring.mongodb.model.RegionDetails;
import com.ratna.spring.mongodb.repository.AccountDetailsRepository;
import com.ratna.spring.mongodb.repository.AccountHolderRepository;
import com.ratna.spring.mongodb.repository.RegionalDetailsRepository;

@Service
public class AccountHolderService {

	@Autowired
	MongoTemplate template;
	@Autowired
	AccountDetailsRepository accountDetailsRepository;

	@Autowired
	RegionalDetailsRepository regionalDetailsRepository;

	@Autowired
	AccountHolderRepository accountHolderRepository;

	public List<AccountDetails> getAllAccounts() {
		 return accountDetailsRepository.findAll();
	}

	public List<AccountHolder> getAccountHoldersToSpecificRegion(String region) {
		return accountDetailsRepository.findByRegionDetails(region).stream().map(AccountDetails::getAccountHolder)
				.collect(Collectors.toList());
	}

	public List<RegionDetails> getRegions(String region) {
		return regionalDetailsRepository.findByArea(region);

	}

	public AccountDetails getAccountHolderById(Integer id) {
		return template.findById(id, AccountDetails.class);
	}

	public AccountDetails updateAccountDetails(Integer id, String name) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		Update update = new Update();
		update.set("accountHolder.firstName", name);
		return template.findAndModify(query, update, AccountDetails.class);

	}

	public List<AccountDetails> getAccountHolderByType(String type) {
		return accountDetailsRepository.findByAccountType(type);

	}

}
