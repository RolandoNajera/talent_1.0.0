package com.globaltade.talent.validator;

public class ValidatorUtils {

	public static boolean isNumeric(String stNumero) {
		try {
			Integer.parseInt(stNumero);
			return true;
		}catch(NumberFormatException nfe) {
			return false;
		}
	}
	
	public static boolean isDouble(String stDouble) {
		try {
			Double.parseDouble(stDouble);
			return true;
		}catch(NumberFormatException nfe) {
			return false;
		}
	}
	
}
