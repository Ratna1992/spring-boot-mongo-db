package com.ratna.spring.mongodb.service;

import java.util.List;

import com.ratna.spring.mongodb.model.AccountDetails;
import com.ratna.spring.mongodb.model.AccountHolder;
import com.ratna.spring.mongodb.model.RegionDetails;

public interface AccountHolderServiceInterface {

	public List<AccountDetails> getAllAccounts();

	public List<AccountHolder> getAccountHoldersToSpecificRegion(String region);

	public List<RegionDetails> getRegions(String region);

	public AccountDetails getAccountHolderById(Integer id);

	public AccountDetails updateAccountDetails(Integer id, String name);

	public List<AccountDetails> getAccountHolderByType(String type);

}
