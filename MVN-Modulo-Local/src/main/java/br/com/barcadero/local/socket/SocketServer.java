package br.com.barcadero.local.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	
	public static int SERVER_PORT 						= 9000;
	static{
		java.lang.System.setProperty("sun.security.ssl.allowUnsafeRenegotiation", "true");
		System.out.println("Criar escalonador");
	}
	
	
	public static void main(String[] args) throws IOException {
		start();
	}

	public static void start() throws IOException {
		ServerSocket server = new ServerSocket(SERVER_PORT);
		try {
			System.out.println("Porta " + SERVER_PORT + " foi aberta");

			boolean keepAlive = true;
			while (keepAlive) {
				//-------------------------------------------------------
				//Preparando o socket para esperar por requisicoes
				//-------------------------------------------------------
				Socket cliente = server.accept();
				System.out.println("Nova conexão com " + cliente.getInetAddress().getHostAddress());
				ThreadSocket ts = new ThreadSocket(cliente);
				Thread t 		= new Thread(ts);
				t.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			server.close();
		}
	}

}
