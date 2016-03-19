package br.com.systeconline.rule;

import java.util.Date;

public class FacadeHelperData {
	public static Date getDataAtual() {
		//Obtem a data atual no formato Date
		Date date = new Date(System.currentTimeMillis());
		return date;
	}
}
