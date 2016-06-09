package br.com.barcadero.module.sat.enums;

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
public enum EnumCSTCOFINSNT {
	/**
	 * 04 - Operação Tributável
(tributação monofásica (alíquota
zero));
	 */
	@XmlEnumValue("04") OPER_TRIBUT_ALIQ_MONO,
	/**
	 * 06 - Operação Tributável
(alíquota zero);
	 */
	@XmlEnumValue("06") OPER_TRIBUT_ALIQ_ZERO,
	/**
	 * 07 - Operação Isenta da
Contribuição;
	 */
	@XmlEnumValue("07") OPER_ISENTA_TRIBUTACA,
	/**
	 * 08 - Operação Sem Incidência
da Contribuição;
	 */
	@XmlEnumValue("08") OPER_SEM_INCIDENCIA,
	/**
	 * 09 - Operação com Suspensão
da Contribuição;
	 */
	@XmlEnumValue("09") OPER_COM_SUSPENSAO
}







