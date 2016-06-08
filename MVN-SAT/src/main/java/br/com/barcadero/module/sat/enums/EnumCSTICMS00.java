package br.com.barcadero.module.sat.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum
public enum EnumCSTICMS00 {
	
	/**
	 * 00  Tributada integralmente
	 */
	@XmlEnumValue("00") TRIBUTADO_INTEGRALMENTE,
	/**
	 * 20 - Com reducade base de  cálculo
	 */
	@XmlEnumValue("20") REDUCAO_DE_BASE,
	/**
	 * 90 - Outros
	 */
	@XmlEnumValue("90") OUTROS,
	
}






