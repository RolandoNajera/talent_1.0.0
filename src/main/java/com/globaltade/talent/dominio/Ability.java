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
@Table(name = "Cat_Ability")
public class Ability {

	@Id
	@GenericGenerator(name = "genHability", strategy = "increment")
	@GeneratedValue(generator = "genHability")
	@Column(name = "nb_idAbility")
	private Integer nbIdAbility;

	@Column(name = "tx_name")
	private String txName;

	@Column(name = "tx_type")
	private String txType;

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

	public Ability() {
		super();
	}

	/**
	 * @param nbIdHability
	 * @param txName
	 * @param txType
	 * @param dtCreationDate
	 * @param dtUpdateDate
	 * @param nbStatus
	 */
	public Ability(Integer nbIdAbility, String txName, String txType, Date dtCreationDate, Date dtUpdateDate,
			Integer nbStatus) {
		super();
		this.nbIdAbility = nbIdAbility;
		this.txName = txName;
		this.txType = txType;
		this.dtCreationDate = dtCreationDate;
		this.dtUpdateDate = dtUpdateDate;
		this.nbStatus = nbStatus;
	}

	/**
	 * @return the nbIdAbility
	 */
	public Integer getNbIdAbility() {
		return nbIdAbility;
	}

	/**
	 * @param nbIdAbility
	 *            the nbIdAbility to set
	 */
	public void setNbIdAbility(Integer nbIdAbility) {
		this.nbIdAbility = nbIdAbility;
	}

	/**
	 * @return the txName
	 */
	public String getTxName() {
		return txName;
	}

	/**
	 * @param txName
	 *            the txName to set
	 */
	public void setTxName(String txName) {
		this.txName = txName;
	}

	/**
	 * @return the txType
	 */
	public String getTxType() {
		return txType;
	}

	/**
	 * @param txType
	 *            the txType to set
	 */
	public void setTxType(String txType) {
		this.txType = txType;
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
