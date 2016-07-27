package br.com.barcadero.module.sat.socket;

import br.com.barcadero.commons.socket.SocketDados;

public class CmdEnviarDadosVenda extends SocketDados {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5577394889769040778L;
	private int numeroSessao; 
	private String codigoDeAtivacao; 
	private String dadosVenda;
	
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
	public String getDadosVenda() {
		return dadosVenda;
	}
	public void setDadosVenda(String dadosVenda) {
		this.dadosVenda = dadosVenda;
	}
}
