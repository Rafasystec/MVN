package br.com.systeconline.core.enums;

public enum EnumCSTICMS {
	_00("Tributada integralmente"),
	_10("Tributada e com cobrança do ICMS por substituição tributária"),
	_20("Com redução de base de cálculo"),
	_30("Isenta ou não tributada e com cobrança do ICMS por substituição tributária"),
	_40("Isenta"),
	_41("Não tributada"),
	_50("Suspensão"),
	_51("Diferimento"),
	_60("ICMS cobrado anteriormente por substituição tributária"),
	_70("Com redução de base de cálculo e cobrança do ICMS por substituição tributária"),
	_90("outros");
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
