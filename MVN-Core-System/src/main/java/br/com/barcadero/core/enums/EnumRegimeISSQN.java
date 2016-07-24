package br.com.barcadero.core.enums;

public enum EnumRegimeISSQN {

	MIRCOEMPRESA_MUNICIPAL("Microempresa Municipal","MEM"),
	ESTIMATIVA("Estivativa","EST"),
	SOCIEDADE_DE_PROFISSIONAIS("Sociedade de Profissionais","SDP"),
	COOPERATIVA("Cooperativa","COO"),
	MICROEMPRESARIO_INDIVIDUAL("Microempresário Individual(MEI)","MEI");
	
	private final String descricao;
	private final String value;
	EnumRegimeISSQN(String descricao, String value){
		this.descricao  = descricao;
		this.value		= value;
	}
	public String getDescricao() {
		return descricao;
	}
	public String getValue() {
		return value;
	}
}
