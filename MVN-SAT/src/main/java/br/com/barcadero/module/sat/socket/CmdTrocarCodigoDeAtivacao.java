package br.com.barcadero.module.sat.socket;

import br.com.barcadero.commons.socket.SocketDados;

public class CmdTrocarCodigoDeAtivacao extends SocketDados {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7301625341423870702L;
	private int numeroSessao;
	private String codigoDeAtivacao;
	private int opcao;
	private String novoCodigo;
	private String confNovoCodigo;
	
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
	public int getOpcao() {
		return opcao;
	}
	public void setOpcao(int opcao) {
		this.opcao = opcao;
	}
	public String getNovoCodigo() {
		return novoCodigo;
	}
	public void setNovoCodigo(String novoCodigo) {
		this.novoCodigo = novoCodigo;
	}
	public String getConfNovoCodigo() {
		return confNovoCodigo;
	}
	public void setConfNovoCodigo(String confNovoCodigo) {
		this.confNovoCodigo = confNovoCodigo;
	}
}
