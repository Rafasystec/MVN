package br.com.barcadero.local.main;

import org.hibernate.Session;

import br.com.barcadero.local.persistence.HibernateHelper;
import br.com.barcadero.local.socket.SocketServer;
import br.com.barcadero.local.views.JFMain;


/**
 * Classe principal da aplicacao
 * @author Rafael Rocha
 * @since dia 05/08/2016 as 21:04
 */
public class Main {

	private static Session session;
	public static final String APP_NAME 	= "Nautilus";
	public static final String APP_VERSION	= "1.0 - DesckTop";
	
	public static void main(String[] args) {
			//----------------------------------------
			//Iniciando a persistencia da aplicacao
			//----------------------------------------
			//iniciarPersistencia();
			//----------------------------------------
			//Invocando Interface grafica
			//----------------------------------------
			invokMainInterface();
			//----------------------------------------
			//Iniciando Socket
			//----------------------------------------
			new Thread(()->{try {
				SocketServer.start();
			} catch (Exception e) {
				e.printStackTrace();
			}}).start();
		
	}

	public static Session getSession() {
		return session;
	}

	public static void setSession(Session session) {
		Main.session = session;
	}
	/**
	 * 
	 */
	private static void iniciarPersistencia() {
		System.out.println("--------------------------------------------");
		System.out.println("INICIANDO PERSISTENCIA LOCAL");
		System.out.println("--------------------------------------------");
		Main.session = HibernateHelper.getSession();
	}
	/**
	 * 
	 */
	private static void invokMainInterface() {
		System.out.println("--------------------------------------------");
		System.out.println("Invocando a Interface grafica ...");
		System.out.println("--------------------------------------------");
		JFMain jFMain = new JFMain();
		jFMain.setDefaultCloseOperation(JFMain.EXIT_ON_CLOSE);
		jFMain.setVisible(true);
	}
	
	public static void beginTransaction() {
		if(getSession() != null){
			getSession().beginTransaction();
		}
	}
	
	public static void commit() {
		if(getSession() != null){
			getSession().getTransaction().commit();
		}
	}
	public static void roolBack() {
		if(getSession() != null){
			getSession().getTransaction().rollback();
		}
	}

}
