package br.com.barcadero.core.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Indica o tipo de ICMS que incide sobre o produto.
 * @author Rafael Rocha
 * @since 1.0 dia 24/07/2016 as 11:40
 */
@XmlType
@XmlEnum
public enum EnumTipoICMS {
	
	@XmlEnumValue("00") ICMS00,
	@XmlEnumValue("40") ICMS40,
	@XmlEnumValue("102") ICMSSN102,
	@XmlEnumValue("900") ICMSSN900
}
