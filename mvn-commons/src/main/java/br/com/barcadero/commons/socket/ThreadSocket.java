package br.com.barcadero.commons.socket;

import java.io.IOException;
import java.net.Socket;

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
				System.out.println("OK - Recebendo dados do host: " + cmd.getIpHost());
				System.out.println("Comando: " + cmd.getCommand());
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
	

}
