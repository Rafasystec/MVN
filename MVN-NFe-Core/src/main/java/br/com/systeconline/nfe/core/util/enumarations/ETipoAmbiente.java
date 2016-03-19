package br.com.systeconline.nfe.core.util.enumarations;

public enum ETipoAmbiente {
	PRODUCAO("1"),
	HOMOLOGACAO("2");
	
	private final String value;
	ETipoAmbiente(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}
