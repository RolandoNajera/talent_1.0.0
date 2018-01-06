package com.globaltade.talent.transaction;

import java.util.List;

import com.globaltade.talent.dominio.Adress;

public class TransactionAdress {

	private Adress adress;
	private List<Adress> listAdress;
	private Integer totalResult;
	private String responseCode;
	private String descriptionCode;
	private boolean exist;

	/**
	 * 
	 */
	public TransactionAdress() {
		super();
	}

	/**
	 * @param adress
	 * @param listAdress
	 * @param totalResult
	 * @param responseCode
	 * @param descriptionCode
	 * @param exist
	 */
	public TransactionAdress(Adress adress, List<Adress> listAdress, Integer totalResult, String responseCode,
			String descriptionCode, boolean exist) {
		super();
		this.adress = adress;
		this.listAdress = listAdress;
		this.totalResult = totalResult;
		this.responseCode = responseCode;
		this.descriptionCode = descriptionCode;
		this.exist = exist;
	}

	/**
	 * @return the adress
	 */
	public Adress getAdress() {
		return adress;
	}

	/**
	 * @param adress
	 *            the adress to set
	 */
	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	/**
	 * @return the listAdress
	 */
	public List<Adress> getListAdress() {
		return listAdress;
	}

	/**
	 * @param listAdress
	 *            the listAdress to set
	 */
	public void setListAdress(List<Adress> listAdress) {
		this.listAdress = listAdress;
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
