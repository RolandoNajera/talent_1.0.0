package com.globaltade.talent.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globaltade.talent.dao.IProfileDao;
import com.globaltade.talent.dominio.Profile;
import com.globaltade.talent.enums.CodeProfileT;
import com.globaltade.talent.exception.BusinessException;
import com.globaltade.talent.exception.PersistenceException;
import com.globaltade.talent.service.IProfileService;
import com.globaltade.talent.transaction.TransactionProfile;
import com.globaltade.talent.utils.Constantes;
import com.globaltade.talent.validator.ProfileValidator;

@Service("profileService")
@Transactional
public class ProfileServiceImpl implements IProfileService {

	@Autowired
	private IProfileDao profileDao;
	
	public TransactionProfile createProfile(TransactionProfile transactionProfile) {
		try {
			ProfileValidator.validateProfile(transactionProfile.getProfile());
			this.getIdProfile(transactionProfile);
			transactionProfile.getProfile().setStatus(Constantes.STATUS_ACTIVE);
			if(transactionProfile.isExist()) {
				profileDao.update(transactionProfile.getProfile());
			}else {
				profileDao.persist(transactionProfile.getProfile());
			}
			transactionProfile.setProfile(transactionProfile.getProfile());
			transactionProfile.setResponseCode(CodeProfileT.SPR_QUERY_REGISTER.getCode());
			transactionProfile.setDescriptionCode(CodeProfileT.SPR_QUERY_REGISTER.getDescription());
			transactionProfile.setTotalResult(Constantes.NUMERO_UNO);
		} catch (PersistenceException spe) {
			transactionProfile.setResponseCode(CodeProfileT.XAD_PERSISTENCE.getCode());
			transactionProfile.setDescriptionCode(spe.getMessage());
		} catch(BusinessException ue) {
			transactionProfile.setResponseCode(ue.getErrorCode());
			transactionProfile.setDescriptionCode(ue.getDescriptionCode());
		}
		return transactionProfile;
	}
	
	@Override
	public TransactionProfile updateProfile(TransactionProfile transactionProfile) {
		try {
			ProfileValidator.validateProfile(transactionProfile.getProfile());
			this.getIdProfile(transactionProfile);
			if(!transactionProfile.isExist()) {
				CodeProfileT.SPR_QUERY_NOTFIND.buildUserException();
			}
			transactionProfile.getProfile().setUpdateDate(new Date());
			profileDao.update(transactionProfile.getProfile());
			transactionProfile.setProfile(transactionProfile.getProfile());
			transactionProfile.setResponseCode(CodeProfileT.SPR_QUERY_UPDATE.getCode());
			transactionProfile.setDescriptionCode(CodeProfileT.SPR_QUERY_UPDATE.getDescription());
			transactionProfile.setTotalResult(Constantes.NUMERO_UNO);
		} catch (PersistenceException spe) {
			transactionProfile.setResponseCode(CodeProfileT.XAD_PERSISTENCE.getCode());
			transactionProfile.setDescriptionCode(spe.getMessage());
		} catch(BusinessException ue) {
			transactionProfile.setResponseCode(ue.getErrorCode());
			transactionProfile.setDescriptionCode(ue.getDescriptionCode());
		}
		return transactionProfile;
	}
	
	public TransactionProfile removeProfile(TransactionProfile transactionProfile) {
		try {
			ProfileValidator.validateProfileKey(transactionProfile.getProfile());
			this.getProfile(transactionProfile);
			if(!transactionProfile.isExist()) {
				CodeProfileT.SPR_QUERY_NOTFIND.buildUserException();
			}
			transactionProfile.getProfile().setUpdateDate(new Date());
			transactionProfile.getProfile().setStatus(Constantes.STATUS_INACTIVE);
			profileDao.update(transactionProfile.getProfile());
			transactionProfile.setResponseCode(CodeProfileT.SPR_QUERY_DELETE.getCode());
			transactionProfile.setDescriptionCode(CodeProfileT.SPR_QUERY_DELETE.getDescription());
			transactionProfile.setTotalResult(Constantes.NUMERO_UNO);
		} catch (PersistenceException spe) {
			transactionProfile.setResponseCode(CodeProfileT.XAD_PERSISTENCE.getCode());
			transactionProfile.setDescriptionCode(spe.getMessage());
		} catch(BusinessException ue) {
			transactionProfile.setResponseCode(ue.getErrorCode());
			transactionProfile.setDescriptionCode(ue.getDescriptionCode());
		}
		return transactionProfile;
	}
	
	public TransactionProfile getProfile(TransactionProfile transactionProfile) {
		try {
			ProfileValidator.validateProfileKey(transactionProfile.getProfile());
			final Profile profileDB = StringUtils.isNotBlank(transactionProfile.getProfile().getMail())
					? profileDao.getProfileByMail(transactionProfile.getProfile().getMail())
					: profileDao.getProfileByPhone(transactionProfile.getProfile().getFirstPhone());
			if(profileDB == null) {
				transactionProfile.setResponseCode(CodeProfileT.SPR_QUERY_NOTFIND.getCode());
				transactionProfile.setDescriptionCode(CodeProfileT.SPR_QUERY_NOTFIND.getDescription());
				transactionProfile.setTotalResult(Constantes.CONSULTA_TOTALVACIO);
				transactionProfile.setExist(false);
			}else {
				transactionProfile.setProfile(profileDB);
				transactionProfile.setResponseCode(CodeProfileT.SPR_QUERY_FIND.getCode());
				transactionProfile.setDescriptionCode(CodeProfileT.SPR_QUERY_FIND.getDescription());
				transactionProfile.setTotalResult(Constantes.NUMERO_UNO);
				transactionProfile.setExist(true);
			}
		} catch (PersistenceException spe) {
			transactionProfile.setResponseCode(CodeProfileT.XAD_PERSISTENCE.getCode());
			transactionProfile.setDescriptionCode(spe.getMessage());
		} catch(BusinessException ue) {
			transactionProfile.setResponseCode(ue.getErrorCode());
			transactionProfile.setDescriptionCode(ue.getDescriptionCode());
		}
		return transactionProfile;
	}

	@SuppressWarnings("unchecked")
	public TransactionProfile readProfiles() {
		TransactionProfile transactionProfile = new TransactionProfile(); 
		try {
			List<Profile> listProfiles = (List<Profile>) profileDao.getAll();
			if(listProfiles == null || listProfiles.isEmpty()) {
				transactionProfile.setTotalResult(Constantes.CONSULTA_TOTALVACIO);
			}else {
				transactionProfile.setListProfile(listProfiles);
				transactionProfile.setTotalResult(listProfiles.size());
			}
			transactionProfile.setResponseCode(CodeProfileT.SPR_QUERY_SELECT.getCode());
			transactionProfile.setDescriptionCode(CodeProfileT.SPR_QUERY_SELECT.getDescription());
		} catch (PersistenceException spe) {
			transactionProfile.setResponseCode(CodeProfileT.XAD_PERSISTENCE.getCode());
			transactionProfile.setDescriptionCode(spe.getMessage());
		}
		return transactionProfile;
	}
	
	public TransactionProfile getIdProfile(TransactionProfile transactionProfile) {
		try {
			ProfileValidator.validateProfileKey(transactionProfile.getProfile());
			final Profile profileDB = StringUtils.isNotBlank(transactionProfile.getProfile().getMail())
					? profileDao.getProfileByMail(transactionProfile.getProfile().getMail())
					: profileDao.getProfileByPhone(transactionProfile.getProfile().getFirstPhone());
			if(profileDB == null) {
				transactionProfile.setResponseCode(CodeProfileT.SPR_QUERY_NOTFIND.getCode());
				transactionProfile.setDescriptionCode(CodeProfileT.SPR_QUERY_NOTFIND.getDescription());
				transactionProfile.setTotalResult(Constantes.CONSULTA_TOTALVACIO);
				transactionProfile.setExist(false);
			}else {
				transactionProfile.getProfile().setIdProfile(profileDB.getIdProfile());;
				transactionProfile.setResponseCode(CodeProfileT.SPR_QUERY_FIND.getCode());
				transactionProfile.setDescriptionCode(CodeProfileT.SPR_QUERY_FIND.getDescription());
				transactionProfile.setTotalResult(Constantes.NUMERO_UNO);
				transactionProfile.setExist(true);
			}
		} catch (PersistenceException spe) {
			transactionProfile.setResponseCode(CodeProfileT.XAD_PERSISTENCE.getCode());
			transactionProfile.setDescriptionCode(spe.getMessage());
		} catch(BusinessException ue) {
			transactionProfile.setResponseCode(ue.getErrorCode());
			transactionProfile.setDescriptionCode(ue.getDescriptionCode());
		}
		return transactionProfile;
	}

}
