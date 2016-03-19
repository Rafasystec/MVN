package br.com.systeconline.nfe.core.util.enumarations;

public enum EFormaEmissaoNFe {

	NORMAL("1"),
	CONTINGENCIA_FS("2"),
	CONTINGENCIA_SCAN("3"),
	CONTINGENCIA_DPEC("4"),
	CONTINGENCIA_FSDA("5"),
	CONTINGENCIA_SVC_AN("6"),
	CONTINGENCIA_SVC_RS("7"),
	CONTINGENCIA_OFFLINE_NFCE("9");
	private final String value;
	EFormaEmissaoNFe(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}
