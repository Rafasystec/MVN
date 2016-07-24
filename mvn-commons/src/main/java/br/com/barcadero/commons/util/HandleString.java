package br.com.barcadero.commons.util;

import java.util.Arrays;

public class HandleString {
	
	
	
	public static String padLeft(String s, int len) {
		return padLeft(s, len, ' ');
	}
	
	public static String zerosLeft(String s, int len) {
		return padLeft(s, len, '0');
	}

	/**
	 * Completa string com dtnado caracteres a esquerda para que ela fique com determinado
	 * tamanho.
	 * 
	 * @param s
	 *            a string a ser completada
	 * @param len
	 *            tamanho desejado
	 * @param padChar
	 *            caractere usado para preencher
	 */
	public static String padLeft(String s, int len, char padChar) {
		String buf = "";
		if (s == null) s = "";
		int slen = s.length();
		if (len > slen) {
			int diff = len - s.length();
			buf = repetir(padChar, diff);
		}
		return (buf + s).substring(0, len);
	}
	
	/**
	 * 
	 * @param pChar
	 * @param vezes
	 * @return
	 */
	public static String repetir(char pChar, int vezes) {
		char retorno[] = new char[vezes];
		Arrays.fill(retorno, pChar);
		return new String(retorno);
	}

	public static String cPFcNPJOnlyNumbers(String cpfCnpj) {
		return cpfCnpj.replace(".", "")
					  .replace("/", "")
					  .replace("-", "");
	}
	
	public static String parse(int value) {
		return String.valueOf(value);
	}
	
	public static String parse(float value) {
		return String.valueOf(value);
	}
	
	public static String parse(double value) {
		return String.valueOf(value);
	}
	
	public static String parse(char value) {
		return String.valueOf(value);
	}
	
	public static String parse(Object value) {
		return String.valueOf(value);
	}
	
	public static String parse(short value) {
		return String.valueOf(value);
	}

}
