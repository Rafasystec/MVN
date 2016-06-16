package br.com.barcadero.core.enums;

public enum EnumTipoAviso {

	W("Aviso"),
	I("Informacao"),
	E("Erro");
	
	private final String label;
	EnumTipoAviso(String label){
		this.label = label;
	}
	public String getLabel() {
		return label;
	}
	
}
