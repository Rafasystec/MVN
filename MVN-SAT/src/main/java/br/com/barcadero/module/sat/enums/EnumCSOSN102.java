package br.com.barcadero.module.sat.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Enumeracao para o CSOSN 102
 * @author Rafael Rocha
 * @since 1.0 - dia 08/06/2016 as 19:34
 */
@XmlEnum
@XmlType
public enum EnumCSOSN102 {
	/**
	 * 102- Tributada pelo Simples
Nacional sem permissão de
crédito.
	 */
	@XmlEnumValue("102") TRIBUTADA,
	/**
	 * 300 – Imune
	 */
	@XmlEnumValue("300") IMUNE,
	/**
	 * 400 – Não tributada
	 */
	@XmlEnumValue("400") NAO_TRIBUTADA,
	/**
	 * 500 – ICMS cobrado
anteriormente por substituição
tributária (substituído) ou por
antecipação
	 */
	@XmlEnumValue("500") ICSM_COBRADO
	
}






