package br.com.systeconline.nfe.core.util.enumarations;

public enum EFinalidadeNFe {
	
	NFE_NORMAL("1"),
	NFE_COMPLEMENTAR("2"),
	NFE_DE_AJUSTE("3"),
	NFE_DEVOLUCAO_RETORNO("4");
	
	private final String value;
	EFinalidadeNFe(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}

}
