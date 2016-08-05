package br.com.barcadero.local.main;

import java.io.IOException;

import org.hibernate.Session;

import br.com.barcadero.local.persistence.HibernateHelper;
import br.com.barcadero.local.socket.SocketServer;



public class Main {

	private static Session session;
	
	public static void main(String[] args) {
		try {
			iniciarPersistencia();
			SocketServer.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Session getSession() {
		return session;
	}

	public static void setSession(Session session) {
		Main.session = session;
	}
	
	private static void iniciarPersistencia() {
		System.out.println("--------------------------------------------");
		System.out.println("INICIANDO PERSISTENCIA LOCAL");
		System.out.println("--------------------------------------------");
		Main.session = HibernateHelper.getSession();
	}

}
