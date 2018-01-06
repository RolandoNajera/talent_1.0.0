package com.globaltade.talent.dao;

import com.globaltade.talent.dominio.Adress;
import com.globaltade.talent.exception.PersistenceException;

public interface IAdressDao extends IGenericDao<Adress, Integer> {
	
	Adress getAdressByStreet(String adress) throws PersistenceException;
	
	void deleteAdressById(Integer idUser) throws PersistenceException;
	
}
