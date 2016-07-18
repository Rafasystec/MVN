package br.com.barcadero.commons.enuns;

public enum EnumDateHourFormat {
	
	YYYY_MM_DD("yyyy/MM/dd"),
	DD_MM_YYYY("dd/MM/yyyy"),
	YYYYMMDD("yyyyMMdd"),
	DDMMYYYY("ddMMyyyy"),
	DDMMYYYY_HHMMSS("ddMMyyyyHHmmss"),
	HHMMSS("HHmmss"),
	MINUTES("mm"),
	SECONDS("ss"),
	CURRENT_MONTH("MM"),
	CURRENT_DAY("dd"),
	CURRENT_HOUR("HH"),
	CURRENT_YEAR("yyyy"),
	CURRENT_DATE("dd/MM/yyyy"),
	CURRENT_DATE_TIME("dd/MM/yyyy HH:mm:ss"),
	CURRENT_TIME("HH:mm"),
	CURRENT_TIME_WITH_SECONDS("HH:mm:ss");
	private final String value;
	EnumDateHourFormat(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}

}
