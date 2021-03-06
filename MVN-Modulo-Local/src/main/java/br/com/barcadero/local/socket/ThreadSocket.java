package br.com.barcadero.local.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import br.com.barcadero.commons.socket.ClientSocket;
import br.com.barcadero.commons.socket.SocketCommand;
import br.com.barcadero.commons.socket.SocketDados;
import br.com.barcadero.commons.socket.SocketUtil;
import br.com.barcadero.commons.xml.HandleXML;
import br.com.barcadero.module.sat.devices.integrador.vfpe.HelperEnviarPagamento;
import br.com.barcadero.module.sat.devices.integrador.vfpe.VFPeVerificarStatusValidadorResposta;
import br.com.barcadero.module.sat.socket.CmdEnviarPagamentoVFe;
import br.com.barcadero.module.sat.socket.CmdVerificarStatusValidador;

public class ThreadSocket implements Runnable {

	
	public ThreadSocket(Socket cliente) {
		this.cliente = cliente;
	}
	private Socket cliente;
	@Override
	public void run() {
		try {
			if(cliente != null){
				SocketCommand cmd = SocketUtil.getObjectFromStream(cliente);
				System.out.println("OK - Solicitacao de comunicacao do Host: " + cmd.getIpHost());
				System.out.println("Descricao do Comando : " + cmd.getCommand());
				cmd = enviarComando(cmd);
				enviarResposta(cmd);
			}else{
				System.out.println("Cliente nulo nao sera inserido no escalonador");
			}
		}catch (Exception  e) {
			e.printStackTrace();
		}finally {
			System.out.println("Terminou a execucao do comando.");
			try {
				cliente.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public Socket getCliente() {
		return cliente;
	}
	public void setCliente(Socket cliente) {
		this.cliente = cliente;
	}
	
	/**
	 * 
	 * @param comando
	 * @return
	 * @throws InterruptedException
	 */
	private SocketCommand enviarComando(SocketCommand comando) throws InterruptedException {
		ExecutorService poolMFe 	= Executors.newCachedThreadPool();
		Callable<String> callable 	= new ThreadExecute(comando);
		Future<String> future 		= poolMFe.submit(callable);
		try {
			try {
				comando.setResponse(future.get(60, TimeUnit.SECONDS));
				
				if(comando != null){
					SocketDados dados =comando.getDados();
					if(dados instanceof CmdEnviarPagamentoVFe){
						CmdEnviarPagamentoVFe cmdEnviarPagamentoVFe = (CmdEnviarPagamentoVFe) dados;
						cmdEnviarPagamentoVFe.setRetornoParaAplicacao(HelperEnviarPagamento.gerarRetornoParaAplicacao(comando.getResponse()));
						comando.setDados(cmdEnviarPagamentoVFe);
					}else if(dados instanceof CmdVerificarStatusValidador) {
						CmdVerificarStatusValidador cmdVerificarStatusValidador = (CmdVerificarStatusValidador) dados;
						VFPeVerificarStatusValidadorResposta response = new VFPeVerificarStatusValidadorResposta();
						try {
							response = (VFPeVerificarStatusValidadorResposta) HandleXML.unMarshal(comando.getResponse(), VFPeVerificarStatusValidadorResposta.class);
						} catch (Exception e) {
							e.printStackTrace();
						}
						cmdVerificarStatusValidador.setResponse(response);
						comando.setDados(cmdVerificarStatusValidador);
					}
				}
			} catch (TimeoutException e) {
				comando.setResponse("Socket não responde.");
			}
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return comando;
	}
	
	/**
	 * 
	 * @param comando
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	private void enviarResposta(SocketCommand comando) throws UnknownHostException, IOException {
		System.out.println("Enviar resposta para o cliente socket que chamou");
		System.out.println("IP host solicitante: " + comando.getIpHost());
		ClientSocket host = new ClientSocket();
		host.setIpServidor(comando.getIpHost());
		host.sendForRemoteServer(comando);
	}
	

}
