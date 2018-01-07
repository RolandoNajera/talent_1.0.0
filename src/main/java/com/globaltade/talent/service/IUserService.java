package com.globaltade.talent.service;

import com.globaltade.talent.transaction.TransactionUser;

public interface IUserService {

	TransactionUser createUser(TransactionUser transactionUserRequest);
	
	TransactionUser getUserById(TransactionUser transactionUserRequest);

	TransactionUser updateUserById(TransactionUser transactionUserRequest);
	
	TransactionUser deleteUser(TransactionUser transactionUserRequest);
	
}
