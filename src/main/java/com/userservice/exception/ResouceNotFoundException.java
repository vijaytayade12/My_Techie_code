package com.userservice.exception;

public class ResouceNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResouceNotFoundException() {
		super("Resource not found on server !!");
	}
	
	public ResouceNotFoundException(String message) {
		super(message);
	}

}
