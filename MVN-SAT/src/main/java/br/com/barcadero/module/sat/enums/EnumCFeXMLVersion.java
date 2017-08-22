package br.com.barcadero.module.sat.enums;

public enum EnumCFeXMLVersion {
	
	V_0_06("0.06"),
	V_0_07("0.07"),
	V_0_08("0.08");
	private final String value;
	EnumCFeXMLVersion(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}

}
