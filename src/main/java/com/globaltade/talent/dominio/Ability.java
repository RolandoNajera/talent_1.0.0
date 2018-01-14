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
@Table(name = "Ability")
public class Ability {

	@Id
	@GenericGenerator(name = "genAbility", strategy = "increment")
	@GeneratedValue(generator = "genAbility")
	@Column(name = "idAbility")
	private Integer idAbility;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "type")
	private String type;

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
	@JoinColumn(name = "idProfile")
	private Profile profile;

	public Ability() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param type
	 * @param creationDate
	 * @param updateDate
	 * @param status
	 */
	public Ability(Integer idAbility, String name, String description, String type, Date creationDate, Date updateDate,
			Integer status) {
		super();
		this.idAbility = idAbility;
		this.name = name;
		this.description = description;
		this.type = type;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.status = status;
	}

	/**
	 * @return the id
	 */
	public Integer getIdAbility() {
		return idAbility;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setIdAbility(Integer idAbility) {
		this.idAbility = idAbility;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
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
