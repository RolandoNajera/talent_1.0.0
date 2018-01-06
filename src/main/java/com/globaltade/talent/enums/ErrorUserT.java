package com.globaltade.talent.enums;

import org.apache.commons.lang3.StringUtils;

import com.globaltade.talent.exception.UserException;

public enum ErrorUserT {
	
	USERSUCCES_QUERY_USERRESULT("SUS000","Consulta exitosa; Se encontró el usuario"),
	USERSUCCES_QUERY_EMPTYUSERRESULT("SUS001","Consulta exitosa; No se encontró el usuario"),
	USERSUCCES_QUERY_EMPTYLISTUSERRESULT("SUS002","Cosutla exitosa; No se encontraron usuarios"),
	USERSUCCES_QUERY_PERSISTUSERSRESULT("SUS003","El usuario fue registrado correctamente"),
	USERSUCCES_QUERY_UPDATEUSERSRESULT("SUS004","El usuario fue actualizado correctamente"),
	USERSUCCES_QUERY_LISTUSERRESULT("SUS005","Cosutla exitosa; La búsqueda contiene registros"),
	USERSUCCES_QUERY_DELETEUSERSRESULT("SUS006","El usuario fue eliminado correctamente"),
	
	USERERROR_PARAMETER_EMPTYUSER("EUS001","El parámetro de Usuario está vacío"),
	USERERROR_PAREMETER_NOTIDUSER("EUS002","El parámetro ID de Usuario incorrecto"),
	USERERROR_PAREMETER_NAME("EUS004","El parámetro Nombre de Usuario incorrecto"),
	USERERROR_PAREMETER_LASTNAME("EUS005","El parámetro apellido paterno de Usuario incorrecto"),
	USERERROR_PAREMETER_MAIL("EUS006","El parámetro correo de Usuario incorrecto"),
	USERERROR_QUERY_NOTUSER("EUS007","No se encontró el usuario a actualizar"),
	USERERROR_QUERY_USERINSYSTEM("EUS008","Elusuario existe actualmente en el sistema"),
	
	USERERROR_PERSISTANCE_USEREXCEPTION("XUS000","Error de persistencia en transacción User")
	
	;
	
	String errorCode;
	String errorDescription;
	
	public String getErrorCode() {
		return errorCode;
	}
	
	public String getErrorDescription() {
		return errorDescription;
	}
	
	ErrorUserT(String errorCode, String errorDescription) {
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}
	
	public UserException buildUserException() {
		return buildUSerException(null);
	}
	
	public UserException buildUSerException(String msg) {
		String nueva = StringUtils.defaultIfEmpty(msg, "");
		return new UserException(errorCode,errorDescription + " : " + nueva);
	}
	
}
