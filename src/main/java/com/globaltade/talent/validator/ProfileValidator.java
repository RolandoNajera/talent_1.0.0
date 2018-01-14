package com.globaltade.talent.validator;

import org.apache.commons.lang3.StringUtils;

import com.globaltade.talent.dominio.Profile;
import com.globaltade.talent.enums.CodeProfileT;
import com.globaltade.talent.exception.BusinessException;
import com.globaltade.talent.utils.RegexUtil;

public class ProfileValidator {

	public static void validateProfile(Profile profile) throws BusinessException {
		validateProfileKey(profile);
		validateRequiredParamters(profile);
		validateFormatParamters(profile);
	}
	
	public static void validateProfileKey(Profile profile) throws BusinessException {
		if (StringUtils.isBlank(profile.getMail()) && StringUtils.isBlank(profile.getFirstPhone())) {
			throw new BusinessException(CodeProfileT.EPR_PARAM_REQUIRED.getCode(),
					CodeProfileT.EPR_PARAM_REQUIRED.getDescription());
		}
		//TODO validar formato de parámetros
	}

	private static void validateRequiredParamters(Profile profile) throws BusinessException {
		if(StringUtils.isBlank(profile.getNames()) || StringUtils.isBlank(profile.getFirstLastName())) {
			throw new BusinessException(CodeProfileT.EPR_PARAM_REQUIRED.getCode(), CodeProfileT.EPR_PARAM_REQUIRED.getDescription());
		}
	}
	
	private static void validateFormatParamters(Profile profile) {
		if(StringUtils.isNotBlank(profile.getNames())) {
			profile.setNames(RegexUtil.validateStringSequence(profile.getNames()));
		}
	}

}
