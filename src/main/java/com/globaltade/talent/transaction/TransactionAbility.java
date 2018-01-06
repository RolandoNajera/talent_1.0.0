package com.globaltade.talent.transaction;

import java.util.List;

import com.globaltade.talent.dominio.Ability;

public class TransactionAbility {

	private Ability hability;
	private List<Ability> listHability;
	private Integer totalResult;
	private String errorCode;
	private String descriptionCode;
	private boolean isUnique;

	/**
	 * 
	 */
	public TransactionAbility() {
		super();
	}

	/**
	 * @return the hability
	 */
	public Ability getHability() {
		return hability;
	}

	/**
	 * @param hability
	 *            the hability to set
	 */
	public void setHability(Ability hability) {
		this.hability = hability;
	}

	/**
	 * @return the listHability
	 */
	public List<Ability> getListHability() {
		return listHability;
	}

	/**
	 * @param listHability
	 *            the listHability to set
	 */
	public void setListHability(List<Ability> listHability) {
		this.listHability = listHability;
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
