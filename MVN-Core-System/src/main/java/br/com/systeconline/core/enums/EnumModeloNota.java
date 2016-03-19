package br.com.systeconline.core.enums;

public enum EnumModeloNota {

	MOD_59("Cupom Eletrônico - CF-e"),
	MOD_65("Nota Fiscal Consumidor Eletrônica - NFC-e"),
	MOD_55("Nota Fiscal Eletrônica - NF-e"),
	MOD_57("Conhecimento de Transporte Eletrônico");
	private final String label;
	private EnumModeloNota(String label) {
		// TODO Auto-generated constructor stub
		this.label = label;
	}
	public String getLabel() {
		return label;
	}
	
}
