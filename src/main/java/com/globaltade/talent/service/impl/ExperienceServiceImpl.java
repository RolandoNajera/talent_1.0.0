package com.globaltade.talent.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globaltade.talent.dao.IExperienceDao;
import com.globaltade.talent.dominio.Experience;
import com.globaltade.talent.enums.ErrorUserT;
import com.globaltade.talent.exception.PersistenceException;
import com.globaltade.talent.exception.UserException;
import com.globaltade.talent.service.IExperienceService;
import com.globaltade.talent.transaction.TransactionAdress;
import com.globaltade.talent.transaction.TransactionExperience;
import com.globaltade.talent.utils.Constantes;
import com.globaltade.talent.validator.AdressValidator;

@Service("experienceService")
@Transactional
public class ExperienceServiceImpl implements IExperienceService {

	@Autowired
	private IExperienceDao experienceDao;

	@SuppressWarnings("unchecked")
	public TransactionExperience getAllExperience() {
		TransactionExperience transactionExperience = new TransactionExperience(); 
		try {
			List<Experience> listExperience = (List<Experience>) experienceDao.getAll();
			if(listExperience == null || listExperience.isEmpty()) {
				transactionExperience.setErrorCode(ErrorUserT.USERSUCCES_QUERY_EMPTYLISTUSERRESULT.getErrorCode());
				transactionExperience.setDescriptionCode(ErrorUserT.USERSUCCES_QUERY_EMPTYLISTUSERRESULT.getErrorDescription());
				transactionExperience.setTotalResult(Constantes.CONSULTA_TOTALVACIO);
			}else {
				transactionExperience.setListExperience(listExperience);
				transactionExperience.setErrorCode(ErrorUserT.USERSUCCES_QUERY_LISTUSERRESULT.getErrorCode());
				transactionExperience.setDescriptionCode(ErrorUserT.USERSUCCES_QUERY_LISTUSERRESULT.getErrorDescription());
				transactionExperience.setTotalResult(listExperience.size());
			}
		} catch (PersistenceException spe) {
			transactionExperience.setErrorCode(ErrorUserT.USERERROR_PERSISTANCE_USEREXCEPTION.getErrorCode());
			transactionExperience.setDescriptionCode(spe.getMessage());
		}
		return transactionExperience;
	}

	public TransactionExperience getExperienceById(TransactionExperience transactionExperience) {
		try {
			//ExperienceValidator.validateUserById(transactionExperience.getExperience());
			Experience experienceDB = experienceDao.getById(transactionExperience.getExperience().getNbIdExperience());
			if(experienceDB == null) {
				transactionExperience.setErrorCode(ErrorUserT.USERSUCCES_QUERY_EMPTYUSERRESULT.getErrorCode());
				transactionExperience.setDescriptionCode(ErrorUserT.USERSUCCES_QUERY_EMPTYUSERRESULT.getErrorDescription());
				transactionExperience.setTotalResult(Constantes.CONSULTA_TOTALVACIO);
			}else {
				transactionExperience.setExperience(experienceDB);
				transactionExperience.setErrorCode(ErrorUserT.USERSUCCES_QUERY_USERRESULT.getErrorCode());
				transactionExperience.setDescriptionCode(ErrorUserT.USERSUCCES_QUERY_USERRESULT.getErrorDescription());
				transactionExperience.setTotalResult(Constantes.NUMERO_UNO);
			}
		} catch (PersistenceException spe) {
			transactionExperience.setErrorCode(ErrorUserT.USERERROR_PERSISTANCE_USEREXCEPTION.getErrorCode());
			transactionExperience.setDescriptionCode(spe.getMessage());
		} 
//		catch(UserException ue) {
//			transactionExperience.setErrorCode(ue.getErrorCode());
//			transactionExperience.setDescriptionCode(ue.getDescriptionCode());
//		}
		return transactionExperience;
	}

	public TransactionExperience saveExperience(TransactionExperience transactionExperience){
		try {
			//AdressValidator.validateAdress(transactionExperience.getExperience());
			experienceDao.persist(transactionExperience.getExperience());
			transactionExperience.setExperience(transactionExperience.getExperience());
			transactionExperience.setErrorCode(ErrorUserT.USERSUCCES_QUERY_PERSISTUSERSRESULT.getErrorCode());
			transactionExperience.setDescriptionCode(ErrorUserT.USERSUCCES_QUERY_PERSISTUSERSRESULT.getErrorDescription());
			transactionExperience.setTotalResult(Constantes.NUMERO_UNO);
		} catch (PersistenceException spe) {
			transactionExperience.setErrorCode(ErrorUserT.USERERROR_PERSISTANCE_USEREXCEPTION.getErrorCode());
			transactionExperience.setDescriptionCode(spe.getMessage());
		}
//		catch(UserException ue) {
//			transactionExperience.setErrorCode(ue.getErrorCode());
//			transactionExperience.setDescriptionCode(ue.getDescriptionCode());
//		}
		return transactionExperience;
	}

	@Override
	public TransactionExperience updateExperience(TransactionExperience transactionExperience) {
		TransactionExperience s = new TransactionExperience();
//		try {
//			AdressValidator.validateAdress(transactionAdressRequest.getAdress());
//			transactionAdressRequest.getAdress().setDtUpdateDate(new Date());
//			adressDao.update(transactionAdressRequest.getAdress());
//			transactionUserResponse.setAdress(transactionAdressRequest.getAdress());
//			transactionUserResponse.setErrorCode(ErrorUserT.USERSUCCES_QUERY_UPDATEUSERSRESULT.getErrorCode());
//			transactionUserResponse.setDescriptionCode(ErrorUserT.USERSUCCES_QUERY_UPDATEUSERSRESULT.getErrorDescription());
//			transactionUserResponse.setTotalResult(Constantes.NUMERO_UNO);
//		} catch (PersistenceException spe) {
//			transactionUserResponse.setErrorCode(ErrorUserT.USERERROR_PERSISTANCE_USEREXCEPTION.getErrorCode());
//			transactionUserResponse.setDescriptionCode(spe.getMessage());
//		} catch(UserException ue) {
//			transactionUserResponse.setErrorCode(ue.getErrorCode());
//			transactionUserResponse.setDescriptionCode(ue.getDescriptionCode());
//		}
		return s;
	}

	public TransactionExperience deleteExperience(TransactionExperience transactionExperience) {
		TransactionExperience transactionExperiensce = new TransactionExperience();
//		try {
//			AdressValidator.validateUserById(transactionAdressRequest.getAdress());
//			transactionAdressRequest.getAdress().setDtUpdateDate(new Date());
//			transactionAdressRequest.getAdress().setNbStatus(Constantes.STATUS_INACTIVE);
//			adressDao.update(transactionAdressRequest.getAdress());
//			transactionUserResponse.setAdress(transactionAdressRequest.getAdress());
//			transactionUserResponse.setErrorCode(ErrorUserT.USERSUCCES_QUERY_UPDATEUSERSRESULT.getErrorCode());
//			transactionUserResponse.setDescriptionCode(ErrorUserT.USERSUCCES_QUERY_UPDATEUSERSRESULT.getErrorDescription());
//			transactionUserResponse.setTotalResult(Constantes.NUMERO_UNO);
//		} catch (PersistenceException spe) {
//			transactionUserResponse.setErrorCode(ErrorUserT.USERERROR_PERSISTANCE_USEREXCEPTION.getErrorCode());
//			transactionUserResponse.setDescriptionCode(spe.getMessage());
//		} catch(UserException ue) {
//			transactionUserResponse.setErrorCode(ue.getErrorCode());
//			transactionUserResponse.setDescriptionCode(ue.getDescriptionCode());
//		}
		return transactionExperience;
	}
	
}
