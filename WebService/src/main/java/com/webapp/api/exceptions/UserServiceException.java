package com.webapp.api.exceptions;

public class UserServiceException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5900488610814438378L;

	public UserServiceException( String message) {
		super(message);
	}

}
