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
@Table(name = "User")
public class User {

	@Id
	@GenericGenerator(name="genUser",strategy="increment")
	@GeneratedValue(generator="genUser")
	@Column(name = "id")
	private Integer id;

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
	
	

}
