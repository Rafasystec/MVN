package br.com.barcadero.commons.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HandleDateHour {
	
	public static void main(String[] args) {
		 new HandleDateHour().format(new Date(), "dd/MM/yyyy");
	}
	
	public String format(Date date, String outputFormat) {
		SimpleDateFormat dfo = new SimpleDateFormat(outputFormat);
		String dtFormat = dfo.format(date);
		return dtFormat;
	}

}
