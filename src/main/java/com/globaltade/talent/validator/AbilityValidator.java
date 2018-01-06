package com.globaltade.talent.validator;

import org.apache.commons.lang3.StringUtils;

import com.globaltade.talent.dominio.Adress;
import com.globaltade.talent.enums.ErrorUserT;
import com.globaltade.talent.exception.UserException;

public class AbilityValidator {

	public static void validateAdress(Adress adress) throws UserException {
		if(adress == null) {
			throw ErrorUserT.USERERROR_PARAMETER_EMPTYUSER.buildUserException();
		}
	}
	
	public static void validateUserById(Adress adress) throws UserException {
		if(adress == null) {
			throw ErrorUserT.USERERROR_PARAMETER_EMPTYUSER.buildUSerException("");
		}
	}
	
}
