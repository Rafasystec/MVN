package br.com.barcadero.core.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Enum utilizado em outros processos
 * @author Rafael Rocha
 *
 */
@XmlType
@XmlEnum
public enum EnumCSTICMS {
	@XmlEnumValue("00") _00("Tributada integralmente"),
	@XmlEnumValue("10") _10("Tributada e com cobrança do ICMS por substituição tributária"),
	@XmlEnumValue("20") _20("Com redução de base de cálculo"),
	@XmlEnumValue("30") _30("Isenta ou não tributada e com cobrança do ICMS por substituição tributária"),
	@XmlEnumValue("40") _40("Isenta"),
	@XmlEnumValue("41") _41("Não tributada"),
	@XmlEnumValue("50") _50("Suspensão"),
	@XmlEnumValue("51") _51("Diferimento"),
	@XmlEnumValue("60") _60("ICMS cobrado anteriormente por substituição tributária"),
	@XmlEnumValue("70") _70("Com redução de base de cálculo e cobrança do ICMS por substituição tributária"),
	@XmlEnumValue("90") _90("outros");
	private final String label;
	EnumCSTICMS(String label){
		this.label = label;
	}
	public String getLabel() {
		return label;
	}
	
	

}

/*
 
 00 - Tributada integralmente
 10 - Tributada e com cobrança do ICMS por substituição tributária
 20 - Com redução de base de cálculo
 30 - Isenta ou não tributada e com cobrança do ICMS por substituição tributária	
 40 - Isenta 
41 - Não tributada 
50 - Suspensão 
51 - Diferimento
60 - ICMS cobrado anteriormente por substituição tributária

70 - Com redução de base de cálculo e cobrança do ICMS por substituição tributária
 
  O código de Situação Tributária é composto de 3 (três) dígitos na forma ABB, 
  sendo que o primeiro dígito deve indicar a origem da mercadoria ou do serviço, 
  com base na Tabela A; e os segundo e terceiro dígitos, a tributação pelo ICMS, 
  com base na Tabela B (Ajuste SINIEF 06/08).
  
 */ 
