package com.globaltade.talent.service.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globaltade.talent.dao.IUserDao;
import com.globaltade.talent.dominio.User;
import com.globaltade.talent.enums.CodeProfileT;
import com.globaltade.talent.enums.CodeUserT;
import com.globaltade.talent.exception.BusinessException;
import com.globaltade.talent.exception.PersistenceException;
import com.globaltade.talent.service.IUserService;
import com.globaltade.talent.transaction.TransactionUser;
import com.globaltade.talent.utils.Constantes;
import com.globaltade.talent.validator.UserValidator;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	public TransactionUser createUser(TransactionUser transactionUserRequest) {
		try {
			UserValidator.validateUser(transactionUserRequest.getUser());
			this.getIdUser(transactionUserRequest);
			transactionUserRequest.getUser().setStatus(Constantes.STATUS_ACTIVE);
			if(transactionUserRequest.isExist()) {
				this.userDao.update(transactionUserRequest.getUser());
			}else {
				this.userDao.persist(transactionUserRequest.getUser());
			}
			transactionUserRequest.setUser(transactionUserRequest.getUser());
			transactionUserRequest.setResponseCode(CodeUserT.SUS_QUERY_REGISTER.getCode());
			transactionUserRequest.setDescriptionCode(CodeUserT.SUS_QUERY_REGISTER.getDescription());
		} catch (PersistenceException spe) {
			transactionUserRequest.setResponseCode(CodeUserT.XUS_PERSISTENCE.getCode());
			transactionUserRequest.setDescriptionCode(spe.getMessage());
		} catch(BusinessException ue) {
			transactionUserRequest.setResponseCode(ue.getErrorCode());
			transactionUserRequest.setDescriptionCode(ue.getDescriptionCode());
		}
		return transactionUserRequest;
	}

	@Override
	public TransactionUser updateUser(TransactionUser transactionUserRequest) {
		try {
			UserValidator.validateUser(transactionUserRequest.getUser());
			this.getUser(transactionUserRequest);
			if(transactionUserRequest.isExist()) {
				throw CodeUserT.SUS_QUERY_FIND.buildUserException();
			}
			transactionUserRequest.getUser().setUpdateDate(new Date());
			userDao.update(transactionUserRequest.getUser());
			transactionUserRequest.setUser(transactionUserRequest.getUser());
			transactionUserRequest.setResponseCode(CodeUserT.SUS_QUERY_UPDATE.getCode());
			transactionUserRequest.setDescriptionCode(CodeUserT.SUS_QUERY_UPDATE.getDescription());
		} catch (PersistenceException spe) {
			transactionUserRequest.setResponseCode(CodeUserT.XUS_PERSISTENCE.getCode());
			transactionUserRequest.setDescriptionCode(spe.getMessage());
		} catch(BusinessException ue) {
			transactionUserRequest.setResponseCode(ue.getErrorCode());
			transactionUserRequest.setDescriptionCode(ue.getDescriptionCode());
		}
		return transactionUserRequest;
	}

	public TransactionUser deleteUser(TransactionUser transactionUser) {
		try {
			this.getIdUser(transactionUser);
			if(transactionUser.isExist()) {
				throw CodeUserT.SUS_QUERY_FIND.buildUserException();
			}
			transactionUser.getUser().setUpdateDate(new Date());
			transactionUser.getUser().setStatus(Constantes.STATUS_INACTIVE);
			userDao.update(transactionUser.getUser());
			transactionUser.setUser(transactionUser.getUser());
			transactionUser.setResponseCode(CodeUserT.SUS_QUERY_DELETE.getCode());
			transactionUser.setDescriptionCode(CodeUserT.SUS_QUERY_DELETE.getDescription());
		} catch (PersistenceException spe) {
			transactionUser.setResponseCode(CodeUserT.XUS_PERSISTENCE.getCode());
			transactionUser.setDescriptionCode(spe.getMessage());
		} catch(BusinessException ue) {
			transactionUser.setResponseCode(ue.getErrorCode());
			transactionUser.setDescriptionCode(ue.getDescriptionCode());
		}
		return transactionUser;
	}
	
	@Override
	public TransactionUser getUser(TransactionUser transactionUserRequest) {
		try {
			UserValidator.validateUser(transactionUserRequest.getUser());
			final User userDB = StringUtils.isNotBlank(transactionUserRequest.getUser().getMail())
					? userDao.getUserByMail(transactionUserRequest.getUser().getMail())
					: userDao.getUserByPhone(transactionUserRequest.getUser().getPhone());
			if(userDB == null) {
				transactionUserRequest.setResponseCode(CodeProfileT.SPR_QUERY_NOTFIND.getCode());
				transactionUserRequest.setDescriptionCode(CodeProfileT.SPR_QUERY_NOTFIND.getDescription());
				transactionUserRequest.setExist(false);
			}else {
				transactionUserRequest.setUser(userDB);;
				transactionUserRequest.setResponseCode(CodeProfileT.SPR_QUERY_FIND.getCode());
				transactionUserRequest.setDescriptionCode(CodeProfileT.SPR_QUERY_FIND.getDescription());
				transactionUserRequest.setExist(true);
			}
		} catch (PersistenceException spe) {
			transactionUserRequest.setResponseCode(CodeUserT.XUS_PERSISTENCE.getCode());
			transactionUserRequest.setDescriptionCode(spe.getMessage());
		} catch(BusinessException ue) {
			transactionUserRequest.setResponseCode(ue.getErrorCode());
			transactionUserRequest.setDescriptionCode(ue.getDescriptionCode());
		}
		return transactionUserRequest;
	}
	
	@Override
	public TransactionUser getIdUser(TransactionUser transactionUserRequest) {
		try {
			UserValidator.validateUserKey(transactionUserRequest.getUser());
			final User userDB = StringUtils.isNotBlank(transactionUserRequest.getUser().getMail())
					? userDao.getUserByMail(transactionUserRequest.getUser().getMail())
					: userDao.getUserByPhone(transactionUserRequest.getUser().getPhone());
			if(userDB == null) {
				transactionUserRequest.setResponseCode(CodeProfileT.SPR_QUERY_NOTFIND.getCode());
				transactionUserRequest.setDescriptionCode(CodeProfileT.SPR_QUERY_NOTFIND.getDescription());
				transactionUserRequest.setExist(false);
			}else {
				transactionUserRequest.getUser().setIdUser(userDB.getIdUser());
				transactionUserRequest.setResponseCode(CodeProfileT.SPR_QUERY_FIND.getCode());
				transactionUserRequest.setDescriptionCode(CodeProfileT.SPR_QUERY_FIND.getDescription());
				transactionUserRequest.setExist(true);
			}
		} catch (PersistenceException spe) {
			transactionUserRequest.setResponseCode(CodeUserT.XUS_PERSISTENCE.getCode());
			transactionUserRequest.setDescriptionCode(spe.getMessage());
		} catch(BusinessException ue) {
			transactionUserRequest.setResponseCode(ue.getErrorCode());
			transactionUserRequest.setDescriptionCode(ue.getDescriptionCode());
		}
		return transactionUserRequest;
	}
	
}
