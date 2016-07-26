package br.com.barcadero.local.main;

import java.io.IOException;

import br.com.barcadero.local.socket.SocketServer;



public class Main {

	public static void main(String[] args) {
		try {
			SocketServer.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
