package br.com.barcadero.module.sat.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum
public enum EnumCSTCOFINSAliq {
	/**
	 * 01 – Operação Tributável (base
de cálculo = valor da operação
alíquota normal (cumulativo/não
cumulativo));
	 */
	@XmlEnumValue("01") OPER_TRIBUT_NORMAL,
	/**
	 * 02 - Operação Tributável (base
de cálculo = valor da operação
(alíquota diferenciada));
	 */
	@XmlEnumValue("02") OPER_TRIBUT_DIFERE,
	/**
	 * 05 - Operação Tributável por
Substituição Tributária;
	 */
	@XmlEnumValue("05") OPER_TRIBUT_SUBSTI;
}




