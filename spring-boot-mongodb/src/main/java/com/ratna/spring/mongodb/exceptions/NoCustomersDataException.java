package com.ratna.spring.mongodb.exceptions;

public class NoCustomersDataException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoCustomersDataException(String message) {
		super(message);
	}

}
