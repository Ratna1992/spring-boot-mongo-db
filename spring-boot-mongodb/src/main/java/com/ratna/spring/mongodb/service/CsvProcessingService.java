package com.ratna.spring.mongodb.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.ratna.spring.mongodb.model.AccountCSVFile;
import com.ratna.spring.mongodb.model.AccountDetails;
import com.ratna.spring.mongodb.model.AccountHolder;
import com.ratna.spring.mongodb.model.RegionDetails;

@Service
public class CsvProcessingService {
	@Autowired
	ResourceLoader resourceLoader;

	@Autowired
	MongoTemplate template;

	public String loadDataIntoDatabase() {
		String msg = "Loaded Data Successfully...";

		Resource resource = resourceLoader.getResource("classpath:accountdetails.csv");
		File file = null;
		try {
			file = resource.getFile();
		} catch (IOException e) {
			msg = e.getMessage();
		}
		Reader reader = null;
		try {
			reader = new FileReader(file);
		} catch (FileNotFoundException e) {
			msg = e.getMessage();
		}
		CsvToBean<AccountCSVFile> csvToBean = new CsvToBeanBuilder<AccountCSVFile>(reader)
				.withType(AccountCSVFile.class).withIgnoreLeadingWhiteSpace(true).build();

		List<AccountCSVFile> parse = csvToBean.parse();

		List<AccountDetails> list = new ArrayList<>();

		parse.forEach(obj -> {
			int nextInt = new Random().nextInt(10000);
			// Account Details
			AccountDetails accountDetails = new AccountDetails();
			accountDetails.setId(nextInt + 7);
			accountDetails.setAccountNumber(obj.getAccountNumber());
			accountDetails.setAccountType(obj.getAccountType());
			accountDetails.setIfsc(obj.getIfsc());
			accountDetails.setTransferLimit(obj.getTransferLimit());

			// Account Holder Info
			AccountHolder accountHolder = new AccountHolder();
			accountHolder.setId(new Random().nextInt(10000) + 2);
			accountHolder.setAddress(obj.getAddress());
			accountHolder.setDob(obj.getDob());
			accountHolder.setFirstName(obj.getFirstName());
			accountHolder.setLastName(obj.getLastName());
			accountHolder.setMobile(obj.getMobile());
			accountDetails.setAccountHolder(accountHolder);

			// RegionDetails
			RegionDetails regionDetails = new RegionDetails();
			regionDetails.setId(new Random().nextInt(1000) + 4);
			regionDetails.setArea(obj.getArea());
			regionDetails.setCountry(obj.getCountry());
			regionDetails.setPinCode(obj.getPinCode());
			regionDetails.setState(obj.getState());
			accountDetails.setRegionDetails(regionDetails);
			list.add(accountDetails);

		});

		template.insertAll(list);

		return msg;
	}

}
