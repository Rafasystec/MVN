package br.com.barcadero.module.sat.socket;

import br.com.barcadero.commons.socket.SocketDados;

public class CmdConsultarSAT extends SocketDados {
	private int numeroSessao;

	public int getNumeroSessao() {
		return numeroSessao;
	}

	public void setNumeroSessao(int numeroSessao) {
		this.numeroSessao = numeroSessao;
	}
}
