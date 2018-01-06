package com.globaltade.talent.transaction;

import java.util.List;

import com.globaltade.talent.dominio.User;

public class TransactionUser {

	private User user;
	private List<User> listUser;
	private Integer totalResult;
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
	public TransactionUser(User user, List<User> listUser, Integer totalResult, String responseCode,
			String descriptionCode, boolean isUnique) {
		super();
		this.user = user;
		this.listUser = listUser;
		this.totalResult = totalResult;
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
	 * @return the listUser
	 */
	public List<User> getListUser() {
		return listUser;
	}

	/**
	 * @param listUser
	 *            the listUser to set
	 */
	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}

	/**
	 * @return the totalResult
	 */
	public Integer getTotalResult() {
		return totalResult;
	}

	/**
	 * @param totalResult
	 *            the totalResult to set
	 */
	public void setTotalResult(Integer totalResult) {
		this.totalResult = totalResult;
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
