package br.com.barcadero.core.enums;
/**
 * 
 * @author Rafael Rocha
 * @since dia 29/07/2017 as 20:49
 */
public enum EnumTipoCartao {

	CREDITO("CRÉDITO"),
	DEBITO("DÉBITO"),
	VOUCHER("VOUCHER");
	
	private final String descricao;
	private EnumTipoCartao(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}
}
