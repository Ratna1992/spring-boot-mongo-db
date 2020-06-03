package com.ratna.spring.mongodb.exceptions;

public class NoStaffDataException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoStaffDataException(String message) {
		super(message);
	}

}
