package com.globaltade.talent.servicio.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globaltade.talent.dao.IAdressDao;
import com.globaltade.talent.dominio.Adress;
import com.globaltade.talent.enums.ErrorUserT;
import com.globaltade.talent.exception.AbilityException;
import com.globaltade.talent.exception.PersistenceException;
import com.globaltade.talent.servicio.IAbilityService;
import com.globaltade.talent.transaction.TransactionAbility;
import com.globaltade.talent.transaction.TransactionAdress;
import com.globaltade.talent.utils.Constantes;
import com.globaltade.talent.utils.NumericUtil;
import com.globaltade.talent.validator.AdressValidator;

@Service("abilityService")
@Transactional
public class AbilityServiceImpl implements IAbilityService {

	@Autowired
	private IAdressDao adressDao;

//	@SuppressWarnings("unchecked")
//	public TransactionAbility getAllAbility() {
//		TransactionAbility transactionAbility = new TransactionAbility(); 
//		try {
//			List<Adress> listAdress = (List<Adress>) adressDao.getAll();
//			if(listAdress == null || listAdress.isEmpty()) {
//				transactionAbility.setErrorCode(ErrorUserT.USERSUCCES_QUERY_EMPTYLISTUSERRESULT.getErrorCode());
//				transactionAbility.setDescriptionCode(ErrorUserT.USERSUCCES_QUERY_EMPTYLISTUSERRESULT.getErrorDescription());
//				transactionAbility.setTotalResult(Constantes.CONSULTA_TOTALVACIO);
//			}else {
//				transactionAbility.setListAdress(listAdress);
//				transactionAbility.setErrorCode(ErrorUserT.USERSUCCES_QUERY_LISTUSERRESULT.getErrorCode());
//				transactionAbility.setDescriptionCode(ErrorUserT.USERSUCCES_QUERY_LISTUSERRESULT.getErrorDescription());
//				transactionAbility.setTotalResult(listAdress.size());
//			}
//		} catch (PersistenceException spe) {
//			transactionAbility.setErrorCode(ErrorUserT.USERERROR_PERSISTANCE_USEREXCEPTION.getErrorCode());
//			transactionAbility.setDescriptionCode(spe.getMessage());
//		}
//		return transactionAbility;
//	}
//
//	public TransactionAbility getAbilityById(TransactionAbility transactionAbility) {
//		try {
//			AdressValidator.validateUserById(transactionAbility.getAdress());
//			Adress userdb = adressDao.getById(NumericUtil.string2Integer(transactionAbility.getAdress().getStIdAdress()));
//			if(userdb == null) {
//				transactionAbility.setErrorCode(ErrorUserT.USERSUCCES_QUERY_EMPTYUSERRESULT.getErrorCode());
//				transactionAbility.setDescriptionCode(ErrorUserT.USERSUCCES_QUERY_EMPTYUSERRESULT.getErrorDescription());
//				transactionAbility.setTotalResult(Constantes.CONSULTA_TOTALVACIO);
//			}else {
//				transactionAbility.setAdress(userdb);
//				transactionAbility.setErrorCode(ErrorUserT.USERSUCCES_QUERY_USERRESULT.getErrorCode());
//				transactionAbility.setDescriptionCode(ErrorUserT.USERSUCCES_QUERY_USERRESULT.getErrorDescription());
//				transactionAbility.setTotalResult(Constantes.NUMERO_UNO);
//			}
//		} catch (PersistenceException spe) {
//			transactionAbility.setErrorCode(ErrorUserT.USERERROR_PERSISTANCE_USEREXCEPTION.getErrorCode());
//			transactionAbility.setDescriptionCode(spe.getMessage());
//		} catch(AbilityException ue) {
//			transactionAbility.setErrorCode(ue.getErrorCode());
//			transactionAbility.setDescriptionCode(ue.getDescriptionCode());
//		}
//		return transactionAbility;
//	}
//
//	public TransactionAbility saveAbility(TransactionAbility transactionAbility) {
//		try {
//			AdressValidator.validateAdress(transactionAbility.getAdress());
//			adressDao.persist(transactionAbility.getAdress());
//			transactionAbility.setAdress(transactionAbility.getAdress());
//			transactionAbility.setErrorCode(ErrorUserT.USERSUCCES_QUERY_PERSISTUSERSRESULT.getErrorCode());
//			transactionAbility.setDescriptionCode(ErrorUserT.USERSUCCES_QUERY_PERSISTUSERSRESULT.getErrorDescription());
//			transactionAbility.setTotalResult(Constantes.NUMERO_UNO);
//		} catch (PersistenceException spe) {
//			transactionAbility.setErrorCode(ErrorUserT.USERERROR_PERSISTANCE_USEREXCEPTION.getErrorCode());
//			transactionAbility.setDescriptionCode(spe.getMessage());
//		} catch(AbilityException ue) {
//			transactionAbility.setErrorCode(ue.getErrorCode());
//			transactionAbility.setDescriptionCode(ue.getDescriptionCode());
//		}
//		return transactionAbility;
//	}
//
//	@Override
//	public TransactionAbility updateAbility(TransactionAbility transactionAbility) {
//		try {
//			AdressValidator.validateAdress(transactionAbility.getAdress());
//			transactionAbility.getAdress().setDtUpdateDate(new Date());
//			adressDao.update(transactionAbility.getAdress());
//			transactionAbility.setAdress(transactionAbility.getAdress());
//			transactionAbility.setErrorCode(ErrorUserT.USERSUCCES_QUERY_UPDATEUSERSRESULT.getErrorCode());
//			transactionAbility.setDescriptionCode(ErrorUserT.USERSUCCES_QUERY_UPDATEUSERSRESULT.getErrorDescription());
//			transactionAbility.setTotalResult(Constantes.NUMERO_UNO);
//		} catch (PersistenceException spe) {
//			transactionAbility.setErrorCode(ErrorUserT.USERERROR_PERSISTANCE_USEREXCEPTION.getErrorCode());
//			transactionAbility.setDescriptionCode(spe.getMessage());
//		} catch(AbilityException ue) {
//			transactionAbility.setErrorCode(ue.getErrorCode());
//			transactionAbility.setDescriptionCode(ue.getDescriptionCode());
//		}
//		return transactionAbility;
//	}
//
//	public TransactionAbility deleteAbility(TransactionAbility transactionAbility) {
//		try {
//			AdressValidator.validateUserById(transactionAbility.getAdress());
//			transactionAbility.getAdress().setDtUpdateDate(new Date());
//			transactionAbility.getAdress().setNbStatus(Constantes.STATUS_INACTIVE);
//			adressDao.update(transactionAbility.getAdress());
//			transactionAbility.setAdress(transactionAbility.getAdress());
//			transactionAbility.setErrorCode(ErrorUserT.USERSUCCES_QUERY_UPDATEUSERSRESULT.getErrorCode());
//			transactionAbility.setDescriptionCode(ErrorUserT.USERSUCCES_QUERY_UPDATEUSERSRESULT.getErrorDescription());
//			transactionAbility.setTotalResult(Constantes.NUMERO_UNO);
//		} catch (PersistenceException spe) {
//			transactionAbility.setErrorCode(ErrorUserT.USERERROR_PERSISTANCE_USEREXCEPTION.getErrorCode());
//			transactionAbility.setDescriptionCode(spe.getMessage());
//		} catch(AbilityException ue) {
//			transactionAbility.setErrorCode(ue.getErrorCode());
//			transactionAbility.setDescriptionCode(ue.getDescriptionCode());
//		}
//		return transactionAbility;
//	}
	
}
