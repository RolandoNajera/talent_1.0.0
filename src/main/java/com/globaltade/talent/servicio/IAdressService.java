package com.globaltade.talent.servicio;

import com.globaltade.talent.transaction.TransactionAdress;

public interface IAdressService {

	TransactionAdress getAllAdress();

	TransactionAdress getAdressById(TransactionAdress transactionAdress);

	TransactionAdress saveAdress(TransactionAdress transactionAdress);

	TransactionAdress updateAdress(TransactionAdress transactionAdress);
	
	TransactionAdress deleteAdress(TransactionAdress transactionAdress);
	
	TransactionAdress adressExist(TransactionAdress transactionAdress);
	
}
