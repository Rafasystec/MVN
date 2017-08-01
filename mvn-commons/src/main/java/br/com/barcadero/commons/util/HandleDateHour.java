package br.com.barcadero.commons.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.com.barcadero.commons.enuns.EnumDateHourFormat;

public class HandleDateHour {
	
	public static void main(String[] args) {
		 System.out.println(HandleDateHour.getFirstDateOfMonth());
		 System.out.println(HandleDateHour.getLastDateOfMonth());
		 Date date = HandleDateHour.getDate(2017, 11, 3);
		 System.out.println(HandleDateHour.format(date, "dd/MM/yyyy"));
	}
	
	public static String format(Date date, String outputFormat) {
		SimpleDateFormat dfo = new SimpleDateFormat(outputFormat);
		String dtFormat = dfo.format(date);
		return dtFormat;
	}
	
	public static String format(Date date, EnumDateHourFormat outputFormat) {
		SimpleDateFormat dfo = new SimpleDateFormat(outputFormat.getValue());
		String dtFormat = dfo.format(date);
		return dtFormat;
	}
	
	public static String getCurrentYear() {
		return HandleDateHour.format(new Date(), EnumDateHourFormat.CURRENT_YEAR);
	}
	
	public static String getCurrentMonth() {
		return HandleDateHour.format(new Date(), EnumDateHourFormat.CURRENT_MONTH);
	}
	
	public static String getCurrentDay() {
		return HandleDateHour.format(new Date(), EnumDateHourFormat.CURRENT_DAY);
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
	
	public static Date getDate(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, convertIntToMonth(month), day);
		return calendar.getTime(); 
	}
	
	private static int convertIntToMonth(int month) {
		switch (month) {
		case 1:
			return Calendar.JANUARY;
		case 2:
			return Calendar.FEBRUARY;
		case 3:
			return Calendar.MARCH;
		case 4:
			return Calendar.APRIL;
		case 5:
			return Calendar.MAY;
		case 6:
			return Calendar.JUNE;
		case 7:
			return Calendar.JULY;
		case 8:
			return Calendar.AUGUST;
		case 9:
			return Calendar.SEPTEMBER;
		case 10:
			return Calendar.OCTOBER;
		case 11:
			return Calendar.NOVEMBER;
		case 12:
			return Calendar.DECEMBER;
		default:
			return 0;
		}
	}

}
