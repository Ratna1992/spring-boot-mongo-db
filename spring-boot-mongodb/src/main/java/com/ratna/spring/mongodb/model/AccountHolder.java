package com.ratna.spring.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "accountHolder")
public class AccountHolder {

	@Id
	private Integer id;
	private String firstName;
	private Long mobile;
	private String dob;
	private String lastName;

	public Integer getId() {
		return id;
	}

	public AccountHolder() {
	}

	@PersistenceConstructor
	public AccountHolder(Integer id, String firstName, Long mobile, String dob, String lastName, String address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.mobile = mobile;
		this.dob = dob;
		this.lastName = lastName;
		this.address = address;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String address;

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

	@Override
	public String toString() {
		return "AccountHolder [firstName=" + firstName + ", mobile=" + mobile + ", dob=" + dob + ", lastName="
				+ lastName + ", address=" + address + "]";
	}

}
