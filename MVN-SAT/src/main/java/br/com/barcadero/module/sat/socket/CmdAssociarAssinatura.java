package br.com.barcadero.module.sat.socket;

import br.com.barcadero.commons.socket.SocketDados;

public class CmdAssociarAssinatura extends SocketDados {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3818672520396926821L;
	private int numeroSessao; 
	private String codigoDeAtivacao;
	private String cnpjValue;
	private String assinaturaCNPJs;
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
	public String getCnpjValue() {
		return cnpjValue;
	}
	public void setCnpjValue(String cnpjValue) {
		this.cnpjValue = cnpjValue;
	}
	public String getAssinaturaCNPJs() {
		return assinaturaCNPJs;
	}
	public void setAssinaturaCNPJs(String assinaturaCNPJs) {
		this.assinaturaCNPJs = assinaturaCNPJs;
	}

	
}
