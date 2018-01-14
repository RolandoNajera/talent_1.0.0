package com.globaltade.talent.dominio;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Profile")
public class Profile {

	@Id
	@GenericGenerator(name = "genProfile", strategy = "increment")
	@GeneratedValue(generator = "genProfile")
	@Column(name = "idProfile")
	private Integer idProfile;

	@NotNull
	@NotEmpty
	@Size(min = 3, max = 100)
	@Column(name = "names", nullable = false)
	private String names;

	@NotNull
	@NotEmpty
	@Size(min = 3, max = 50)
	@Column(name = "firstLastName", nullable = false)
	private String firstLastName;

	@Size(max = 50)
	@Column(name = "secondLastName")
	private String secondLastName;

	@Size(max = 15)
	@Column(name = "firstPhone")
	private String firstPhone;

	@Size(max = 15)
	@Column(name = "secondPhone")
	private String secondPhone;

	@Size(max = 130)
	@Column(name = "mail", nullable = false)
	private String mail;

	@Size(max = 15)
	@Column(name = "rfc")
	private String rfc;

	@Column(name = "picture")
	private String picture;

	@Column(name = "pictureThumb")
	private String pictureThumb;

	@Column(name = "linkLinkedin")
	private String linkLinkedin;

	@Column(name = "linkFacebook")
	private String linkFacebook;

	@Column(name = "linkTwitter")
	private String linkTwitter;

	@Column(name = "linkWebsite")
	private String linkWebsite;

	@Column(name = "streetNameNumber")
	private String streetNameNumber;

	@Column(name = "suburb")
	private String suburb;

	@Column(name = "zipCode")
	private String zipCode;

	@Column(name = "town")
	private String town;

	@Column(name = "city")
	private String city;

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

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idExperience")
	@OrderBy
	private Set<Experience> experiences;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idAbility")
	@OrderBy
	private Set<Ability> abilities;

	public Profile() {
		super();
	}

	public Profile(Integer idProfile) {
		super();
		this.idProfile = idProfile;
	}

	/**
	 * @param idProfile
	 * @param names
	 * @param firstLastName
	 * @param secondLastName
	 * @param firstPhone
	 * @param secondPhone
	 * @param mail
	 * @param rfc
	 * @param picture
	 * @param pictureThumb
	 * @param linkLinkedin
	 * @param linkFacebook
	 * @param linkTwitter
	 * @param linkWebsite
	 * @param streetNameNumber
	 * @param suburb
	 * @param zipCode
	 * @param town
	 * @param city
	 * @param creationDate
	 * @param updateDate
	 * @param status
	 */
	public Profile(Integer idProfile, String names, String firstLastName, String secondLastName, String firstPhone,
			String secondPhone, String mail, String rfc, String picture, String pictureThumb, String linkLinkedin,
			String linkFacebook, String linkTwitter, String linkWebsite, String streetNameNumber, String suburb,
			String zipCode, String town, String city, Date creationDate, Date updateDate, Integer status) {
		super();
		this.idProfile = idProfile;
		this.names = names;
		this.firstLastName = firstLastName;
		this.secondLastName = secondLastName;
		this.firstPhone = firstPhone;
		this.secondPhone = secondPhone;
		this.mail = mail;
		this.rfc = rfc;
		this.picture = picture;
		this.pictureThumb = pictureThumb;
		this.linkLinkedin = linkLinkedin;
		this.linkFacebook = linkFacebook;
		this.linkTwitter = linkTwitter;
		this.linkWebsite = linkWebsite;
		this.streetNameNumber = streetNameNumber;
		this.suburb = suburb;
		this.zipCode = zipCode;
		this.town = town;
		this.city = city;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.status = status;
	}

	/**
	 * @return the idProfile
	 */
	public Integer getIdProfile() {
		return idProfile;
	}

	/**
	 * @param idProfile
	 *            the idProfile to set
	 */
	public void setIdProfile(Integer idProfile) {
		this.idProfile = idProfile;
	}

	/**
	 * @return the names
	 */
	public String getNames() {
		return names;
	}

	/**
	 * @param names
	 *            the names to set
	 */
	public void setNames(String names) {
		this.names = names;
	}

	/**
	 * @return the firstLastName
	 */
	public String getFirstLastName() {
		return firstLastName;
	}

	/**
	 * @param firstLastName
	 *            the firstLastName to set
	 */
	public void setFirstLastName(String firstLastName) {
		this.firstLastName = firstLastName;
	}

	/**
	 * @return the secondLastName
	 */
	public String getSecondLastName() {
		return secondLastName;
	}

	/**
	 * @param secondLastName
	 *            the secondLastName to set
	 */
	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}

	/**
	 * @return the firstPhone
	 */
	public String getFirstPhone() {
		return firstPhone;
	}

	/**
	 * @param firstPhone
	 *            the firstPhone to set
	 */
	public void setFirstPhone(String firstPhone) {
		this.firstPhone = firstPhone;
	}

	/**
	 * @return the secondPhone
	 */
	public String getSecondPhone() {
		return secondPhone;
	}

	/**
	 * @param secondPhone
	 *            the secondPhone to set
	 */
	public void setSecondPhone(String secondPhone) {
		this.secondPhone = secondPhone;
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
	 * @return the picture
	 */
	public String getPicture() {
		return picture;
	}

	/**
	 * @param picture
	 *            the picture to set
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}

	/**
	 * @return the pictureThumb
	 */
	public String getPictureThumb() {
		return pictureThumb;
	}

	/**
	 * @param pictureThumb
	 *            the pictureThumb to set
	 */
	public void setPictureThumb(String pictureThumb) {
		this.pictureThumb = pictureThumb;
	}

	/**
	 * @return the linkLinkedin
	 */
	public String getLinkLinkedin() {
		return linkLinkedin;
	}

	/**
	 * @param linkLinkedin
	 *            the linkLinkedin to set
	 */
	public void setLinkLinkedin(String linkLinkedin) {
		this.linkLinkedin = linkLinkedin;
	}

	/**
	 * @return the linkFacebook
	 */
	public String getLinkFacebook() {
		return linkFacebook;
	}

	/**
	 * @param linkFacebook
	 *            the linkFacebook to set
	 */
	public void setLinkFacebook(String linkFacebook) {
		this.linkFacebook = linkFacebook;
	}

	/**
	 * @return the linkTwitter
	 */
	public String getLinkTwitter() {
		return linkTwitter;
	}

	/**
	 * @param linkTwitter
	 *            the linkTwitter to set
	 */
	public void setLinkTwitter(String linkTwitter) {
		this.linkTwitter = linkTwitter;
	}

	/**
	 * @return the linkWebsite
	 */
	public String getLinkWebsite() {
		return linkWebsite;
	}

	/**
	 * @param linkWebsite
	 *            the linkWebsite to set
	 */
	public void setLinkWebsite(String linkWebsite) {
		this.linkWebsite = linkWebsite;
	}

	/**
	 * @return the streetNameNumber
	 */
	public String getStreetNameNumber() {
		return streetNameNumber;
	}

	/**
	 * @param streetNameNumber
	 *            the streetNameNumber to set
	 */
	public void setStreetNameNumber(String streetNameNumber) {
		this.streetNameNumber = streetNameNumber;
	}

	/**
	 * @return the suburb
	 */
	public String getSuburb() {
		return suburb;
	}

	/**
	 * @param suburb
	 *            the suburb to set
	 */
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode
	 *            the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the town
	 */
	public String getTown() {
		return town;
	}

	/**
	 * @param town
	 *            the town to set
	 */
	public void setTown(String town) {
		this.town = town;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
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
	 * @return the experiences
	 */
	public Set<Experience> getExperiences() {
		return experiences;
	}

	/**
	 * @param experiences
	 *            the experiences to set
	 */
	public void setExperiences(Set<Experience> experiences) {
		this.experiences = experiences;
	}

	/**
	 * @return the abilities
	 */
	public Set<Ability> getAbilities() {
		return abilities;
	}

	/**
	 * @param abilities
	 *            the abilities to set
	 */
	public void setAbilities(Set<Ability> abilities) {
		this.abilities = abilities;
	}

}
