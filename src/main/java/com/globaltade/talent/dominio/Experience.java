package com.globaltade.talent.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Experience")
public class Experience {

	@Id
	@GenericGenerator(name = "genExperience", strategy = "increment")
	@GeneratedValue(generator = "genExperience")
	@Column(name = "id")
	private Integer idExperience;

	@Column(name = "company")
	private String company;

	@Column(name = "project")
	private String project;

	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
	@Type(type = "timestamp")
	@Column(name = "startDate", nullable = false)
	private Date startDate;

	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
	@Type(type = "timestamp")
	@Column(name = "endDate", nullable = false)
	private Date endDate;

	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
	@Type(type = "timestamp")
	@Column(name = "creationDate", nullable = false)
	private Date creationDate;

	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
	@Type(type = "timestamp")
	@Column(name = "updateDate")
	private Date updateDate;

	@Column(name = "status", nullable = false)
	private Integer status;

	@ManyToOne
	@JoinColumn(name = "id")
	private Profile profile;

	public Experience() {
		super();
	}

	/**
	 * @param idExperience
	 * @param company
	 * @param project
	 * @param startDate
	 * @param endDate
	 * @param creationDate
	 * @param updateDate
	 * @param status
	 */
	public Experience(Integer idExperience, String company, String project, Date startDate, Date endDate,
			Date creationDate, Date updateDate, Integer status) {
		super();
		this.idExperience = idExperience;
		this.company = company;
		this.project = project;
		this.startDate = startDate;
		this.endDate = endDate;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.status = status;
	}

	/**
	 * @return the idExperience
	 */
	public Integer getIdExperience() {
		return idExperience;
	}

	/**
	 * @param idExperience
	 *            the idExperience to set
	 */
	public void setIdExperience(Integer idExperience) {
		this.idExperience = idExperience;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company
	 *            the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the project
	 */
	public String getProject() {
		return project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(String project) {
		this.project = project;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate
	 *            the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate
	 *            the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
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

}
