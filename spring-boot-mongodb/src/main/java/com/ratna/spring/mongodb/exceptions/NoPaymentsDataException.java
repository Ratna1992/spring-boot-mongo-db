package com.ratna.spring.mongodb.exceptions;

public class NoPaymentsDataException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoPaymentsDataException(String message) {
		super(message);
	}

}
