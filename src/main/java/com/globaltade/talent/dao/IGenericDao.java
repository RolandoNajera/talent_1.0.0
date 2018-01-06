package com.globaltade.talent.dao;

import java.io.Serializable;

import org.hibernate.Criteria;

import com.globaltade.talent.exception.PersistenceException;

public interface IGenericDao<Entity, PK extends Serializable> {

	void persist(Entity entity) throws PersistenceException;

	void update(Entity entity) throws PersistenceException;

	Entity getById(PK id) throws PersistenceException;
	
	Entity getAll() throws PersistenceException;

	void delete(Entity entity) throws PersistenceException;

	Criteria createEntityCriteria();

}
