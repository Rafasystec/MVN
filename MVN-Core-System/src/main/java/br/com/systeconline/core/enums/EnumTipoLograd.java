package br.com.systeconline.core.enums;

public enum EnumTipoLograd {
	
	
	ALAMEDA("Alameda","ALAMENDA"),
	AVENIDA("Avenida","AVENIDA"),
	RUA("Rua","RUA"),
	BECO("Beco","BECO"),
	TRAVESSA("Travessa", "TRAVESSA");
	
	public String getLable() {
		return this.lable;
	}
	public String getValue() {
		return value;
	}
	
	private String lable;
	private String value;
	EnumTipoLograd(String item, String value){
		this.lable  = item;
		this.value  = value;
	}
	
	

}
