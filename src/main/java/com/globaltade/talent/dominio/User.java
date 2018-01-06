package com.globaltade.talent.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Cat_User")
public class User {

	@Id
	@GenericGenerator(name="genUser",strategy="increment")
	@GeneratedValue(generator="genUser")
	@Column(name = "nb_idUser")
	private Integer idUser;

	@NotNull
	@NotEmpty
	@Size(min = 3, max = 80)
	@Column(name = "tx_name", nullable = false)
	private String name;

	@NotNull
	@NotEmpty
	@Size(min = 3, max = 50)
	@Column(name = "tx_lastname1", nullable = false)
	private String lastName1;

	@Size(max = 50)
	@Column(name = "tx_lastname2")
	private String lastName2;

	@Size(max = 15)
	@Column(name = "tx_phone")
	private String phone;

	@Column(name = "tx_mail", nullable = false)
	private String mail;

	@Size(max = 13)
	@Column(name = "tx_rfc")
	private String rfc;

	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
	@Type(type = "timestamp")
	@Column(name = "dt_creationDate")
	private Date creationDate;

	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
	@Type(type = "timestamp")
	@Column(name = "dt_updateDate")
	private Date updateDate;

	@Column(name = "nb_status")
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
	 * @param name
	 * @param lastName1
	 * @param lastName2
	 * @param phone
	 * @param mail
	 * @param rfc
	 * @param creationDate
	 * @param updateDate
	 * @param status
	 * @param stIdUser
	 */
	public User(Integer idUser, String name, String lastName1, String lastName2, String phone, String mail, String rfc,
			Date creationDate, Date updateDate, Integer status) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.lastName1 = lastName1;
		this.lastName2 = lastName2;
		this.phone = phone;
		this.mail = mail;
		this.rfc = rfc;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.status = status;
	}

	/**
	 * @return the idUser
	 */
	public Integer getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser
	 *            the idUser to set
	 */
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
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
	 * @return the lastName1
	 */
	public String getLastName1() {
		return lastName1;
	}

	/**
	 * @param lastName1
	 *            the lastName1 to set
	 */
	public void setLastName1(String lastName1) {
		this.lastName1 = lastName1;
	}

	/**
	 * @return the lastName2
	 */
	public String getLastName2() {
		return lastName2;
	}

	/**
	 * @param lastName2
	 *            the lastName2 to set
	 */
	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
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
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}

	/**
	 * @param rfc
	 *            the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
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
