package com.globaltade.talent.dao;

import com.globaltade.talent.dominio.Profile;
import com.globaltade.talent.exception.PersistenceException;

public interface IProfileDao extends IGenericDao<Profile, Integer> {
	
	Profile getProfileByPhone(String phone) throws PersistenceException;
	
	Profile getProfileByMail(String mail) throws PersistenceException;
	
}
