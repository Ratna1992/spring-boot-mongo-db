package com.ratna.spring.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ratna.spring.mongodb.exceptions.DataLoadDataException;
import com.ratna.spring.mongodb.exceptions.NoAccountDetailsDataException;
import com.ratna.spring.mongodb.exceptions.NoAccountHolderDataException;
import com.ratna.spring.mongodb.exceptions.NoRegionDetailsDataException;
import com.ratna.spring.mongodb.model.AccountDetails;
import com.ratna.spring.mongodb.model.AccountHolder;
import com.ratna.spring.mongodb.model.RegionDetails;
import com.ratna.spring.mongodb.service.AccountHolderService;
import com.ratna.spring.mongodb.service.CsvProcessingService;

@RestController
public class AccountController {

	@Autowired
	CsvProcessingService csvProcessingService;
	@Autowired
	AccountHolderService accountHolderService;

	@GetMapping("/loadData")
	public String loadData() {
		try {
			return csvProcessingService.loadDataIntoDatabase();
		} catch (DataLoadDataException e) {
			throw new DataLoadDataException("Failed while dumping data from file");
		}
	}

	@GetMapping("/get/acc/holder/region/{region}")
	public List<AccountHolder> getAccountHolders(@PathVariable String region) {
		try {
			return accountHolderService.getAccountHoldersToSpecificRegion(region);
		} catch (NoAccountHolderDataException e) {
			throw new NoAccountHolderDataException("No Account Holders for available " + region);
		}
	}

	@GetMapping("/get/region/{region}")
	public List<RegionDetails> getRegionInformation(@PathVariable String region) {
		try {
			return accountHolderService.getRegions(region);
		} catch (NoRegionDetailsDataException e) {
			throw new NoRegionDetailsDataException("No Regions available with " + region);
		}
	}

	@GetMapping("/get/all/accounts")
	public List<AccountDetails> getAllAccounts() {
		try {
			return accountHolderService.getAllAccounts();
		} catch (NoAccountDetailsDataException e) {
			throw new NoAccountDetailsDataException("No Accounts Available");
		}
	}

	@GetMapping("/get/account/{id}")
	public AccountDetails getAccountById(@PathVariable Integer id) {
		try {
			return accountHolderService.getAccountHolderById(id);
		} catch (NoAccountDetailsDataException e) {
			throw new NoAccountDetailsDataException("No Accounts Available for Id ::" + id);
		}
	}

	@GetMapping("/get/account/{id}/name/{name}")
	public AccountDetails updateAccountHolderName(@PathVariable Integer id, @PathVariable String name) {
		try {
			return accountHolderService.updateAccountDetails(id, name);
		} catch (NoAccountDetailsDataException e) {
			throw new NoAccountDetailsDataException("Unable to update Account Holder name for Id ::" + id);
		}
	}

	@GetMapping("/get/account/by/type/{type}")
	public List<AccountDetails> getAccountById(@PathVariable String type) {
		try {
			return accountHolderService.getAccountHolderByType(type);
		} catch (NoAccountDetailsDataException e) {
			throw new NoAccountDetailsDataException("No Accounts Available");
		}
	}

}
