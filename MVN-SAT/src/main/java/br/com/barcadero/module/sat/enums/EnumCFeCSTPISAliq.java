package br.com.barcadero.module.sat.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * CST = 01, 02 e 05 
 * @author Rafael Rocha
 */
@XmlType
@XmlEnum
public enum EnumCFeCSTPISAliq {
/**
 * 01 – Operação Tributável (base
de cálculo = valor da operação
alíquota normal (cumulativo/não
cumulativo));
 */
	@XmlEnumValue("01") CST_01, 
	/**
	 * 02 - Operação Tributável (base
de cálculo = valor da operação
(alíquota diferenciada));
	 */
	@XmlEnumValue("02") CST_02,
	/**
	 * 05 - Operação Tributável por
Substituição Tributária
	 */
	@XmlEnumValue("05") CST_05
}
