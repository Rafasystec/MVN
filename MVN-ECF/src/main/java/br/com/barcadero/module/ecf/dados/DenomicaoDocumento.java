package br.com.barcadero.module.ecf.dados;

public enum DenomicaoDocumento {
	
	CONFERENCIA_DE_MESA("Conferencia de Mesa","CM"),
	REGISTRO_DE_VENDA("Registro de Venda","RV"),
	COMPROVANTE_CCD("Comprovante de Credito ou Debito","CC"),
	COMPROVANTE_NAO_FISCAL("Comprovante Nao-Fiscal","CN"),
	COMPROVANTE_NAO_FISCAL_CANCELADO("Comprovante Nao-Fiscal Cancelado","NC"),
	RELATORIO_GERENCIAL("Relatorio Gerencial","RG");
	
	 
	private final String descricao;
	private final String simbolo  ;
	
	DenomicaoDocumento(String descricao, String simbolo){
		this.descricao 	= descricao;
		this.simbolo	= simbolo;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public String getSimbolo() {
		return simbolo;
	}
}
