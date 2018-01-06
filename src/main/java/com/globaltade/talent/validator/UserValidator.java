package com.globaltade.talent.validator;

import org.apache.commons.lang3.StringUtils;

import com.globaltade.talent.dominio.User;
import com.globaltade.talent.enums.ErrorUserT;
import com.globaltade.talent.exception.UserException;

public class UserValidator {

	public static void validateSaveUser(User user) throws UserException {
		if(user == null) {
			throw ErrorUserT.USERERROR_PARAMETER_EMPTYUSER.buildUserException();
		}
//		if(StringUtils.isEmpty(user.getStIdUser())) {
//			throw ErrorUserT.USERERROR_PAREMETER_EMPTYIDUSER.buildEmployeeException();
//		}
//		if(!ValidatorUtils.isNumeric(user.getStIdUser())) {
//			throw ErrorUserT.USERERROR_PAREMETER_NOTDOUBLE_IDUSER.buildEmployeeException();
//		}
		if(StringUtils.isBlank(user.getName())) {
			throw ErrorUserT.USERERROR_PAREMETER_NAME.buildUserException();
		}
		if(StringUtils.isBlank(user.getLastName1())) {
			throw ErrorUserT.USERERROR_PAREMETER_LASTNAME.buildUserException();
		}
		if(StringUtils.isBlank(user.getMail())) {
			throw ErrorUserT.USERERROR_PAREMETER_MAIL.buildUserException();
		}
	}
	
	public static void validateUserUnique(User user) throws UserException {
		if(user == null) {
			throw ErrorUserT.USERERROR_PARAMETER_EMPTYUSER.buildUserException();
		}
		if(StringUtils.isBlank(user.getMail())) {
			throw ErrorUserT.USERERROR_PAREMETER_MAIL.buildUserException();
		}
	}
	
	public static void validateUserById(User user) throws UserException {
		if(user == null) {
			throw ErrorUserT.USERERROR_PARAMETER_EMPTYUSER.buildUSerException("");
		}
//		if(StringUtils.isBlank(user.getIdUser())) {
//			throw ErrorUserT.USERERROR_PAREMETER_EMPTYIDUSER.buildEmployeeException("");
//		}
//		if(!ValidatorUtils.isNumeric(user.getIdUser())) {
//			throw ErrorUserT.USERERROR_PAREMETER_NOTDOUBLE_IDUSER.buildEmployeeException("");
//		}
	}
	
}
