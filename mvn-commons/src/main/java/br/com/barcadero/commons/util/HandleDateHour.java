package br.com.barcadero.commons.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.com.barcadero.commons.enuns.EnumDateHourFormat;

public class HandleDateHour {
	
	public static void main(String[] args) {
		 System.out.println(HandleDateHour.getFirstDateOfMonth());
		 System.out.println(HandleDateHour.getLastDateOfMonth());
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
	
	public static Date addYears(Date date, int numYears) {  
		return getDateCalendar(date, Calendar.YEAR, numYears); 
	}
	
	public static Date addDays(Date date, int numDays) {  
		return getDateCalendar(date, Calendar.DAY_OF_MONTH, numDays);  
	}
	
	private static Date getDateCalendar(Date date, int typeIncremet, int times) {
		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(date);    
		calendar.add(typeIncremet, times);  
		return calendar.getTime();
	}
	
	public static Date getFirstDateOfMonth() {
		Calendar date = Calendar.getInstance();
		date.set(Calendar.DAY_OF_MONTH, 1);
		return date.getTime();
	}
	
	public static Date getLastDateOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		return calendar.getTime(); 
	}

}
