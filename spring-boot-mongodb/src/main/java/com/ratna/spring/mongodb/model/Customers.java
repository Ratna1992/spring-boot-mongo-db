package com.ratna.spring.mongodb.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "customers")
public class Customers {

	@Id
	@Field(name = "_id")
	private Integer id;
	@Field(name = "First Name")
	private String firstName;
	@Field(name = "Phone")
	private String phone;
	@Field(name = "Address")
	private String address;
	@Field(name = "Last Name")
	private String lastName;
	@Field(name = "City")
	private String city;
	@Field(name = "Country")
	private String country;
	@Field(name = "District")
	private String district;
	@Field(name="Rentals")
	private List<Rentals> rentals;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public List<Rentals> getRentals() {
		return rentals;
	}
	public void setRentals(List<Rentals> rentals) {
		this.rentals = rentals;
	}
	@Override
	public String toString() {
		return "Customers [id=" + id + ", firstName=" + firstName + ", phone=" + phone + ", address=" + address
				+ ", lastName=" + lastName + ", city=" + city + ", country=" + country + ", district=" + district + "]";
	}
	
}
