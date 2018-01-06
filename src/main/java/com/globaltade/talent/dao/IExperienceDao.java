package com.globaltade.talent.dao;

import com.globaltade.talent.dominio.Experience;
import com.globaltade.talent.exception.PersistenceException;

public interface IExperienceDao extends IGenericDao<Experience, Integer> {
	
	void deleteExperienceById(Integer idExperience) throws PersistenceException;
	
}
