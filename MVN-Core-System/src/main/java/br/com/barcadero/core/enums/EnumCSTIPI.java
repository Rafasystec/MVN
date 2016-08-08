package br.com.barcadero.core.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
/**
 * Esse Enum também é utilizado na formacao de alguns XML
 * @author Rafael Rocha
 * @since Versao 1.0 - 08/08/2016
 */
@XmlType
@XmlEnum
public enum EnumCSTIPI {
	
	
	@XmlEnumValue("00") ENTRADA_REDUZ_CREDITO_00("00","Entrada com Recuperação de Crédito"),
	@XmlEnumValue("01") ENTRADA_TRIBUTAVEL_ALIQ_ZERO_01("01","Entrada Tributável com Alíquota Zero"),
	@XmlEnumValue("02") ENTRADA_ISENTA_02 ("02",	"Entrada Isenta"),
	@XmlEnumValue("03") ENTRADA_NAO_TRIBUTADA_03 ("03",	"Entrada Não-Tributada"),
	@XmlEnumValue("04") ENTRADA_IMUNE_04 ("04",	"Entrada Imune"),
	@XmlEnumValue("05") ENTRADA_SUSPENSAO_05 ("05",	"Entrada com Suspensão"),
	@XmlEnumValue("49") OUTRAS_ENTRADAS_49("49",	"Outras Entradas"),
	@XmlEnumValue("50") SAIDA_TRIBUTADA_50("50",	"Saída Tributada"),
	@XmlEnumValue("51") SAIDA_TRIBUTAVEL_ALIQ_ZERO_51("51",	"Saída Tributável com Alíquota Zero"),
	@XmlEnumValue("52") SAIDA_ISENTA_52("52",	"Saída Isenta       "),
	@XmlEnumValue("53") SAIDA_NAO_TRIBUTADA_53("53",	"Saída Não-Tributada"),
	@XmlEnumValue("54") SAIDA_IMUNE_54("54",	"Saída Imune        "),
	@XmlEnumValue("55") SAIDA_COM_SUSPENSAO_55("55",	"Saída com Suspensão"),
	@XmlEnumValue("99") OUTRAS_SAIDAS_99("99",	"Outras Saídas");
	
	private final String value;
	private final String label;
	EnumCSTIPI(String value, String label){
		this.value = value;
		this.label = label;
	}
	public String getValue() {
		return value;
	}
	public String getLabel() {
		return label;
	}


}
