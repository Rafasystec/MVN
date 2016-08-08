package br.com.barcadero.core.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author Rafael Rocha
 *
 */
@XmlType
@XmlEnum
public enum EnumTipoCOFINS {
	@XmlEnumValue("ALIQ") 	COFINS_ALIQ,
	@XmlEnumValue("NT") 	COFINS_NT,
	@XmlEnumValue("OUTRO") 	COFINS_OUTRO,
	@XmlEnumValue("QTDE") 	COFINS_QTDE,
	@XmlEnumValue("SN") 	COFINS_SN
}
