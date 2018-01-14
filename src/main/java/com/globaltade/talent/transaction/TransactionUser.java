package com.globaltade.talent.transaction;

import com.globaltade.talent.dominio.User;

public class TransactionUser {

	private User user;
	private String responseCode;
	private String descriptionCode;
	private boolean exist;

	/**
	 * 
	 */
	public TransactionUser() {
		super();
	}

	/**
	 * 
	 */
	public TransactionUser(User user) {
		super();
		this.user = user;
	}

	/**
	 * @param user
	 * @param listUser
	 * @param totalResult
	 * @param responseCode
	 * @param descriptionCode
	 */
	public TransactionUser(User user, String responseCode, String descriptionCode, boolean isUnique) {
		super();
		this.user = user;
		this.responseCode = responseCode;
		this.descriptionCode = descriptionCode;
		this.exist = isUnique;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
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

	/**
	 * @return the exist
	 */
	public boolean isExist() {
		return exist;
	}

	/**
	 * @param exist
	 *            the exist to set
	 */
	public void setExist(boolean exist) {
		this.exist = exist;
	}

}
