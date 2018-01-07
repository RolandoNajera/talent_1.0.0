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

import com.globaltade.talent.dominio.User;
import com.globaltade.talent.enums.ErrorUserT;
import com.globaltade.talent.service.IProfileService;
import com.globaltade.talent.transaction.TransactionProfile;
import com.globaltade.talent.transaction.TransactionUser;

@RestController
public class ProfileController {

	@Autowired
	IProfileService profileService;

	/**
	 * Retrieve All Profiles
	 * **/
	@RequestMapping(value = "/profiles/", method = RequestMethod.GET)
	public ResponseEntity<TransactionProfile> getAllProfiles() {
		TransactionProfile users = profileService.readProfiles(new TransactionProfile());
		return new ResponseEntity<TransactionProfile>(users, HttpStatus.OK);
	}
	
	/**
	 * Retrieve Single Profile by Id
	 * **/
	@RequestMapping(value = "/profiles/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionProfile> getProfileById(@PathVariable("id") Integer idUser) {
		TransactionProfile transactionuser = new TransactionProfile();
		transactionuser.setUser(new User(idUser));
		transactionuser = profileService.getProfileByProfileId(transactionuser);
		return new ResponseEntity<TransactionProfile>(transactionuser, HttpStatus.OK);
	}

	/**
	 * Create a new Profile
	 * **/
	@RequestMapping(value = "/profiles/", method = RequestMethod.POST)
	public ResponseEntity<Void> createProfile(@RequestBody User user,   UriComponentsBuilder ucBuilder) {
		TransactionUser transactionuser = new TransactionUser(user);
		transactionuser = userService.saveUser(transactionuser);
		if (!ErrorUserT.USERSUCCES_QUERY_PERSISTUSERSRESULT.getErrorCode().equals(transactionuser.getResponseCode())) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		transactionuser = userService.saveUser(transactionuser);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(transactionuser.getUser().getIdUser()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	/**
	 * Update a Profile
	 * **/
	@RequestMapping(value = "/profiles/{id}", method = RequestMethod.PUT)
	public ResponseEntity<TransactionUser> updateProfile(@RequestBody User user) {
		TransactionUser transactionuser = new TransactionUser(user);
		transactionuser = userService.updateUser(transactionuser);
		return new ResponseEntity<TransactionUser>(transactionuser, HttpStatus.OK);
	}
	
	/**
	 * Delete a Profile
	 * **/
	@RequestMapping(value = "/profiles/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<TransactionUser> deleteProfile(@PathVariable("id") Integer idUser) {
		TransactionUser transactionuser = new TransactionUser();
		transactionuser.setUser(new User(idUser));
		transactionuser = userService.deleteUser(transactionuser);
		return new ResponseEntity<TransactionUser>(transactionuser, HttpStatus.OK);
	}

}
