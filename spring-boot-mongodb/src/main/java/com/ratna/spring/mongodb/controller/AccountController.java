package com.ratna.spring.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
		return csvProcessingService.loadDataIntoDatabase();
	}

	@GetMapping("/get/acc/holder/region/{region}")
	public List<AccountHolder> getAccountHolders(@PathVariable String region) {
		return accountHolderService.getAccountHoldersToSpecificRegion(region);
	}

	@GetMapping("/get/region/{region}")
	public List<RegionDetails> getRegionInformation(@PathVariable String region) {
		return accountHolderService.getRegions(region);
	}

	@GetMapping("/get/all/accounts")
	public List<AccountDetails> getAllAccounts() {
		return accountHolderService.getAllAccounts();
	}

	@GetMapping("/get/account/{id}")
	public AccountDetails getAccountById(@PathVariable Integer id) {
		return accountHolderService.getAccountHolderById(id);
	}

	@GetMapping("/get/account/{id}/name/{name}")
	public AccountDetails updateAccountHolderName(@PathVariable Integer id, @PathVariable String name) {
		return accountHolderService.updateAccountDetails(id, name);
	}

	@GetMapping("/get/account/by/type/{type}")
	public List<AccountDetails> getAccountById(@PathVariable String type) {
		return accountHolderService.getAccountHolderByType(type);
	}

}
