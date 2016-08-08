package br.com.barcadero.core.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Tipos de PIS que podem ocorrer no produto.
 * @author Rafael Rocha
 *
 */
@XmlType
@XmlEnum
public enum EnumTipoPIS {
	@XmlEnumValue("PIS_ALIQUOTA") 	PIS_ALIQUOTA,
	@XmlEnumValue("PIS_NT") 		PIS_NT,
	@XmlEnumValue("PIS_OUTRO") 		PIS_OUTRO,
	@XmlEnumValue("PIS_QTDE") 		PIS_QTDE,
	@XmlEnumValue("PIS_SN") 		PIS_SN
}
