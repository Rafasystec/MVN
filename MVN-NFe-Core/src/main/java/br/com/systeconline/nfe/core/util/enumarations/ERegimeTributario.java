package br.com.systeconline.nfe.core.util.enumarations;

public enum ERegimeTributario {
	
	REG_SIMPLES_NACIONAL("1"),
	REG_SIMPLES_NAC_EXCESSO("2"),
	REG_NORMAL("3");
	private final String value;
	private ERegimeTributario(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}
