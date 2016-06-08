package br.com.barcadero.module.sat.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum
public enum EnumIndRatISSQN {


	@XmlEnumValue("S") SIM("S"),
	@XmlEnumValue("N") NAO("N");
	
	private final String value;
	
	private EnumIndRatISSQN(String value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
