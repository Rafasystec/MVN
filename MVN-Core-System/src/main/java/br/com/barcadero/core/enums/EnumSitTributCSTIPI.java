package br.com.barcadero.core.enums;

public enum EnumSitTributCSTIPI {

	_00("Entrada com recuperação de crédito", 00),
	_01("Entrada tributada com alíquota zero",01),
	_02("Entrada isenta",02),
	_03("Entrada não-tributada",03),
	_04("Entrada imune",04),
	_05("Entrada com suspensão",05),
	_49("Outras Entradas", 49),
	_50("Saída tributada",50),
	_51("Saída tributada com alíquota zero",51),
	_52("Saída isenta",52),
	_53("Saída não-tributada",53),
	_54("Saída imune",54),
	_55("Saída com suspensão",55),
	_99("Outras saídas",99);
	
	private final String label;
	private final int cst;
	EnumSitTributCSTIPI(String label, int cst){
		this.label = label;
		this.cst	= cst;
	}
	public String getLabel() {
		return label;
	}
	public int getCst() {
		return cst;
	}
}

/*
 
  Código da Situação Tributária do IPI:
00-Entrada com recuperação de crédito
49 - Outras entradas
50-Saída tributada
99-Outras saídas
 
01-Entrada tributada com alíquota zero
02-Entrada isenta
03-Entrada não-tributada
04-Entrada imune
05-Entrada com suspensão
51-Saída tributada com alíquota zero
52-Saída isenta
53-Saída não-tributada
54-Saída imune
55-Saída com suspensão 
 
 * 
 * */
