package br.com.barcadero.core.enums;

public enum EnumCentroCusto {
	
	ALIMENTACAO("ALIMENTAÇÃO"),
	COMBUSTIVEL("COMBUSTÍVEL"),
	ALUGUEL("ALUGUEL"),
	TRANSPORTE("TRANSPORTE"),
	REFEICAO("REFEIÇÃO"),
	ENTRETERDIMENTO("ENTRETERDIMENTO"),
	SEGURO("SEGURO"),
	IPVA("IPVA"),
	CARRO("CARRO"),
	MOTO("MOTO"),
	SAUDE("SAUDE"),
	EDUCACAO("EDUCAÇÃO"),
	VESTUARIO("VESTUÁRIO"),
	CONDOMINIO("CONDOMINIO"),
	FINANCIAMENTO("FINANCIAMENTO"),
	INTERNET("INTERNET"),
	PREVIDENCIA("PREVIDENCIA"),
	OUTROS("OUTROS");
	
	private final String descricao;
	private EnumCentroCusto(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}

}
