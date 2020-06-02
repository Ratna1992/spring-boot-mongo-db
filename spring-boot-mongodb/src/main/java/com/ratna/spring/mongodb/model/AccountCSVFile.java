package com.ratna.spring.mongodb.model;

import com.opencsv.bean.CsvBindByName;

public class AccountCSVFile {

	@CsvBindByName
	private String accountNumber;
	@CsvBindByName
	private String accountType;
	@CsvBindByName
	private String ifsc;
	@CsvBindByName
	private Double transferLimit;
	@CsvBindByName
	private String firstName;
	@CsvBindByName
	private Long mobile;
	@CsvBindByName
	private String dob;
	@CsvBindByName
	private String lastName;
	@CsvBindByName
	private String address;
	@CsvBindByName
	private String state;
	@CsvBindByName
	private String country;
	@CsvBindByName
	private String area;
	@CsvBindByName
	private Long pinCode;

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Long getPinCode() {
		return pinCode;
	}

	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "AccountCSVFile [accountNumber=" + accountNumber + ", accountType=" + accountType + ", ifsc=" + ifsc
				+ ", transferLimit=" + transferLimit + ", firstName=" + firstName + ", mobile=" + mobile + ", dob="
				+ dob + ", lastName=" + lastName + ", address=" + address + ", state=" + state + ", country=" + country
				+ ", area=" + area + ", pinCode=" + pinCode + "]";
	}

}
