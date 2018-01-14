package com.globaltade.talent.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GenericGenerator(name = "genUser", strategy = "increment")
	@GeneratedValue(generator = "genUser")
	@Column(name = "idUser")
	private Integer idUser;

	@NotNull
	@Column(name = "mail")
	private String mail;

	@NotNull
	@Column(name = "phone")
	private String phone;

	@Column(name = "password")
	private String password;

	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
	@Type(type = "timestamp")
	@Column(name = "creationDate")
	private Date creationDate;

	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
	@Type(type = "timestamp")
	@Column(name = "updateDate")
	private Date updateDate;

	@Column(name = "status")
	private Integer status;

	public User() {
		super();
	}
	
	public User(Integer idUser) {
		super();
		this.idUser = idUser;
	}

	/**
	 * @param idUser
	 * @param mail
	 * @param phone
	 * @param password
	 * @param creationDate
	 * @param updateDate
	 * @param status
	 */
	public User(Integer idUser, String mail, String phone, String password, Date creationDate, Date updateDate,
			Integer status) {
		super();
		this.idUser = idUser;
		this.mail = mail;
		this.phone = phone;
		this.password = password;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.status = status;
	}

	/**
	 * @return the id
	 */
	public Integer getIdUser() {
		return idUser;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 *            the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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

}
