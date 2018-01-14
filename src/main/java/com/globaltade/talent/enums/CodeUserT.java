package com.globaltade.talent.enums;

import org.apache.commons.lang3.StringUtils;

import com.globaltade.talent.exception.BusinessException;

public enum CodeUserT {
	
	SUS_QUERY_FIND("SPR000","Usuario encontrado"),
	SUS_QUERY_NOTFIND("SPR001","Usuario no encontrado"),
	SUS_QUERY_REGISTER("SPR002","El usuario fue registrado correctamente"),
	SUS_QUERY_UPDATE("SPR003","El usuario fue actualizado correctamente"),
	SUS_QUERY_DELETE("SPR004","El usuario fue eliminado correctamente"),
	SUS_QUERY_SELECT("SPR005","Cosutla exitosa"),
	
	XUS_PERSISTENCE("XAD000","Error de persistencia en transacción Usuario"),
	
	EUS_PARAM_REQUIRED("EPR001","Error por parametros requeridos"),
	EUS_PARAM_FORMAT_PHONE("EPR002","Error de formato en el parámetro Teléfono"),
	EUS_PARAM_FORMAT_MAIL("EPR003","Error de formato en el parámetro Correo"),
	EUS_PARAM_FORMAT("EPR004","Error de formato en parámetros de entrada"),
	
	;
	
	String code;
	String description;
	
	public String getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	CodeUserT(String code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public BusinessException buildUserException() {
		return buildUSerException(null);
	}
	
	public BusinessException buildUSerException(String msg) {
		String nueva = StringUtils.defaultIfEmpty(msg, "");
		return new BusinessException(code,description + " : " + nueva);
	}
	
}
