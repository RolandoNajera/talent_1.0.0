package com.globaltade.talent.servicio;

import com.globaltade.talent.transaction.TransactionUser;

public interface IUserService {

	TransactionUser getAllUser();

	TransactionUser getUserById(TransactionUser transactionUserRequest);

	TransactionUser saveUser(TransactionUser transactionUserRequest);

	TransactionUser updateUser(TransactionUser transactionUserRequest);
	
	TransactionUser deleteUser(TransactionUser transactionUserRequest);
	
	TransactionUser userExist(TransactionUser transactionUserRequest);
	
}
