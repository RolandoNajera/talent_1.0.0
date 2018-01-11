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
import com.globaltade.talent.service.IUserService;
import com.globaltade.talent.transaction.TransactionUser;

@RestController
public class UserController {

	@Autowired
	IUserService userService;

	/**
	 * Retrieve All Users
	 * **/
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<TransactionUser> getAllUsers() {
		TransactionUser users = userService.getAllUser();
		return new ResponseEntity<TransactionUser>(users, HttpStatus.OK);
	}
	
	/**
	 * Retrieve Single User
	 * **/
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionUser> getUser(@PathVariable("id") Integer idUser) {
		TransactionUser transactionuser = new TransactionUser();
		transactionuser.setUser(new User(idUser));
		transactionuser = userService.getUserById(transactionuser);
		return new ResponseEntity<TransactionUser>(transactionuser, HttpStatus.OK);
	}

	/**
	 * Create a User
	 * **/
	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody User user,   UriComponentsBuilder ucBuilder) {
		TransactionUser transactionuser = new TransactionUser(user);
		transactionuser = userService.saveUser(transactionuser);
		if (!ErrorUserT.USERSUCCES_QUERY_PERSISTUSERSRESULT.getCode().equals(transactionuser.getResponseCode())) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		transactionuser = userService.saveUser(transactionuser);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(transactionuser.getUser().getIdUser()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	/**
	 * Update a User
	 * **/
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<TransactionUser> updateUser(@RequestBody User user) {
		TransactionUser transactionuser = new TransactionUser(user);
		transactionuser = userService.updateUser(transactionuser);
		return new ResponseEntity<TransactionUser>(transactionuser, HttpStatus.OK);
	}
	
	/**
	 * Delete a User
	 * **/
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<TransactionUser> deleteUser(@PathVariable("id") Integer idUser) {
		TransactionUser transactionuser = new TransactionUser();
		transactionuser.setUser(new User(idUser));
		transactionuser = userService.deleteUser(transactionuser);
		return new ResponseEntity<TransactionUser>(transactionuser, HttpStatus.OK);
	}

}
