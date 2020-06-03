package com.ratna.spring.mongodb.exceptions;

public class NoBookDataException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoBookDataException(String message) {
		super(message);
	}
}
