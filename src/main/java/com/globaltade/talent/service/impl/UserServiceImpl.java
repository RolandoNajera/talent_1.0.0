package com.globaltade.talent.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globaltade.talent.dao.IUserDao;
import com.globaltade.talent.dominio.User;
import com.globaltade.talent.enums.ErrorUserT;
import com.globaltade.talent.exception.PersistenceException;
import com.globaltade.talent.exception.BusinessException;
import com.globaltade.talent.service.IUserService;
import com.globaltade.talent.transaction.TransactionUser;
import com.globaltade.talent.utils.Constantes;
import com.globaltade.talent.validator.UserValidator;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	@SuppressWarnings("unchecked")
	public TransactionUser getAllUser() {
		TransactionUser transactionUser = new TransactionUser(); 
		try {
			List<User> listUsers = (List<User>) userDao.getAll();
			if(listUsers == null || listUsers.isEmpty()) {
				transactionUser.setResponseCode(ErrorUserT.USERSUCCES_QUERY_EMPTYLISTUSERRESULT.getCode());
				transactionUser.setDescriptionCode(ErrorUserT.USERSUCCES_QUERY_EMPTYLISTUSERRESULT.getDescription());
				transactionUser.setTotalResult(Constantes.CONSULTA_TOTALVACIO);
			}else {
				transactionUser.setListUser(listUsers);
				transactionUser.setResponseCode(ErrorUserT.USERSUCCES_QUERY_LISTUSERRESULT.getCode());
				transactionUser.setDescriptionCode(ErrorUserT.USERSUCCES_QUERY_LISTUSERRESULT.getDescription());
				transactionUser.setTotalResult(listUsers.size());
			}
		} catch (PersistenceException spe) {
			transactionUser.setResponseCode(ErrorUserT.USERERROR_PERSISTANCE_USEREXCEPTION.getCode());
			transactionUser.setDescriptionCode(spe.getMessage());
		}
		return transactionUser;
	}

	public TransactionUser getUserById(TransactionUser transactionUser) {
		try {
			UserValidator.validateUserById(transactionUser.getUser());
			User userdb = userDao.getById(transactionUser.getUser().getIdUser());
			if(userdb == null) {
				transactionUser.setResponseCode(ErrorUserT.USERSUCCES_QUERY_EMPTYUSERRESULT.getCode());
				transactionUser.setDescriptionCode(ErrorUserT.USERSUCCES_QUERY_EMPTYUSERRESULT.getDescription());
				transactionUser.setTotalResult(Constantes.CONSULTA_TOTALVACIO);
			}else {
				transactionUser.setUser(userdb);
				transactionUser.setResponseCode(ErrorUserT.USERSUCCES_QUERY_USERRESULT.getCode());
				transactionUser.setDescriptionCode(ErrorUserT.USERSUCCES_QUERY_USERRESULT.getDescription());
				transactionUser.setTotalResult(Constantes.NUMERO_UNO);
			}
		} catch (PersistenceException spe) {
			transactionUser.setResponseCode(ErrorUserT.USERERROR_PERSISTANCE_USEREXCEPTION.getCode());
			transactionUser.setDescriptionCode(spe.getMessage());
		} catch(BusinessException ue) {
			transactionUser.setResponseCode(ue.getErrorCode());
			transactionUser.setDescriptionCode(ue.getDescriptionCode());
		}
		return transactionUser;
	}

	public TransactionUser saveUser(TransactionUser transactionUser) {
		try {
			UserValidator.validateSaveUser(transactionUser.getUser());
			transactionUser = userExist(transactionUser);
			if(transactionUser.isExist()) {
				throw ErrorUserT.USERERROR_QUERY_USERINSYSTEM.buildUserException();
			}
			transactionUser.getUser().setStatus(Constantes.STATUS_ACTIVE);
			userDao.persist(transactionUser.getUser());
			transactionUser.setUser(transactionUser.getUser());
			transactionUser.setResponseCode(ErrorUserT.USERSUCCES_QUERY_PERSISTUSERSRESULT.getCode());
			transactionUser.setDescriptionCode(ErrorUserT.USERSUCCES_QUERY_PERSISTUSERSRESULT.getDescription());
			transactionUser.setTotalResult(Constantes.NUMERO_UNO);
		} catch (PersistenceException spe) {
			transactionUser.setResponseCode(ErrorUserT.USERERROR_PERSISTANCE_USEREXCEPTION.getCode());
			transactionUser.setDescriptionCode(spe.getMessage());
		} catch(BusinessException ue) {
			transactionUser.setResponseCode(ue.getErrorCode());
			transactionUser.setDescriptionCode(ue.getDescriptionCode());
		}
		return transactionUser;
	}

	@Override
	public TransactionUser updateUser(TransactionUser transactionUser) {
		try {
			UserValidator.validateSaveUser(transactionUser.getUser());
			transactionUser = userExist(transactionUser);
			if(transactionUser.isExist()) {
				ErrorUserT.USERERROR_QUERY_NOTUSER.buildUserException();
			}
			transactionUser.getUser().setUpdateDate(new Date());
			userDao.update(transactionUser.getUser());
			transactionUser.setUser(transactionUser.getUser());
			transactionUser.setResponseCode(ErrorUserT.USERSUCCES_QUERY_UPDATEUSERSRESULT.getCode());
			transactionUser.setDescriptionCode(ErrorUserT.USERSUCCES_QUERY_UPDATEUSERSRESULT.getDescription());
			transactionUser.setTotalResult(Constantes.NUMERO_UNO);
		} catch (PersistenceException spe) {
			transactionUser.setResponseCode(ErrorUserT.USERERROR_PERSISTANCE_USEREXCEPTION.getCode());
			transactionUser.setDescriptionCode(spe.getMessage());
		} catch(BusinessException ue) {
			transactionUser.setResponseCode(ue.getErrorCode());
			transactionUser.setDescriptionCode(ue.getDescriptionCode());
		}
		return transactionUser;
	}

	public TransactionUser deleteUser(TransactionUser transactionUser) {
		try {
			UserValidator.validateSaveUser(transactionUser.getUser());
			transactionUser = userExist(transactionUser);
			if(transactionUser.isExist()) {
				ErrorUserT.USERERROR_QUERY_NOTUSER.buildUserException();
			}
			transactionUser.getUser().setUpdateDate(new Date());
			transactionUser.getUser().setStatus(Constantes.STATUS_INACTIVE);
			userDao.update(transactionUser.getUser());
			transactionUser.setUser(transactionUser.getUser());
			transactionUser.setResponseCode(ErrorUserT.USERSUCCES_QUERY_DELETEUSERSRESULT.getCode());
			transactionUser.setDescriptionCode(ErrorUserT.USERSUCCES_QUERY_DELETEUSERSRESULT.getDescription());
			transactionUser.setTotalResult(Constantes.NUMERO_UNO);
		} catch (PersistenceException spe) {
			transactionUser.setResponseCode(ErrorUserT.USERERROR_PERSISTANCE_USEREXCEPTION.getCode());
			transactionUser.setDescriptionCode(spe.getMessage());
		} catch(BusinessException ue) {
			transactionUser.setResponseCode(ue.getErrorCode());
			transactionUser.setDescriptionCode(ue.getDescriptionCode());
		}
		return transactionUser;
	}
	
	@Override
	public TransactionUser userExist(TransactionUser transactionUser) {
		try {
			UserValidator.validateUserUnique(transactionUser.getUser());
			User userDb = userDao.getUserByMail(transactionUser.getUser().getMail());
			if(userDb == null) {
				transactionUser.setExist(Constantes.ISUNIQUE_FALSE);
			}else {
				transactionUser.setExist(Constantes.ISUNIQUE_TRUE);
			}
		} catch (PersistenceException spe) {
			transactionUser.setResponseCode(ErrorUserT.USERERROR_PERSISTANCE_USEREXCEPTION.getCode());
			transactionUser.setDescriptionCode(spe.getMessage());
		} catch(BusinessException ue) {
			transactionUser.setResponseCode(ue.getErrorCode());
			transactionUser.setDescriptionCode(ue.getDescriptionCode());
		}
		return transactionUser;
	}
	
}
