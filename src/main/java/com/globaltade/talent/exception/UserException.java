package com.globaltade.talent.exception;

public class UserException extends Exception {

	private static final long serialVersionUID = 1L;

	private String errorCode;
	private String descriptionCode;

	public UserException(String errorCode, String descriptionCode) {
		this.errorCode = errorCode;
		this.descriptionCode = descriptionCode;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the descriptionCode
	 */
	public String getDescriptionCode() {
		return descriptionCode;
	}

	/**
	 * @param descriptionCode
	 *            the descriptionCode to set
	 */
	public void setDescriptionCode(String descriptionCode) {
		this.descriptionCode = descriptionCode;
	}

}
