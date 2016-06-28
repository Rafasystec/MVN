package br.com.barcadero.core.enums;

public enum EnumTipoOS {
	
	ORCAMENTO("O"),
	OS_VENDA("V"),
	GARANTIA("G"),
	TRANSFERENCIA("T"),
	RESERVA("R");
	
	private final String value;
	private EnumTipoOS(String value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	

}
