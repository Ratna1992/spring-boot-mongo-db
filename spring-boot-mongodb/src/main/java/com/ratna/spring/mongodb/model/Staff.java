package com.ratna.spring.mongodb.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class Staff {

	@Field(name = "Address")
	private String address;
	@Field(name = "City")
	private String city;
	@Field(name = "Country")
	private String country;
	@Field(name = "Phone")
	private Long phone;
	private Integer staffId;
	@Field(name = "First Name")
	private String fname;
	@Field(name = "Last Name")
	private String lname;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "Staff [address=" + address + ", city=" + city + ", country=" + country + ", phone=" + phone
				+ ", staffId=" + staffId + ", fname=" + fname + ", lname=" + lname + "]";
	}

}
