package com.cgi.exceptions;

public class MovieException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MovieException() {
		super();
	}

	public MovieException(String error) {
		super(error);
	}
}
