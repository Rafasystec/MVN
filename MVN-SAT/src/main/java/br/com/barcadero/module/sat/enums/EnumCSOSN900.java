package br.com.barcadero.module.sat.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author Rafael Rocha
 * @since 1.0 - dia 08/06/2016 as 19:39
 */
@XmlEnum
@XmlType
public enum EnumCSOSN900 {
	/**
	 * Tributação pelo ICMS
		900 - Outros
	 */
	@XmlEnumValue("900") OUTROS
}
