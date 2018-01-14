package com.globaltade.talent.dao;

import com.globaltade.talent.dominio.User;
import com.globaltade.talent.exception.PersistenceException;

public interface IUserDao extends IGenericDao<User, Integer> {
	
	User getUserByPhone(String phone) throws PersistenceException;
	
	User getUserByMail(String mail) throws PersistenceException;
	
}
