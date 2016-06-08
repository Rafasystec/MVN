package br.com.barcadero.module.sat.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum
public enum EnumIndRegra {

	@XmlEnumValue("A") ARREDONDAMENTO,
	@XmlEnumValue("T") TRUNCAMENTO
}
