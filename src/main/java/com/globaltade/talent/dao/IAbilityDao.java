package com.globaltade.talent.dao;

import com.globaltade.talent.dominio.Ability;
import com.globaltade.talent.exception.PersistenceException;

public interface IAbilityDao extends IGenericDao<Ability, Integer> {
	
	Ability getAbilityByName(String nameAbility) throws PersistenceException;
	
	void deleteAbilityById(Integer idAbility) throws PersistenceException;
	
}
