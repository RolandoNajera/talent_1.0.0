package com.globaltade.talent.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.globaltade.talent.dao.IExperienceDao;
import com.globaltade.talent.dominio.Experience;
import com.globaltade.talent.exception.PersistenceException;

@Repository("experienceDao")
public class ExperienceDaoImpl extends GenericDaoImpl<Experience, Integer> implements IExperienceDao {
	
	@Override
	public void deleteExperienceById(Integer experienceId) throws PersistenceException {
		try{
			Query query = getSession().createSQLQuery("delete from CatExperience where nbIdExperience = :nbIdExperience");
			query.setInteger("nbIdExperience", experienceId);
			query.executeUpdate();
		}catch(Exception e){
			throw new PersistenceException(e.getMessage());
		}
	}

}
