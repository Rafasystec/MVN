package br.com.barcadero.module.sat.socket;

import br.com.barcadero.commons.socket.SocketDados;

public class CmdConsultarStatusOperacional extends SocketDados {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5389246496839870832L;
	private int numeroSessao; 
	private String codigoDeAtivacao;
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
	
}
