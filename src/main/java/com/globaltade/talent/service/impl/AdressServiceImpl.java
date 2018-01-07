package com.globaltade.talent.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globaltade.talent.dao.IAdressDao;
import com.globaltade.talent.dominio.Adress;
import com.globaltade.talent.enums.ErrorAdressT;
import com.globaltade.talent.exception.AdressException;
import com.globaltade.talent.exception.PersistenceException;
import com.globaltade.talent.service.IAdressService;
import com.globaltade.talent.transaction.TransactionAdress;
import com.globaltade.talent.utils.Constantes;
import com.globaltade.talent.validator.AdressValidator;

@Service("adressService")
@Transactional
public class AdressServiceImpl implements IAdressService {

	@Autowired
	private IAdressDao adressDao;

	@SuppressWarnings("unchecked")
	public TransactionAdress getAllAdress() {
		TransactionAdress transactionAdress = new TransactionAdress(); 
		try {
			List<Adress> listAdress = (List<Adress>) adressDao.getAll();
			if(listAdress == null || listAdress.isEmpty()) {
				transactionAdress.setResponseCode(ErrorAdressT.ADRESSSUCCES_QUERY_EMPTYLISTADRESSRESULT.getErrorCode());
				transactionAdress.setDescriptionCode(ErrorAdressT.ADRESSSUCCES_QUERY_EMPTYLISTADRESSRESULT.getErrorDescription());
				transactionAdress.setTotalResult(Constantes.CONSULTA_TOTALVACIO);
			}else {
				transactionAdress.setListAdress(listAdress);
				transactionAdress.setResponseCode(ErrorAdressT.ADRESSSUCCES_QUERY_LISTADRESSRESULT.getErrorCode());
				transactionAdress.setDescriptionCode(ErrorAdressT.ADRESSSUCCES_QUERY_LISTADRESSRESULT.getErrorDescription());
				transactionAdress.setTotalResult(listAdress.size());
			}
		} catch (PersistenceException spe) {
			transactionAdress.setResponseCode(ErrorAdressT.ADRESSERROR_PERSISTANCE_ADRESSEXCEPTION.getErrorCode());
			transactionAdress.setDescriptionCode(spe.getMessage());
		}
		return transactionAdress;
	}

	public TransactionAdress getAdressById(TransactionAdress transactionAdress) {
		try {
			AdressValidator.validateAdressById(transactionAdress.getAdress());
			Adress adressdb = adressDao.getById(transactionAdress.getAdress().getNbIdAdress());
			if(adressdb == null) {
				transactionAdress.setResponseCode(ErrorAdressT.ADRESSSUCCES_QUERY_EMPTYADRESSRESULT.getErrorCode());
				transactionAdress.setDescriptionCode(ErrorAdressT.ADRESSSUCCES_QUERY_EMPTYADRESSRESULT.getErrorDescription());
				transactionAdress.setTotalResult(Constantes.CONSULTA_TOTALVACIO);
			}else {
				transactionAdress.setAdress(adressdb);
				transactionAdress.setResponseCode(ErrorAdressT.ADRESSSUCCES_QUERY_ADRESSRESULT.getErrorCode());
				transactionAdress.setDescriptionCode(ErrorAdressT.ADRESSSUCCES_QUERY_ADRESSRESULT.getErrorDescription());
				transactionAdress.setTotalResult(Constantes.NUMERO_UNO);
			}
		} catch (PersistenceException spe) {
			transactionAdress.setResponseCode(ErrorAdressT.ADRESSERROR_PERSISTANCE_ADRESSEXCEPTION.getErrorCode());
			transactionAdress.setDescriptionCode(spe.getMessage());
		} catch(AdressException ue) {
			transactionAdress.setResponseCode(ue.getErrorCode());
			transactionAdress.setDescriptionCode(ue.getDescriptionCode());
		}
		return transactionAdress;
	}

	public TransactionAdress saveAdress(TransactionAdress transactionAdress) {
		try {
			AdressValidator.validateAdress(transactionAdress.getAdress());
			adressDao.persist(transactionAdress.getAdress());
			transactionAdress.setAdress(transactionAdress.getAdress());
			transactionAdress.setResponseCode(ErrorAdressT.ADRESSSUCCES_QUERY_PERSISTADRESSRESULT.getErrorCode());
			transactionAdress.setDescriptionCode(ErrorAdressT.ADRESSSUCCES_QUERY_PERSISTADRESSRESULT.getErrorDescription());
			transactionAdress.setTotalResult(Constantes.NUMERO_UNO);
		} catch (PersistenceException spe) {
			transactionAdress.setResponseCode(ErrorAdressT.ADRESSERROR_PERSISTANCE_ADRESSEXCEPTION.getErrorCode());
			transactionAdress.setDescriptionCode(spe.getMessage());
		} catch(AdressException ue) {
			transactionAdress.setResponseCode(ue.getErrorCode());
			transactionAdress.setDescriptionCode(ue.getDescriptionCode());
		}
		return transactionAdress;
	}

	@Override
	public TransactionAdress updateAdress(TransactionAdress transactionAdress) {
		try {
			AdressValidator.validateAdress(transactionAdress.getAdress());
			transactionAdress.getAdress().setDtUpdateDate(new Date());
			adressDao.update(transactionAdress.getAdress());
			transactionAdress.setAdress(transactionAdress.getAdress());
			transactionAdress.setResponseCode(ErrorAdressT.ADRESSSUCCES_QUERY_UPDATEADRESSSRESULT.getErrorCode());
			transactionAdress.setDescriptionCode(ErrorAdressT.ADRESSSUCCES_QUERY_UPDATEADRESSSRESULT.getErrorDescription());
			transactionAdress.setTotalResult(Constantes.NUMERO_UNO);
		} catch (PersistenceException spe) {
			transactionAdress.setResponseCode(ErrorAdressT.ADRESSERROR_PERSISTANCE_ADRESSEXCEPTION.getErrorCode());
			transactionAdress.setDescriptionCode(spe.getMessage());
		} catch(AdressException ue) {
			transactionAdress.setResponseCode(ue.getErrorCode());
			transactionAdress.setDescriptionCode(ue.getDescriptionCode());
		}
		return transactionAdress;
	}

	public TransactionAdress deleteAdress(TransactionAdress transactionAdress) {
		try {
			AdressValidator.validateAdressById(transactionAdress.getAdress());
			transactionAdress.getAdress().setDtUpdateDate(new Date());
			transactionAdress.getAdress().setNbStatus(Constantes.STATUS_INACTIVE);
			adressDao.update(transactionAdress.getAdress());
			transactionAdress.setAdress(transactionAdress.getAdress());
			transactionAdress.setResponseCode(ErrorAdressT.ADRESSSUCCES_QUERY_UPDATEADRESSSRESULT.getErrorCode());
			transactionAdress.setDescriptionCode(ErrorAdressT.ADRESSSUCCES_QUERY_UPDATEADRESSSRESULT.getErrorDescription());
			transactionAdress.setTotalResult(Constantes.NUMERO_UNO);
		} catch (PersistenceException spe) {
			transactionAdress.setResponseCode(ErrorAdressT.ADRESSERROR_PERSISTANCE_ADRESSEXCEPTION.getErrorCode());
			transactionAdress.setDescriptionCode(spe.getMessage());
		} catch(AdressException ue) {
			transactionAdress.setResponseCode(ue.getErrorCode());
			transactionAdress.setDescriptionCode(ue.getDescriptionCode());
		}
		return transactionAdress;
	}
	
	@Override
	public TransactionAdress adressExist(TransactionAdress transactionAdress) {
		transactionAdress = getAdressById(transactionAdress);
		if(!ErrorAdressT.ADRESSSUCCES_QUERY_ADRESSRESULT.getErrorCode().equals(transactionAdress.getResponseCode())) {
			transactionAdress.setExist(Constantes.ISUNIQUE_FALSE);
		}else {
			transactionAdress.setExist(Constantes.ISUNIQUE_TRUE);
		}
		return transactionAdress;
	}
	
}
