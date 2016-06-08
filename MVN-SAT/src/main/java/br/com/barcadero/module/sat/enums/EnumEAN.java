package br.com.barcadero.module.sat.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum
public enum EnumEAN {
	@XmlEnumValue("") NENHUN,
	@XmlEnumValue("GTIN-8")  GTIN_8,
	@XmlEnumValue("GTIN-12") GTIN_12,
	@XmlEnumValue("GTIN-13") GTIN_13,
	@XmlEnumValue("GTIN-14") GTIN_14,
}
