package com.globaltade.talent.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.globaltade.talent.dao.IAdressDao;
import com.globaltade.talent.dominio.Adress;
import com.globaltade.talent.exception.PersistenceException;

@Repository("adressDao")
public class AdressDaoImpl extends GenericDaoImpl<Adress, Integer> implements IAdressDao {
	
	@Override
	public Adress getAdressByStreet(String street) throws PersistenceException {
		Adress adress = null;
		try{
			Criteria criteria = createEntityCriteria();
			criteria.add(Restrictions.eq("txStreet", street));
			adress = (Adress) criteria.uniqueResult();
		}catch(Exception e){
			throw new PersistenceException(e.getMessage());
		}
		return adress;
	}
	
	@Override
	public void deleteAdressById(Integer adressId) throws PersistenceException {
		try{
			Query query = getSession().createSQLQuery("delete from CatAdress where nbIdAdress = :nbIdAdress");
			query.setInteger("nbIdAdress", adressId);
			query.executeUpdate();
		}catch(Exception e){
			throw new PersistenceException(e.getMessage());
		}
	}

}
