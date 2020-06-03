package com.ratna.spring.mongodb.exceptions;

public class NoInventoryDataException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoInventoryDataException(String message) {
		super(message);
	}

}
