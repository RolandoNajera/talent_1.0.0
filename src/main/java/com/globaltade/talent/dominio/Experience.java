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
@Table(name = "Cat_Experience")
public class Experience {

	@Id
	@GenericGenerator(name = "genExperience", strategy = "increment")
	@GeneratedValue(generator = "genExperience")
	@Column(name = "nb_idExperience")
	private Integer nbIdExperience;

	@Column(name = "tx_company")
	private String txCompany;

	@Column(name = "tx_project")
	private String txProject;

	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
	@Type(type = "timestamp")
	@Column(name = "dt_startDate", nullable = false)
	private Date dtStartDate;

	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
	@Type(type = "timestamp")
	@Column(name = "dt_endDate", nullable = false)
	private Date dtEndDate;

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

	public Experience() {
		super();
	}

	/**
	 * @param nbIdExperience
	 * @param txCompany
	 * @param txProject
	 * @param dtStartDate
	 * @param dtEndDate
	 * @param dtCreationDate
	 * @param dtUpdateDate
	 * @param nbStatus
	 */
	public Experience(Integer nbIdExperience, String txCompany, String txProject, Date dtStartDate, Date dtEndDate,
			Date dtCreationDate, Date dtUpdateDate, Integer nbStatus, String stIdExperience) {
		super();
		this.nbIdExperience = nbIdExperience;
		this.txCompany = txCompany;
		this.txProject = txProject;
		this.dtStartDate = dtStartDate;
		this.dtEndDate = dtEndDate;
		this.dtCreationDate = dtCreationDate;
		this.dtUpdateDate = dtUpdateDate;
		this.nbStatus = nbStatus;
	}

	/**
	 * @return the nbIdExperience
	 */
	public Integer getNbIdExperience() {
		return nbIdExperience;
	}

	/**
	 * @param nbIdExperience
	 *            the nbIdExperience to set
	 */
	public void setNbIdExperience(Integer nbIdExperience) {
		this.nbIdExperience = nbIdExperience;
	}

	/**
	 * @return the txCompany
	 */
	public String getTxCompany() {
		return txCompany;
	}

	/**
	 * @param txCompany
	 *            the txCompany to set
	 */
	public void setTxCompany(String txCompany) {
		this.txCompany = txCompany;
	}

	/**
	 * @return the txProject
	 */
	public String getTxProject() {
		return txProject;
	}

	/**
	 * @param txProject
	 *            the txProject to set
	 */
	public void setTxProject(String txProject) {
		this.txProject = txProject;
	}

	/**
	 * @return the dtStartDate
	 */
	public Date getDtStartDate() {
		return dtStartDate;
	}

	/**
	 * @param dtStartDate
	 *            the dtStartDate to set
	 */
	public void setDtStartDate(Date dtStartDate) {
		this.dtStartDate = dtStartDate;
	}

	/**
	 * @return the dtEndDate
	 */
	public Date getDtEndDate() {
		return dtEndDate;
	}

	/**
	 * @param dtEndDate
	 *            the dtEndDate to set
	 */
	public void setDtEndDate(Date dtEndDate) {
		this.dtEndDate = dtEndDate;
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
