package com.ratna.spring.mongodb.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class Payments {
	@Field(name="Amount")
	private Double amt;
	@Field(name="Payment Id")
	private Integer paymentId;
	@Field(name="Payment Date")
	private String paymentDate;
	public Double getAmt() {
		return amt;
	}
	public void setAmt(Double amt) {
		this.amt = amt;
	}
	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	@Override
	public String toString() {
		return "Payments [amt=" + amt + ", paymentId=" + paymentId + ", paymentDate=" + paymentDate + "]";
	}
	
	

}
