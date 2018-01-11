package com.globaltade.talent.transaction;

import java.util.List;

import com.globaltade.talent.dominio.Profile;

public class TransactionProfile {

	private Profile profile;
	private List<Profile> listProfile;
	private Integer totalResult;
	private String responseCode;
	private String descriptionCode;
	private boolean exist;

	/**
	 * 
	 */
	public TransactionProfile() {
		super();
	}

	/**
	 * @param profile
	 * @param listProfile
	 * @param totalResult
	 * @param responseCode
	 * @param descriptionCode
	 * @param exist
	 */
	public TransactionProfile(Profile profile, List<Profile> listProfile, Integer totalResult, String responseCode,
			String descriptionCode, boolean exist) {
		super();
		this.profile = profile;
		this.listProfile = listProfile;
		this.totalResult = totalResult;
		this.responseCode = responseCode;
		this.descriptionCode = descriptionCode;
		this.exist = exist;
	}

	/**
	 * @return the profile
	 */
	public Profile getProfile() {
		return profile;
	}

	/**
	 * @param profile
	 *            the profile to set
	 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	/**
	 * @return the listProfile
	 */
	public List<Profile> getListProfile() {
		return listProfile;
	}

	/**
	 * @param listProfile
	 *            the listProfile to set
	 */
	public void setListProfile(List<Profile> listProfile) {
		this.listProfile = listProfile;
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
