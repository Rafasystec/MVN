package br.com.barcadero.rule;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.stereotype.Service;

import br.com.barcadero.commons.enuns.EnumTipoComandoSocket;
import br.com.barcadero.commons.socket.ClientSocket;
import br.com.barcadero.commons.socket.SocketCommand;
import br.com.barcadero.module.sat.exceptions.SATException;
import br.com.barcadero.module.sat.socket.CmdAssociarAssinatura;
import br.com.barcadero.module.sat.socket.CmdAtivarSAT;
import br.com.barcadero.module.sat.socket.CmdAtualizarSoftwareSAT;
import br.com.barcadero.module.sat.socket.CmdBloquearSAT;
import br.com.barcadero.module.sat.socket.CmdCancelarUltimaVenda;
import br.com.barcadero.module.sat.socket.CmdConsultarNumeroSessao;
import br.com.barcadero.module.sat.socket.CmdConsultarSAT;
import br.com.barcadero.module.sat.socket.CmdConsultarStatusOperacional;
import br.com.barcadero.module.sat.socket.CmdDesbloquearSAT;
import br.com.barcadero.module.sat.socket.CmdEnviarDadosVenda;
import br.com.barcadero.module.sat.socket.CmdExtrairLogs;
import br.com.barcadero.module.sat.socket.CmdTesteFimAFim;
import br.com.barcadero.module.sat.socket.CmdTrocarCodigoDeAtivacao;
import br.com.barcadero.tables.Caixa;

/**
 * Ira enviar os comandos via socket para o modulo SAT.
 * @author antoniorafael
 *
 */
@Service
public class RuleCFeComandos {

	private ClientSocket client;
	private Caixa caixa;
	
	public RuleCFeComandos() {
		// TODO Auto-generated constructor stub
	}
	public RuleCFeComandos(Caixa caixa) {
		// TODO Auto-generated constructor stub
		client = new ClientSocket();
		String ipServer = "";
		if(caixa != null){
			ipServer = caixa.getIp();
		}else{
			try {
				ipServer = InetAddress.getLocalHost().getHostAddress();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				ipServer = "127.0.0.1";
			}
		}
		client.setIpServidor(ipServer);
		setCaixa(caixa);
	}
	/**
	 * 
	 * @param numeroSessao
	 * @param subComando
	 * @param codigoDeAtivacao
	 * @param cnpj
	 * @param cUF
	 * @return
	 * @throws Exception
	 */
	public String ativarSAT(int numeroSessao, int subComando, String codigoDeAtivacao, String cnpj, int cUF)
			throws Exception {
		SocketCommand command = newSocketCommandSAT();
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

	/**
	 * 
	 * @param codigoDeAtivacao
	 * @param certificado
	 * @return
	 * @throws Exception
	 */
	public String comunicarCertificadoICPBRASIL(String codigoDeAtivacao, String certificado)
			throws Exception {
		// TODO Auto-generated method stub
		return "Ainda não implementado!";
	}

	/**
	 * Enviar dados de venda para o SAT ou seja, enviar o XML da venda.
	 * @param codigoDeAtivacao
	 * @param dadosVenda
	 * @return
	 * @throws Exception
	 */
	public String enviarDadosVenda(String codigoDeAtivacao, String dadosVenda) throws Exception {
		SocketCommand command = newSocketCommandSAT();
		CmdEnviarDadosVenda enviarDadosVenda = new CmdEnviarDadosVenda();
		enviarDadosVenda.setCodigoDeAtivacao(codigoDeAtivacao);
		enviarDadosVenda.setDadosVenda(dadosVenda);
		enviarDadosVenda.setNumeroSessao(0);
		command.setModuloSAT(getCaixa().getTipoModuloSAT());
		command.setDados(enviarDadosVenda);
		command = client.callAndReceive(command);
		return command.getResponse();
	}

	/**
	 * Cancela ultima venda desde que esteja no tempo minimo de 30 minutos. Após este tempo não é mais permitido.
	 * @param codigoDeAtivacao
	 * @param chave
	 * @param dadosCancelamento
	 * @return
	 * @throws Exception
	 */
	public String cancelarUltimaVenda(String codigoDeAtivacao, String chave, String dadosCancelamento)	throws SATException {
		SocketCommand command = newSocketCommandSAT();
		CmdCancelarUltimaVenda cancelarUltimaVenda = new CmdCancelarUltimaVenda();
		cancelarUltimaVenda.setChave(chave);
		cancelarUltimaVenda.setCodigoDeAtivacao(codigoDeAtivacao);
		cancelarUltimaVenda.setDadosCancelamento(dadosCancelamento);
		command.setModuloSAT(getCaixa().getTipoModuloSAT());
		command.setDados(cancelarUltimaVenda);
		try {
			command = client.callAndReceive(command);
		} catch (IOException e) {
			throw new SATException("Erro ao enviar comando ao módulo local " + e.getMessage());
		}
		return command.getResponse();
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

	/**
	 * 
	 * @param codigoDeAtivacao
	 * @param dadosVenda
	 * @return
	 * @throws Exception
	 */
	public String testeFimAFim(String codigoDeAtivacao, String dadosVenda) throws Exception {
		SocketCommand command = newSocketCommandSAT();
		CmdTesteFimAFim testeFimAFim = new CmdTesteFimAFim();
		testeFimAFim.setCodigoDeAtivacao(codigoDeAtivacao);
		testeFimAFim.setDadosVenda(dadosVenda);
		testeFimAFim.setNumeroSessao(0);
		command.setDados(testeFimAFim);
		command = client.callAndReceive(command);
		return command.getResponse();
	}

	/**
	 * 
	 * @param codigoDeAtivacao
	 * @return
	 * @throws Exception
	 */
	public String consultarStatusOperacional(String codigoDeAtivacao) throws Exception {
		SocketCommand command = newSocketCommandSAT();
		CmdConsultarStatusOperacional status = new CmdConsultarStatusOperacional();
		status.setCodigoDeAtivacao(codigoDeAtivacao);
		status.setNumeroSessao(0);
		command.setDados(status);
		command = client.callAndReceive(command);
		return command.getResponse();
	}

	/**
	 * 
	 * @param codigoDeAtivacao
	 * @param cNumeroDeSessao
	 * @return
	 * @throws Exception
	 */
	public String consultarNumeroSessao(String codigoDeAtivacao, int cNumeroDeSessao)	throws Exception {
		SocketCommand command = newSocketCommandSAT();
		CmdConsultarNumeroSessao consultarNumeroSessao = new CmdConsultarNumeroSessao();
		consultarNumeroSessao.setcNumeroDeSessao(cNumeroDeSessao);
		consultarNumeroSessao.setCodigoDeAtivacao(codigoDeAtivacao);
		consultarNumeroSessao.setNumeroSessao(0);
		command.setDados(consultarNumeroSessao);
		command = client.callAndReceive(command);
		return command.getResponse();
	}

	/**
	 * 
	 * @param codigoDeAtivacao
	 * @param dadosConfiguracao
	 * @return
	 * @throws Exception
	 */
	public String configurarInterfaceDeRede(String codigoDeAtivacao, String dadosConfiguracao) throws Exception {
		// TODO Auto-generated method stub
		return "Ainda não implementado!";
	}

	/**
	 * 
	 * @param codigoDeAtivacao
	 * @param cnpjValue
	 * @param assinaturaCNPJs
	 * @return
	 * @throws Exception
	 */
	public String associarAssinatura(String codigoDeAtivacao, String cnpjValue,String assinaturaCNPJs) throws Exception {
		SocketCommand command = newSocketCommandSAT();
		CmdAssociarAssinatura assinatura = new CmdAssociarAssinatura();
		assinatura.setAssinaturaCNPJs(assinaturaCNPJs);
		assinatura.setCnpjValue(cnpjValue);
		assinatura.setCodigoDeAtivacao(codigoDeAtivacao);
		assinatura.setNumeroSessao(0);
		command.setDados(assinatura);
		command = client.callAndReceive(command);
		return command.getResponse();
	}

	/**
	 * 
	 * @param codigoDeAtivacao
	 * @return
	 * @throws Exception
	 */
	public String atualizarSoftwareSAT(String codigoDeAtivacao) throws Exception {
		SocketCommand command = newSocketCommandSAT();
		CmdAtualizarSoftwareSAT softwareSAT = new CmdAtualizarSoftwareSAT();
		softwareSAT.setCodigoDeAtivacao(codigoDeAtivacao);
		command.setDados(softwareSAT);
		command = client.callAndReceive(command);
		return command.getResponse();
	}

	/**
	 * 
	 * @param codigoDeAtivacao
	 * @return
	 * @throws Exception
	 */
	public String extrairLogs(String codigoDeAtivacao) throws Exception {
		SocketCommand command = newSocketCommandSAT();
		CmdExtrairLogs extrairLogs = new CmdExtrairLogs();
		extrairLogs.setCodigoDeAtivacao(codigoDeAtivacao);
		command.setDados(extrairLogs);
		command = client.callAndReceive(command);
		return command.getResponse();
	}

	/**
	 * 
	 * @param codigoDeAtivacao
	 * @return
	 * @throws Exception
	 */
	public String bloquearSAT(String codigoDeAtivacao) throws Exception {
		SocketCommand command = newSocketCommandSAT();
		CmdBloquearSAT bloquearSAT = new CmdBloquearSAT();
		bloquearSAT.setCodigoDeAtivacao(codigoDeAtivacao);
		command.setDados(bloquearSAT);
		command = client.callAndReceive(command);
		return command.getResponse();
	}

	/**
	 * 
	 * @param codigoDeAtivacao
	 * @return
	 * @throws Exception
	 */
	public String desbloquearSAT(String codigoDeAtivacao) throws Exception {
		SocketCommand command = newSocketCommandSAT();
		CmdDesbloquearSAT desbloquearSAT = new CmdDesbloquearSAT();
		desbloquearSAT.setCodigoDeAtivacao(codigoDeAtivacao);
		command.setDados(desbloquearSAT);
		command = client.callAndReceive(command);
		return command.getResponse();
	}

	/**
	 * 
	 * @param codigoDeAtivacao
	 * @param opcao
	 * @param novoCodigo
	 * @param confNovoCodigo
	 * @return
	 * @throws Exception
	 */
	public String trocarCodigoDeAtivacao(String codigoDeAtivacao, int opcao, String novoCodigo,String confNovoCodigo) throws Exception {
		SocketCommand command = newSocketCommandSAT();
		CmdTrocarCodigoDeAtivacao trocarCodigoDeAtivacao = new CmdTrocarCodigoDeAtivacao();
		trocarCodigoDeAtivacao.setCodigoDeAtivacao(codigoDeAtivacao);
		trocarCodigoDeAtivacao.setConfNovoCodigo(confNovoCodigo);
		trocarCodigoDeAtivacao.setNovoCodigo(novoCodigo);
		trocarCodigoDeAtivacao.setOpcao(opcao);
		command.setDados(trocarCodigoDeAtivacao);
		command = client.callAndReceive(command);
		return command.getResponse();
	}
	/**
	 * 
	 * @return
	 */
	public SocketCommand newSocketCommand() {
		SocketCommand command = new SocketCommand();
		command.setIpHost("");
		return command;
	}
	/**
	 * 
	 * @return
	 */
	public SocketCommand newSocketCommandSAT() {
		SocketCommand command = newSocketCommand();
		command.setTipoComando(EnumTipoComandoSocket.CMD_FOR_SAT);
		//command.setModuloSAT(getCaixa().getTipoModuloSAT());
		return command;
	}
	public Caixa getCaixa() {
		return caixa;
	}
	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

}
