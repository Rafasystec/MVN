package br.com.barcadero.module.sat.socket;

import br.com.barcadero.commons.socket.SocketDados;

public class CmdConsultarNumeroSessao extends SocketDados {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3097277284990688146L;
	private int numeroSessao; 
	private String codigoDeAtivacao; 
	private int cNumeroDeSessao;
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
	public int getcNumeroDeSessao() {
		return cNumeroDeSessao;
	}
	public void setcNumeroDeSessao(int cNumeroDeSessao) {
		this.cNumeroDeSessao = cNumeroDeSessao;
	}
	
	
}
