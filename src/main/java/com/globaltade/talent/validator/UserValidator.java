package com.globaltade.talent.validator;

import org.apache.commons.lang3.StringUtils;

import com.globaltade.talent.dominio.User;
import com.globaltade.talent.enums.CodeUserT;
import com.globaltade.talent.exception.BusinessException;

public class UserValidator {

	public static void validateUser(User user) throws BusinessException {
		validateUserKey(user);
	}
	
	public static void validateUserKey(User user) throws BusinessException {
		if (StringUtils.isBlank(user.getMail()) && StringUtils.isBlank(user.getPhone())) {
			throw new BusinessException(CodeUserT.EUS_PARAM_REQUIRED.getCode(),
					CodeUserT.EUS_PARAM_REQUIRED.getDescription());
		}
		//TODO validar formato de parámetros
	}
	
}
