package com.globaltade.talent.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Cat_Adress")
public class Adress {

	@Id
	@GenericGenerator(name = "genAdress", strategy = "increment")
	@GeneratedValue(generator = "genAdress")
	@Column(name = "nb_idAdress")
	private Integer nbIdAdress;

	@Column(name = "tx_street")
	private String txStreet;

	@Column(name = "tx_numberExt")
	private String txNumberExt;

	@Column(name = "tx_numberInt")
	private String txNumberInt;

	@Column(name = "tx_suburb")
	private String txSuburb;

	@Column(name = "nb_zipCode")
	private Integer nbZipCode;

	@Column(name = "tx_town")
	private String txTown;

	@Column(name = "tx_city")
	private String txCity;

	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
	@Type(type = "timestamp")
	@Column(name = "dt_creationDate", nullable = false)
	private Date dtCreationDate;

	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
	@Type(type = "timestamp")
	@Column(name = "dt_updateDate")
	private Date dtUpdateDate;

	@Column(name = "nb_status", nullable = false)
	private Integer nbStatus;

	public Adress() {
		super();
	}

	/**
	 * @param nbIdAdress
	 * @param txStreet
	 * @param txNumberExt
	 * @param txNumberInt
	 * @param txSuburb
	 * @param nbZipCode
	 * @param txTown
	 * @param txCity
	 * @param dtCreationDate
	 * @param dtUpdateDate
	 * @param nbStatus
	 */
	public Adress(Integer nbIdAdress, String txStreet, String txNumberExt, String txNumberInt, String txSuburb,
			Integer nbZipCode, String txTown, String txCity, Date dtCreationDate, Date dtUpdateDate, Integer nbStatus) {
		super();
		this.nbIdAdress = nbIdAdress;
		this.txStreet = txStreet;
		this.txNumberExt = txNumberExt;
		this.txNumberInt = txNumberInt;
		this.txSuburb = txSuburb;
		this.nbZipCode = nbZipCode;
		this.txTown = txTown;
		this.txCity = txCity;
		this.dtCreationDate = dtCreationDate;
		this.dtUpdateDate = dtUpdateDate;
		this.nbStatus = nbStatus;
	}

	/**
	 * @return the nbIdAdress
	 */
	public Integer getNbIdAdress() {
		return nbIdAdress;
	}

	/**
	 * @param nbIdAdress
	 *            the nbIdAdress to set
	 */
	public void setNbIdAdress(Integer nbIdAdress) {
		this.nbIdAdress = nbIdAdress;
	}

	/**
	 * @return the txStreet
	 */
	public String getTxStreet() {
		return txStreet;
	}

	/**
	 * @param txStreet
	 *            the txStreet to set
	 */
	public void setTxStreet(String txStreet) {
		this.txStreet = txStreet;
	}

	/**
	 * @return the txNumberExt
	 */
	public String getTxNumberExt() {
		return txNumberExt;
	}

	/**
	 * @param txNumberExt
	 *            the txNumberExt to set
	 */
	public void setTxNumberExt(String txNumberExt) {
		this.txNumberExt = txNumberExt;
	}

	/**
	 * @return the txNumberInt
	 */
	public String getTxNumberInt() {
		return txNumberInt;
	}

	/**
	 * @param txNumberInt
	 *            the txNumberInt to set
	 */
	public void setTxNumberInt(String txNumberInt) {
		this.txNumberInt = txNumberInt;
	}

	/**
	 * @return the txSuburb
	 */
	public String getTxSuburb() {
		return txSuburb;
	}

	/**
	 * @param txSuburb
	 *            the txSuburb to set
	 */
	public void setTxSuburb(String txSuburb) {
		this.txSuburb = txSuburb;
	}

	/**
	 * @return the nbZipCode
	 */
	public Integer getNbZipCode() {
		return nbZipCode;
	}

	/**
	 * @param nbZipCode
	 *            the nbZipCode to set
	 */
	public void setNbZipCode(Integer nbZipCode) {
		this.nbZipCode = nbZipCode;
	}

	/**
	 * @return the txTown
	 */
	public String getTxTown() {
		return txTown;
	}

	/**
	 * @param txTown
	 *            the txTown to set
	 */
	public void setTxTown(String txTown) {
		this.txTown = txTown;
	}

	/**
	 * @return the txCity
	 */
	public String getTxCity() {
		return txCity;
	}

	/**
	 * @param txCity
	 *            the txCity to set
	 */
	public void setTxCity(String txCity) {
		this.txCity = txCity;
	}

	/**
	 * @return the dtCreationDate
	 */
	public Date getDtCreationDate() {
		return dtCreationDate;
	}

	/**
	 * @param dtCreationDate
	 *            the dtCreationDate to set
	 */
	public void setDtCreationDate(Date dtCreationDate) {
		this.dtCreationDate = dtCreationDate;
	}

	/**
	 * @return the dtUpdateDate
	 */
	public Date getDtUpdateDate() {
		return dtUpdateDate;
	}

	/**
	 * @param dtUpdateDate
	 *            the dtUpdateDate to set
	 */
	public void setDtUpdateDate(Date dtUpdateDate) {
		this.dtUpdateDate = dtUpdateDate;
	}

	/**
	 * @return the nbStatus
	 */
	public Integer getNbStatus() {
		return nbStatus;
	}

	/**
	 * @param nbStatus
	 *            the nbStatus to set
	 */
	public void setNbStatus(Integer nbStatus) {
		this.nbStatus = nbStatus;
	}

}
