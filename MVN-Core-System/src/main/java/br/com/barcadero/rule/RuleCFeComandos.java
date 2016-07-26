package br.com.barcadero.rule;

import br.com.barcadero.commons.enuns.EnumTipoComandoSocket;
import br.com.barcadero.commons.socket.ClientSocket;
import br.com.barcadero.commons.socket.SocketCommand;
import br.com.barcadero.module.sat.socket.CmdAtivarSAT;
import br.com.barcadero.module.sat.socket.CmdConsultarSAT;
import br.com.barcadero.tables.Caixa;

/**
 * Ira enviar os comandos via socket para o modulo SAT.
 * @author antoniorafael
 *
 */
public class RuleCFeComandos {

	private ClientSocket client;
	public RuleCFeComandos(Caixa caixa) {
		// TODO Auto-generated constructor stub
		client = new ClientSocket();
		client.setIpServidor(caixa.getIp());
	}
	
	public String ativarSAT(int numeroSessao, int subComando, String codigoDeAtivacao, String cnpj, int cUF)
			throws Exception {
		SocketCommand command = newSocketCommand();
		CmdAtivarSAT ativarSAT = new CmdAtivarSAT();
		ativarSAT.setCnpj(cnpj);
		ativarSAT.setCodigoDeAtivacao(codigoDeAtivacao);
		ativarSAT.setcUF(cUF);
		ativarSAT.setNumeroSessao(numeroSessao);
		ativarSAT.setSubComando(subComando);
		command.setDados(ativarSAT);
		command = client.callAndReceive(command);
		return command.getResponse();
	}

	
	public String comunicarCertificadoICPBRASIL(int numeroSessao, String codigoDeAtivacao, String certificado)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	public static String enviarDadosVenda(int numeroSessao, String codigoDeAtivacao, String dadosVenda) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String cancelarUltimaVenda(int numeroSessao, String codigoDeAtivacao, String chave, String dadosCancelamento)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Consultar o módulo SAT
	 * @param numeroSessao
	 * @return
	 * @throws Exception
	 */
	public String consultarSAT(int numeroSessao) throws Exception {
		SocketCommand command = newSocketCommandSAT();
		CmdConsultarSAT consultarSAT = new CmdConsultarSAT();
		consultarSAT.setNumeroSessao(numeroSessao);
		command.setDados(consultarSAT);
		command = client.callAndReceive(command);
		return command.getResponse();
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
	
	public SocketCommand newSocketCommandSAT() {
		SocketCommand command = newSocketCommand();
		command.setTipoComando(EnumTipoComandoSocket.CMD_FOR_SAT);
		return command;
	}

}
