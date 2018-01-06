package com.globaltade.talent.enums;

import org.apache.commons.lang3.StringUtils;

import com.globaltade.talent.exception.AdressException;

public enum ErrorAdressT {
	
	ADRESSSUCCES_QUERY_ADRESSRESULT("SAD000","Consulta exitosa; Se encontró la dirección"),
	ADRESSSUCCES_QUERY_EMPTYADRESSRESULT("SAD001","Consulta exitosa; No se encontró la dirección"),
	ADRESSSUCCES_QUERY_EMPTYLISTADRESSRESULT("SAD002","Cosutla exitosa; No se encontraron direcciones"),
	ADRESSSUCCES_QUERY_PERSISTADRESSRESULT("SAD003","La dirección fue registrado correctamente"),
	ADRESSSUCCES_QUERY_UPDATEADRESSSRESULT("SAD004","La dirección fue actualizado correctamente"),
	ADRESSSUCCES_QUERY_LISTADRESSRESULT("SAD005","Consutla exitosa; La búsqueda contiene registros"),
	ADRESSSUCCES_QUERY_DELETEADRESSRESULT("SAD006","La dirección fue eliminado correctamente"),
	
	ADRESSERROR_PARAMETER_EMPTYADRESS("EAD001","El parámetro de Usuario está vacío"),
	ADRESSERROR_PAREMETER_NOTIDADRESS("EAD002","El parámetro ID de Dirección incorrecto"),
	ADRESSERROR_PAREMETER_STREET("EAD003","El parámetro de Calle no es correcto"),
	ADRESSERROR_PAREMETER_CITY("EAD004","El parámetro de Ciudad no es correcto"),
	ADRESSERROR_QUERY_NOTADRESS("EAD005","No se encontró la dirección"),
	ADRESSERROR_QUERY_ADRESSINSYSTEM("EAD006","La dirección existe actualmente en el sistema"),
	
	ADRESSERROR_PERSISTANCE_ADRESSEXCEPTION("XAD000","Error de persistencia en transacción Dirección")
	;
	
	String responseCode;
	String errorDescription;
	
	public String getErrorCode() {
		return responseCode;
	}
	
	public String getErrorDescription() {
		return errorDescription;
	}
	
	ErrorAdressT(String responseCode, String errorDescription) {
		this.responseCode = responseCode;
		this.errorDescription = errorDescription;
	}
	
	public AdressException buildAdressException() {
		return buildAdressException(null);
	}
	
	public AdressException buildAdressException(String msg) {
		String nueva = StringUtils.defaultIfEmpty(msg, "");
		return new AdressException(responseCode,errorDescription + " : " + nueva);
	}
	
}
