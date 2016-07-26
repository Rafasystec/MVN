package br.com.barcadero.module.sat.socket;

import br.com.barcadero.commons.socket.SocketDados;

public class CmdAtivarSAT extends SocketDados {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4138281864344722657L;
	private int numeroSessao; 
	private int subComando; 
	private String codigoDeAtivacao; 
	private String cnpj;
	private int cUF;
	
	public int getNumeroSessao() {
		return numeroSessao;
	}
	public void setNumeroSessao(int numeroSessao) {
		this.numeroSessao = numeroSessao;
	}
	public int getSubComando() {
		return subComando;
	}
	public void setSubComando(int subComando) {
		this.subComando = subComando;
	}
	public String getCodigoDeAtivacao() {
		return codigoDeAtivacao;
	}
	public void setCodigoDeAtivacao(String codigoDeAtivacao) {
		this.codigoDeAtivacao = codigoDeAtivacao;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public int getcUF() {
		return cUF;
	}
	public void setcUF(int cUF) {
		this.cUF = cUF;
	}

}
