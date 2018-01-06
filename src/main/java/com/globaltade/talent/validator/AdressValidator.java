package com.globaltade.talent.validator;

import org.apache.commons.lang3.StringUtils;

import com.globaltade.talent.dominio.Adress;
import com.globaltade.talent.enums.ErrorAdressT;
import com.globaltade.talent.exception.AdressException;

public class AdressValidator {

	public static void validateAdress(Adress adress) throws AdressException {
		if (adress == null || adress.getNbIdAdress() == null) {
			throw ErrorAdressT.ADRESSERROR_PAREMETER_NOTIDADRESS.buildAdressException();
		}
		if (StringUtils.isEmpty(adress.getTxStreet())) {
			throw ErrorAdressT.ADRESSERROR_PAREMETER_STREET.buildAdressException();
		}
		if (StringUtils.isEmpty(adress.getTxCity())) {
			throw ErrorAdressT.ADRESSERROR_PAREMETER_CITY.buildAdressException();
		}
	}

	public static void validateAdressById(Adress adress) throws AdressException {
		if (adress == null || adress.getNbIdAdress() == null) {
			throw ErrorAdressT.ADRESSERROR_PAREMETER_NOTIDADRESS.buildAdressException();
		}
	}

}
