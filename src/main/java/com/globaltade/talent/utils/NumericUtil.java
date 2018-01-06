package com.globaltade.talent.utils;

public class NumericUtil {

	public static Integer string2Integer(String stNumeric) {
		try {
			return Integer.parseInt(stNumeric);
		}catch(NumberFormatException nfe) {
			return null;
		}
	}
	
	public static Double string2Double(String stDouble) {
		try {
			return Double.parseDouble(stDouble);
		}catch(NumberFormatException nfe) {
			return null;
		}
	}
	
}
