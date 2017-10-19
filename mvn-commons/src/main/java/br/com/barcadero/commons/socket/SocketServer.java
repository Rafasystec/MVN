package br.com.barcadero.commons.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	
	public static int SERVER_PORT 						= 6667;
	public static int CLIENT_PORT 						= 6666;
	static{
		java.lang.System.setProperty("sun.security.ssl.allowUnsafeRenegotiation", "true");
	}
	
	public static void main(String[] args) throws IOException {
		start();
	}

	public static void start() throws IOException {
		ServerSocket server = new ServerSocket(SERVER_PORT);
		System.out.println("Iniciando Thread com socket");
		System.out.println("Porta " + SERVER_PORT + " foi aberta");
		try {
			boolean keepAlive = true;
			while (keepAlive) {
				Socket cliente = server.accept();
				System.out.println("Nova conexão com " + cliente.getInetAddress().getHostAddress());
				ThreadSocket ts = new ThreadSocket(cliente);
				Thread t 		= new Thread(ts);
				t.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			server.close();
		}
	}

}
