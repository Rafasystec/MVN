package br.com.barcadero.core.handles;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class HandleNumericFormat {
	
	public static void main(String[] args) {
		//decimal(1.00, 4);
		System.out.println(format(1002.01,4));
	}
	
	public static String decimal(double value, int zerosPosPonto) {
		BigDecimal number = new BigDecimal(value);
		StringBuilder patter = new StringBuilder("#,##0.0");
		for (int i = 0; i < zerosPosPonto; i++) {
			patter.append("#");
		}
		DecimalFormat decFormat = new DecimalFormat(patter.toString());
		String numberFormat = decFormat.format(number);
		System.out.println(numberFormat);
		return numberFormat;
	}

	/**
	 * 
	 * @param value
	 * @param zerosPosPonto
	 * @return
	 */
	public static String format(double value, int zerosPosPonto) {
		//double number = 252.231;
		StringBuilder pattener = new StringBuilder("%1$.");
		pattener.append(zerosPosPonto);
		pattener.append("f");
		String formatValue = String.format(pattener.toString(),	value);
		System.out.println(formatValue);
		return formatValue.replace(",", ".");
	}
	
	/**
	 * 
	 * @param value
	 * @param zerosPosPonto
	 * @return
	 */
	public static String format(String value, int zerosPosPonto) {
		double doubleValue = 0;
		try {
			doubleValue = Double.parseDouble(value);
		} catch (Exception e) {
			doubleValue = 0;
		}
		
		return format(doubleValue, zerosPosPonto);
	}
	/**
	 * Converte uma String numerica em inteiro
	 * @param value
	 * @return
	 */
	public static int parseInt(String value) {
		int result = 0;
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			result = 0;
		}
		return result;
	}
	
	/**
	 * Tranforma uma String numerica em long
	 * @param value
	 * @return
	 */
	public static long parseLong(String value) {
		long result = 0L;
		try {
			return Long.parseLong(value);
		} catch (Exception e) {
			result = 0L;
		}
		return result;
	}
	/**
	 * Transforma String numerica em BigDecimal
	 * @param value
	 * @return
	 */
	public static BigDecimal parseBigDecimal(String value) {
		BigDecimal result = null;
		try {
			result = new BigDecimal(value);
		} catch (Exception e) {
			result = new BigDecimal(0.00);
		}
		return result;
	}

}
