package br.com.barcadero.module.sat.socket;

import br.com.barcadero.commons.socket.SocketDados;

public class CmdCancelarUltimaVenda extends SocketDados {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5940188298475642202L;
	private int numeroSessao; 
	private String codigoDeAtivacao; 
	private String chave; 
	private String dadosCancelamento;
	public int getNumeroSessao() {
		return numeroSessao;
	}
	public void setNumeroSessao(int numeroSessao) {
		this.numeroSessao = numeroSessao;
	}
	public String getCodigoDeAtivacao() {
		return codigoDeAtivacao;
	}
	public void setCodigoDeAtivacao(String codigoDeAtivacao) {
		this.codigoDeAtivacao = codigoDeAtivacao;
	}
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public String getDadosCancelamento() {
		return dadosCancelamento;
	}
	public void setDadosCancelamento(String dadosCancelamento) {
		this.dadosCancelamento = dadosCancelamento;
	}

}
