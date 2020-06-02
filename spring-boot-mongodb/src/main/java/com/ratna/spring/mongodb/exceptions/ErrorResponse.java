package com.ratna.spring.mongodb.exceptions;

import java.time.LocalDate;

public class ErrorResponse {

	private String msg;
	private LocalDate timeStamp;
	private Integer status;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public LocalDate getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDate timeStamp) {
		this.timeStamp = timeStamp;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ErrorResponse [msg=" + msg + ", timeStamp=" + timeStamp + ", status=" + status + "]";
	}
	
	
}
