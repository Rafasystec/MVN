package br.com.barcadero.core.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * @author antoniorafael
 *
 */
@XmlType
@XmlEnum
public enum EnumTipoProduto {

	@XmlEnumValue("NORMAL") NORMAL,
	@XmlEnumValue("LENTE") LENTE,
	@XmlEnumValue("ARMACAO") ARMACAO,
}
