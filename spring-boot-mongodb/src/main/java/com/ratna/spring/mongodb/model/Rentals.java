package com.ratna.spring.mongodb.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

public class Rentals {
	
	@Field(name="Film Title")
	private String filmTitle;
	@Field(name="Rental Date")
	private String rentalDate;
	@Field(name="Return Date")
	private String returnDate;
	private Integer filmId;
	private Integer rentalId;
	private Integer staffId;
	@Field(name="Payments")
	private List<Payments> payments;
	public String getFilmTitle() {
		return filmTitle;
	}
	public void setFilmTitle(String filmTitle) {
		this.filmTitle = filmTitle;
	}
	public String getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(String rentalDate) {
		this.rentalDate = rentalDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public Integer getFilmId() {
		return filmId;
	}
	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}
	public Integer getRentalId() {
		return rentalId;
	}
	public void setRentalId(Integer rentalId) {
		this.rentalId = rentalId;
	}
	public Integer getStaffId() {
		return staffId;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}
	public List<Payments> getPayments() {
		return payments;
	}
	public void setPayments(List<Payments> payments) {
		this.payments = payments;
	}
	@Override
	public String toString() {
		return "Rentals [filmTitle=" + filmTitle + ", rentalDate=" + rentalDate + ", returnDate=" + returnDate
				+ ", filmId=" + filmId + ", rentalId=" + rentalId + ", staffId=" + staffId + "]";
	}
	
	
	

}
