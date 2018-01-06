package com.globaltade.talent.exception;

public class PersistenceException extends Exception {

	private static final long serialVersionUID = 1L;

	private String message;

	public PersistenceException(String message) {
		super(message);
		this.message = message;
	}
	
	public PersistenceException(String message, Throwable t) {
		super(message,t);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
