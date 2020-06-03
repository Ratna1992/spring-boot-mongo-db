package com.ratna.spring.mongodb.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "stores")
public class Stores {

	@Id
	@Field("_id")
	private Integer id;
	@Field(name = "Address")
	private String address;
	@Field(name = "City")
	private String city;
	@Field(name = "Country")
	private String country;
	@Field(name = "Manager First Name")
	private String mfName;
	@Field(name = "Manager Last Name")
	private String mlName;
	@Field(name = "Phone")
	private Long phone;
	private Integer managerStaffId;
	@Field(name = "Staff")
	private List<Staff> staff;
	@Field(name = "Inventory")
	private List<Inventory> inventory;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getMfName() {
		return mfName;
	}

	public void setMfName(String mfName) {
		this.mfName = mfName;
	}

	public String getMlName() {
		return mlName;
	}

	public void setMlName(String mlName) {
		this.mlName = mlName;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Integer getManagerStaffId() {
		return managerStaffId;
	}

	public void setManagerStaffId(Integer managerStaffId) {
		this.managerStaffId = managerStaffId;
	}

	public List<Staff> getStaff() {
		return staff;
	}

	public void setStaff(List<Staff> staff) {
		this.staff = staff;
	}

	public List<Inventory> getInventory() {
		return inventory;
	}

	public void setInventory(List<Inventory> inventory) {
		this.inventory = inventory;
	}
}
