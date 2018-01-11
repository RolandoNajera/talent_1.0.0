package com.globaltade.talent.enums;

import org.apache.commons.lang3.StringUtils;

import com.globaltade.talent.exception.BusinessException;

public enum CodeProfileT {
	
	SPR_QUERY_FIND("SPR000","Perfil encontrado"),
	SPR_QUERY_NOTFIND("SPR001","Perfil no encontrado"),
	SPR_QUERY_REGISTER("SPR002","El perfil fue registrado correctamente"),
	SPR_QUERY_UPDATE("SPR003","El perfil fue actualizado correctamente"),
	SPR_QUERY_DELETE("SPR004","El perfil fue eliminado correctamente"),
	SPR_QUERY_SELECT("SPR005","Cosutla exitosa"),
	
	XAD_PERSISTENCE("XAD000","Error de persistencia en transacción Dirección"),
	
	EPR_PARAM_REQUIRED("EPR001","Error por parametros requeridos"),
	EPR_PARAM_FORMAT_PHONE("EPR002","Error de formato en el parámetro Teléfono"),
	EPR_PARAM_FORMAT_MAIL("EPR003","Error de formato en el parámetro Correo"),
	EPR_PARAM_FORMAT("EPR004","Error de formato en parámetros de entrada"),
	
	;
	
	String code;
	String description;
	
	public String getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	CodeProfileT(String code, String description) {
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
