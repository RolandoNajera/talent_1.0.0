package com.globaltade.talent.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.globaltade.talent.dao.IGenericDao;
import com.globaltade.talent.exception.PersistenceException;

public abstract class GenericDaoImpl<Entity, PK extends Serializable> implements IGenericDao<Entity, PK> {

	private final Class<Entity> persistentClass;

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		this.persistentClass = (Class<Entity>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public Entity getById(PK key) throws PersistenceException {
		try{
			return (Entity) getSession().get(persistentClass, key);
		}catch(Exception e){
			throw new PersistenceException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public Entity getAll() throws PersistenceException {
		try{
			return (Entity) createEntityCriteria().list();
		}catch(Exception e){
			throw new PersistenceException(e.getMessage());
		}
	}

	public void persist(Entity entity) throws PersistenceException {
		try{
			getSession().persist(entity);
		}catch(Exception e){
			throw new PersistenceException(e.getMessage());
		}
	}

	public void update(Entity entity) throws PersistenceException {
		try{
			getSession().saveOrUpdate(entity);
		}catch(Exception e){
			throw new PersistenceException(e.getMessage());
		}
	}

	public void delete(Entity entity) throws PersistenceException {
		try{
			getSession().delete(entity);
		}catch(Exception e){
			throw new PersistenceException(e.getMessage());
		}
	}

	public Criteria createEntityCriteria() {
		return getSession().createCriteria(persistentClass);
	}

}