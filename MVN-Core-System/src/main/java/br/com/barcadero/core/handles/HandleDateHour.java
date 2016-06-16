package br.com.barcadero.core.handles;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Utilizar a classe do pacote br.com.barcadero.commons
 * @author antoniorafael
 *
 */
@Deprecated
public class HandleDateHour {
	
	public static void main(String[] args) {
		 new HandleDateHour().format(new Date(), "dd/MM/yyyy");
	}
	
	public String format(Date date, String outputFormat) {
		SimpleDateFormat dfo = new SimpleDateFormat(outputFormat);
		String dtFormat = dfo.format(date);
		System.out.println(dtFormat);
		return dtFormat;
	}

}
