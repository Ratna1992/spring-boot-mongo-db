package com.ratna.spring.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "account")
public class AccountDetails {
	@Id
	private Integer id;
	private String accountNumber;
	private String accountType;
	private String ifsc;
	private Double transferLimit;

	public AccountDetails() {
	}

	@PersistenceConstructor
	public AccountDetails(Integer id, String accountNumber, String accountType, String ifsc, Double transferLimit) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.ifsc = ifsc;
		this.transferLimit = transferLimit;
	}

	@DBRef(db="accountHolder")
	private AccountHolder accountHolder;
	@DBRef(db="regiondetails")
	private RegionDetails regionDetails;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public Double getTransferLimit() {
		return transferLimit;
	}

	public void setTransferLimit(Double transferLimit) {
		this.transferLimit = transferLimit;
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}

	public RegionDetails getRegionDetails() {
		return regionDetails;
	}

	public void setRegionDetails(RegionDetails regionDetails) {
		this.regionDetails = regionDetails;
	}

	@Override
	public String toString() {
		return "AccountDetails [id=" + id + ", accountNumber=" + accountNumber + ", accountType=" + accountType
				+ ", ifsc=" + ifsc + ", transferLimit=" + transferLimit + ", accountHolder=" + accountHolder
				+ ", regionDetails=" + regionDetails + "]";
	}

}
