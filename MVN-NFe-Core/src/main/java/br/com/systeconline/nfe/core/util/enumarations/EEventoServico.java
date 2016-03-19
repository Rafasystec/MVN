package br.com.systeconline.nfe.core.util.enumarations;

public enum EEventoServico {
	
	RECEPCAO_EVENTO(1),
	NFE_RECEPCAO(2),
	NFE_RET_RECEPICAO(3),
	NFE_INUTILIZACAO(4),
	NFE_CONSULTA_PROTOCOLO(5),
	NFE_STATUS_SERVICO(6),
	NFE_CONSULTA_CADASTRO(7),
	NFE_DOWNLOAD_NFE(8),
	NFE_AUTORIZACAO(9);
	private final int value;
	EEventoServico(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	
}
