package br.com.barcadero.core.enums;

public enum EnumFormaPgto {

	DINHEIRO("DINHEIRO"),
	CHEQUE("CHEQUE"),
	CARTAO_CREDITO("CARTÃO DE CRÉDITO"),
	CARTAO_DEBITO("CARTÃO DE DÉBITO"),
	DEBITO_EM_CONTA("DÉBITO EM CONTA"),
	TRANSF_CELULAR("TRANSF. CELULAR"),
	VOUCHER("VOUCHER");
	
	private final String descricao;
	
	private EnumFormaPgto(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}
}
