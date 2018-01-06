package com.globaltade.talent.exception;

public class ExperienceException extends Exception {

	private static final long serialVersionUID = 1L;

	private String responseCode;
	private String descriptionCode;

	public ExperienceException(String responseCode, String descriptionCode) {
		this.responseCode = responseCode;
		this.descriptionCode = descriptionCode;
	}

	/**
	 * @return the responseCode
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode
	 *            the responseCode to set
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
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
