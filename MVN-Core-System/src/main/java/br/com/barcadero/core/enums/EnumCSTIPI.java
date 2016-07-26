package br.com.barcadero.core.enums;

public enum EnumCSTIPI {
	
	
	ENTRADA_REDUZ_CREDITO_00("00","Entrada com Recuperação de Crédito"),
	ENTRADA_TRIBUTAVEL_ALIQ_ZERO_01("01","Entrada Tributável com Alíquota Zero"),
	ENTRADA_ISENTA_02 ("02",	"Entrada Isenta"),
	ENTRADA_NAO_TRIBUTADA_03 ("03",	"Entrada Não-Tributada"),
	ENTRADA_IMUNE_04 ("04",	"Entrada Imune"),
	ENTRADA_SUSPENSAO_05 ("05",	"Entrada com Suspensão"),
	OUTRAS_ENTRADAS_49("49",	"Outras Entradas"),
	SAIDA_TRIBUTADA_50("50",	"Saída Tributada"),
	SAIDA_TRIBUTAVEL_ALIQ_ZERO_51("51",	"Saída Tributável com Alíquota Zero"),
	SAIDA_ISENTA_52("52",	"Saída Isenta       "),
	SAIDA_NAO_TRIBUTADA_53("53",	"Saída Não-Tributada"),
	SAIDA_IMUNE_54("54",	"Saída Imune        "),
	SAIDA_COM_SUSPENSAO_55("55",	"Saída com Suspensão"),
	OUTRAS_SAIDAS_99("99",	"Outras Saídas");
	
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
