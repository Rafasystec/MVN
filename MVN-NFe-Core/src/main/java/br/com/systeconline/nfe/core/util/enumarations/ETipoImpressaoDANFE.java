package br.com.systeconline.nfe.core.util.enumarations;

public enum ETipoImpressaoDANFE {
	
	
	SEM_DANFE("0"),
	DANFE_RETRATO("1"),
	DANFE_PAISAGEM("2"),
	DANFE_SIMPLIFICADO("3"),
	DANFE_NFCE("4"),
	DANFE_NFCE_MSG_ELETRONICA("5");
	
	private final String value;
	ETipoImpressaoDANFE(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}
