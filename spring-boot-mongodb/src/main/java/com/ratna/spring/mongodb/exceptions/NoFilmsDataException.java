package com.ratna.spring.mongodb.exceptions;

public class NoFilmsDataException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoFilmsDataException(String message) {
		super(message);
	}
}
