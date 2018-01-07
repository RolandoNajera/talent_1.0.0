package com.globaltade.talent.dao;

import com.globaltade.talent.dominio.User;
import com.globaltade.talent.exception.PersistenceException;

public interface IProfileDao extends IGenericDao<User, Integer> {
	
	User getUserByRfc(String rfc) throws PersistenceException;
	
	User getUserByPhone(String phone) throws PersistenceException;
	
	User getUserByMail(String mail) throws PersistenceException;
	
	void deleteUserById(Integer idUser) throws PersistenceException;
	
}
