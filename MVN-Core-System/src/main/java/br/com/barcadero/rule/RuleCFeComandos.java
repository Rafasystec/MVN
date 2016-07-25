package br.com.barcadero.rule;

import br.com.barcadero.commons.socket.ClientSocket;
import br.com.barcadero.commons.socket.SocketCommand;

/**
 * Ira enviar os comandos via socket para o modulo SAT.
 * @author antoniorafael
 *
 */
public class RuleCFeComandos {

	private ClientSocket client;
	public RuleCFeComandos() {
		// TODO Auto-generated constructor stub
		client = new ClientSocket();
		client.setIpServidor("");
	}
	
	public String ativarSAT(int numeroSessao, int subComando, String codigoDeAtivacao, String cnpj, int cUF)
			throws Exception {
		SocketCommand command = newSocketCommand();
		command = client.callAndReceive(command);
		return null;
	}

	
	public String comunicarCertificadoICPBRASIL(int numeroSessao, String codigoDeAtivacao, String certificado)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String enviarDadosVenda(int numeroSessao, String codigoDeAtivacao, String dadosVenda) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String cancelarUltimaVenda(int numeroSessao, String codigoDeAtivacao, String chave, String dadosCancelamento)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String consultarSAT(int numeroSessao) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String testeFimAFim(int numeroSessao, String codigoDeAtivacao, String dadosVenda) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String consultarStatusOperacional(int numeroSessao, String codigoDeAtivacao) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String consultarNumeroSessao(int numeroSessao, String codigoDeAtivacao, int cNumeroDeSessao)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String configurarInterfaceDeRede(int numeroSessao, String codigoDeAtivacao, String dadosConfiguracao)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String associarAssinatura(int numeroSessao, String codigoDeAtivacao, String cnpjValue,
			String assinaturaCNPJs) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String atualizarSoftwareSAT(int numeroSessao, String codigoDeAtivacao) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String extrairLogs(int numeroSessao, String codigoDeAtivacao) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String bloquearSAT(int numeroSessao, String codigoDeAtivacao) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String desbloquearSAT(int numeroSessao, String codigoDeAtivacao) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String trocarCodigoDeAtivacao(int numeroSessao, String codigoDeAtivacao, int opcao, String novoCodigo,
			String confNovoCodigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public SocketCommand newSocketCommand() {
		SocketCommand command = new SocketCommand();
		command.setIpHost("");
		return command;
	}

}
