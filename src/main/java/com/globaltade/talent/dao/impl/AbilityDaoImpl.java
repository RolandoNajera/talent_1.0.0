package com.globaltade.talent.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.globaltade.talent.dao.IAbilityDao;
import com.globaltade.talent.dominio.Ability;
import com.globaltade.talent.exception.PersistenceException;

@Repository("abilityDao")
public class AbilityDaoImpl extends GenericDaoImpl<Ability, Integer> implements IAbilityDao {
	
	@Override
	public Ability getAbilityByName(String nameAbility) throws PersistenceException {
		Ability hability = null;
		try{
			Criteria criteria = createEntityCriteria();
			criteria.add(Restrictions.eq("txName", nameAbility));
			hability = (Ability) criteria.uniqueResult();
		}catch(Exception e){
			throw new PersistenceException(e.getMessage());
		}
		return hability;
	}
	
	@Override
	public void deleteAbilityById(Integer idAbility) throws PersistenceException {
		try{
			Query query = getSession().createSQLQuery("delete from CatExperience where nbIdHability = :nbIdHability");
			query.setInteger("nbIdAbility", idAbility);
			query.executeUpdate();
		}catch(Exception e){
			throw new PersistenceException(e.getMessage());
		}
	}

}
