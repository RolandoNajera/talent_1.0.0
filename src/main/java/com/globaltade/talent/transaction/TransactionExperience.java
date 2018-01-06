package com.globaltade.talent.transaction;

import java.util.List;

import com.globaltade.talent.dominio.Experience;

public class TransactionExperience {

	private Experience experience;
	private List<Experience> listExperience;
	private Integer totalResult;
	private String errorCode;
	private String descriptionCode;
	private boolean isUnique;

	/**
	 * 
	 */
	public TransactionExperience() {
		super();
	}

	/**
	 * @return the experience
	 */
	public Experience getExperience() {
		return experience;
	}

	/**
	 * @param experience
	 *            the experience to set
	 */
	public void setExperience(Experience experience) {
		this.experience = experience;
	}

	/**
	 * @return the listExperience
	 */
	public List<Experience> getListExperience() {
		return listExperience;
	}

	/**
	 * @param listExperience
	 *            the listExperience to set
	 */
	public void setListExperience(List<Experience> listExperience) {
		this.listExperience = listExperience;
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

	/**
	 * @return the isUnique
	 */
	public boolean isUnique() {
		return isUnique;
	}

	/**
	 * @param isUnique
	 *            the isUnique to set
	 */
	public void setUnique(boolean isUnique) {
		this.isUnique = isUnique;
	}

}
