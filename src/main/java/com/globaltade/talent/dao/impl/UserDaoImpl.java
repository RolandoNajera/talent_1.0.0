package com.globaltade.talent.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.globaltade.talent.dao.IUserDao;
import com.globaltade.talent.dominio.User;
import com.globaltade.talent.exception.PersistenceException;

@Repository("userDao")
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements IUserDao {
	
	public User getUserByPhone(String phone) throws PersistenceException {
		User user = null;
		try{
			Criteria criteria = createEntityCriteria();
			criteria.add(Restrictions.eq("phone", phone));
			user = (User) criteria.uniqueResult();
		}catch(Exception e){
			throw new PersistenceException(e.getMessage());
		}
		return user;
	}
	
	public User getUserByMail(String mail) throws PersistenceException {
		User user = null;
		try{
			Criteria criteria = createEntityCriteria();
			criteria.add(Restrictions.eq("mail", mail));
			user = (User) criteria.uniqueResult();
		}catch(Exception e){
			throw new PersistenceException(e.getMessage());
		}
		return user;
	}

	

}
