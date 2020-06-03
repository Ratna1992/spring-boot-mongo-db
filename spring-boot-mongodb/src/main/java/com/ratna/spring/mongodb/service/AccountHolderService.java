package com.ratna.spring.mongodb.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import com.ratna.spring.mongodb.exceptions.NoAccountDetailsDataException;
import com.ratna.spring.mongodb.exceptions.NoAccountHolderDataException;
import com.ratna.spring.mongodb.exceptions.NoRegionDetailsDataException;
import com.ratna.spring.mongodb.model.AccountDetails;
import com.ratna.spring.mongodb.model.AccountHolder;
import com.ratna.spring.mongodb.model.RegionDetails;
import com.ratna.spring.mongodb.repository.AccountDetailsRepository;

@Service
public class AccountHolderService implements AccountHolderServiceInterface {
	@Autowired
	MongoTemplate template;
	@Autowired
	AccountDetailsRepository accountDetailsRepository;

	public List<AccountDetails> getAllAccounts() throws NoAccountDetailsDataException {
		return accountDetailsRepository.findAll();
	}

	public List<AccountHolder> getAccountHoldersToSpecificRegion(String region) throws NoAccountHolderDataException {
		return accountDetailsRepository.findByRegionDetails(region).stream().map(AccountDetails::getAccountHolder)
				.collect(Collectors.toList());
	}

	public List<RegionDetails> getRegions(String region) throws NoRegionDetailsDataException {
		return accountDetailsRepository.findByRegionDetails(region).stream().map(AccountDetails::getRegionDetails)
				.collect(Collectors.toList());
	}

	public AccountDetails getAccountHolderById(Integer id) throws NoAccountDetailsDataException {
		return template.findById(id, AccountDetails.class);
	}

	public AccountDetails updateAccountDetails(Integer id, String name) throws NoAccountDetailsDataException {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		Update update = new Update();
		update.set("accountHolder.firstName", name);
		return template.findAndModify(query, update, AccountDetails.class);
	}

	public List<AccountDetails> getAccountHolderByType(String type) throws NoAccountDetailsDataException {
		return accountDetailsRepository.findByAccountType(type);
	}

}
