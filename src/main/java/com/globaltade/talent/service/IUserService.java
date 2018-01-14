package com.globaltade.talent.service;

import com.globaltade.talent.transaction.TransactionUser;

public interface IUserService {

	TransactionUser createUser(TransactionUser transactionUserRequest);
	
	TransactionUser updateUser(TransactionUser transactionUserRequest);
	
	TransactionUser getUser(TransactionUser transactionUserRequest);
	
	TransactionUser deleteUser(TransactionUser transactionUserRequest);
	
	TransactionUser getIdUser(TransactionUser transactionUserRequest);
	
}
