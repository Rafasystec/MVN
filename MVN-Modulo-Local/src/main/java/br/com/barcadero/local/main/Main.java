package br.com.barcadero.local.main;

import br.com.barcadero.local.socket.SocketServer;
import br.com.barcadero.local.views.JFMain;


/**
 * Classe principal da aplicacao
 * @author Rafael Rocha
 * @since dia 05/08/2016 as 21:04
 */
public class Main {

	public static final String APP_NAME 	= "Módulo Local";
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
			System.out.println("Arquitetura JVM:"+System.getProperty("sun.arch.data.model") );
			//----------------------------------------
			//Iniciando Socket
			//----------------------------------------
			new Thread(()->{try {
				SocketServer.start();
			} catch (Exception e) {
				e.printStackTrace();
			}}).start();
		
	}


	
	/**
	 * 
	 */
	private static JFMain invokMainInterface() {
		System.out.println("--------------------------------------------");
		System.out.println("Invocando a Interface grafica ...");
		System.out.println("--------------------------------------------");
		JFMain jFMain = new JFMain();
		jFMain.setDefaultCloseOperation(JFMain.EXIT_ON_CLOSE);
		jFMain.setVisible(true);
		jFMain.setTextAreaAction("Invocando a Interface grafica ...");
		return jFMain;
	}
	
	

}
