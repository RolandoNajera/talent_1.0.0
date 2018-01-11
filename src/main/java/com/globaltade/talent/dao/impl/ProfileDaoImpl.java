package com.globaltade.talent.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.globaltade.talent.dao.IProfileDao;
import com.globaltade.talent.dominio.Profile;
import com.globaltade.talent.exception.PersistenceException;

@Repository("profileDao")
public class ProfileDaoImpl extends GenericDaoImpl<Profile, Integer> implements IProfileDao {
	
	public Profile getProfileByPhone(String phone) throws PersistenceException {
		Profile profile = null;
		try{
			Criteria criteria = createEntityCriteria();
			criteria.add(Restrictions.eq("phone", phone));
			profile = (Profile) criteria.uniqueResult();
		}catch(Exception e){
			throw new PersistenceException(e.getMessage());
		}
		return profile;
	}
	
	public Profile getProfileByMail(String mail) throws PersistenceException {
		Profile profile = null;
		try{
			Criteria criteria = createEntityCriteria();
			criteria.add(Restrictions.eq("mail", mail));
			profile = (Profile) criteria.uniqueResult();
		}catch(Exception e){
			throw new PersistenceException(e.getMessage());
		}
		return profile;
	}
	
}
