package br.com.barcadero.testes.beans;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.faces.convert.ConverterException;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.barcadero.web.functions.HandleMessage;

public class TestBeanEmpresa {

	
	
	public static void main(String[] args) {
	
		formatarNumero("123,90");
	}
	
	@BeforeClass
	public static void beforeTest() {
		
	}
	
	@Test
	public void saveEmpresa() {
		
	}
	
	public static void formatarNumero(String value) {
		DecimalFormat df = null;
		try {
			value = value.replace(".","").replace(",", ".");
			df = new DecimalFormat("#,##0.00");
			df.setParseBigDecimal(true);
			BigDecimal decimal = (BigDecimal) df.parse(value);
			System.out.println(decimal.doubleValue());

		} catch (Exception e) {
			throw new ConverterException(HandleMessage.converterError(e.getMessage()));
		}
	}
}
