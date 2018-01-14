package com.globaltade.talent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.globaltade.talent.dominio.Profile;
import com.globaltade.talent.service.IProfileService;
import com.globaltade.talent.transaction.TransactionProfile;

@RestController
public class ProfileController {

	@Autowired
	IProfileService profileService;

	/**
	 * Create a new Profile
	 * **/
	@RequestMapping(value = "/talents/", method = RequestMethod.POST)
	public ResponseEntity<Void> createProfile(@RequestBody Profile profile,   UriComponentsBuilder ucBuilder) {
		TransactionProfile transactionProfile = new TransactionProfile(profile);
		profileService.createProfile(transactionProfile);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/talents/{id}").buildAndExpand(transactionProfile.getProfile().getIdProfile()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	/**
	 * Update a Profile
	 * **/
	@RequestMapping(value = "/talents/", method = RequestMethod.PUT)
	public ResponseEntity<TransactionProfile> updateProfile(@RequestBody Profile profile) {
		TransactionProfile transactionProfile = new TransactionProfile(profile);
		profileService.updateProfile(transactionProfile);
		return new ResponseEntity<TransactionProfile>(transactionProfile, HttpStatus.OK);
	}
	
	/**
	 * Retrieve All Profiles
	 * **/
	@RequestMapping(value = "/talents/", method = RequestMethod.GET)
	public ResponseEntity<TransactionProfile> getAllProfiles() {
		TransactionProfile transactionProfile = profileService.readProfiles();
		return new ResponseEntity<TransactionProfile>(transactionProfile, HttpStatus.OK);
	}
	
	/**
	 * Retrieve Single talent by Id
	 * **/
	@RequestMapping(value = "/talents/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionProfile> getProfileById(@PathVariable("id") Integer idProfile) {
		TransactionProfile transactionProfile = new TransactionProfile(new Profile(idProfile));
		profileService.getProfile(transactionProfile);
		return new ResponseEntity<TransactionProfile>(transactionProfile, HttpStatus.OK);
	}
	
	/**
	 * Delete a talent
	 * **/
	@RequestMapping(value = "/talents/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<TransactionProfile> deleteProfile(@PathVariable("id") Integer idProfile) {
		TransactionProfile transactionProfile = new TransactionProfile(new Profile(idProfile));
		profileService.removeProfile(transactionProfile);
		return new ResponseEntity<TransactionProfile>(transactionProfile, HttpStatus.OK);
	}

}
