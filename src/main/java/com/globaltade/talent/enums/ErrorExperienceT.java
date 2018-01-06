package com.globaltade.talent.enums;

import org.apache.commons.lang3.StringUtils;

import com.globaltade.talent.exception.ExperienceException;

public enum ErrorExperienceT {
	USERERROR_PARAMETER_EMPTYADRESS("AE001","El parámetro de Dirección está vacío"),
	USERERROR_PAREMETER_EMPTYIDADRESS("AE002","El parámetro ID de Usuario incorrecto"),
	USERERROR_PAREMETER_NOTDOUBLE_IDUSER("UE003","El parámetro ID de Usuario incorrecto"),
	USERERROR_PAREMETER_NAME("UE004","El parámetro Nombre de Usuario incorrecto"),
	USERERROR_PAREMETER_LASTNAME("UE004","El parámetro apellido paterno de Usuario incorrecto"),
	USERERROR_PAREMETER_MAIL("UE004","El parámetro correo de Usuario incorrecto"),
	USERERROR_PERSISTANCE_USEREXCEPTION("UE005","Error de persistencia"),
	USERSUCCES_QUERY_USERRESULT("US000","Se encontró al usuario"),
	USERSUCCES_QUERY_EMPTYUSERRESULT("US001","No se encontró el usuario"),
	USERSUCCES_QUERY_EMPTYUSERSRESULT("US002","No se encontraron usuarios"),
	USERSUCCES_QUERY_PERSISTUSERSRESULT("US004","Se registró exitosamente el usuario"),
	USERSUCCES_QUERY_UPDATEUSERSRESULT("US005","Se registró exitosamente el usuario"),
	USERSUCCES_QUERY_LISTUSERRESULT("US003","Éxito en la consulta de usuarios")
	;
	
	String errorCode;
	String errorDescription;
	
	public String getErrorCode() {
		return errorCode;
	}
	
	public String getErrorDescription() {
		return errorDescription;
	}
	
	ErrorExperienceT(String errorCode, String errorDescription) {
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}
	
	public ExperienceException buildExperienceException() {
		return buildExperienceException(null);
	}
	
	public ExperienceException buildExperienceException(String msg) {
		String nueva = StringUtils.defaultIfEmpty(msg, "");
		return new ExperienceException(errorCode,errorDescription + " : " + nueva);
	}
	
}
