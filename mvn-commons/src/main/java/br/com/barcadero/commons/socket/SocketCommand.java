package br.com.barcadero.commons.socket;

import java.io.Serializable;

/**
 * Objeto que deverar ser serializado para envio de comando via socket
 * @author antoniorafael
 *
 */
public class SocketCommand implements Serializable{

	
	private static final long serialVersionUID = -3061594662428238860L;
	private String ipHost;
	private String command;
	private String codigoExecucao;
	private SocketDados dados;
	private String response;
	
	public String getIpHost() {
		return ipHost;
	}
	public void setIpHost(String ipHost) {
		this.ipHost = ipHost;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getCodigoExecucao() {
		return codigoExecucao;
	}
	public void setCodigoExecucao(String codigoExecucao) {
		this.codigoExecucao = codigoExecucao;
	}
	public SocketDados getDados() {
		return dados;
	}
	public void setDados(SocketDados dados) {
		this.dados = dados;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}

}
