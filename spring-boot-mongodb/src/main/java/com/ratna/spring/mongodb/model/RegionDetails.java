package com.ratna.spring.mongodb.model;

import org.springframework.data.annotation.Id;

public class RegionDetails {
	@Id
	private Integer id;
	private String state;
	private String country;
	private String area;
	private Long pinCode;

	public RegionDetails() {
	}

	public String getState() {
		return state;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return "RegionDetails [state=" + state + ", country=" + country + ", area=" + area + ", pinCode=" + pinCode
				+ "]";
	}

}
