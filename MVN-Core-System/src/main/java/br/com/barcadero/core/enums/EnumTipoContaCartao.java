package br.com.barcadero.core.enums;
/**
 * 
 * @author Rafael Rocha
 * @since 2.0 - dia 29/07/2017 as 20:39
 */
public enum EnumTipoContaCartao {

	CONTA_CORRENTE("CONTA CORRENTE"),
	CONTA_POUPANCA("CONTA POUPANÇA"),
	CONTA_INVESTIMENTO("CONTA INVESTIMENTO");
	
	private final String descricao;
	EnumTipoContaCartao(String descricao){
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}
	
}
