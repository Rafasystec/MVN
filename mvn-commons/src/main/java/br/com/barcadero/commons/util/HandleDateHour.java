package br.com.barcadero.commons.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.barcadero.commons.enuns.EnumDateHourFormat;

public class HandleDateHour {
	
	public static void main(String[] args) {
		 new HandleDateHour().format(new Date(), "dd/MM/yyyy");
	}
	
	public String format(Date date, String outputFormat) {
		SimpleDateFormat dfo = new SimpleDateFormat(outputFormat);
		String dtFormat = dfo.format(date);
		return dtFormat;
	}
	
	public String format(Date date, EnumDateHourFormat outputFormat) {
		SimpleDateFormat dfo = new SimpleDateFormat(outputFormat.getValue());
		String dtFormat = dfo.format(date);
		return dtFormat;
	}
	
	public static String getCurrentYear() {
		return new HandleDateHour().format(new Date(), EnumDateHourFormat.CURRENT_YEAR);
	}
	
	public static String getCurrentMonth() {
		return new HandleDateHour().format(new Date(), EnumDateHourFormat.CURRENT_MONTH);
	}
	
	public static String getCurrentDay() {
		return new HandleDateHour().format(new Date(), EnumDateHourFormat.CURRENT_DAY);
	}

}
