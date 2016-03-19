package br.com.systeconline.nfe.core.util.enumarations;

public enum ETpEntradaSaida {
	ENTRADA("0"),
	SAIDA("1");
	
	private final String value;
	ETpEntradaSaida(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}
