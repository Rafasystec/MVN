package br.com.systeconline.nfe.core.util.enumarations;

public enum EModeloNota {
	NFE("55"),
	NFCE("65");
	private final String value;
	EModeloNota(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}
