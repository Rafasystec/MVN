package br.com.barcadero.commons.socket;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManagerFactory;

public class SSLSocketServer {

	static SSLServerSocket server;
	
	private static char[] password = "goldenitalia".toCharArray() ;
	
	public static void main(String[] args) {
		try {
			start();
		}catch (KeyManagementException | NoSuchAlgorithmException e){ 
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Iniciar o servidor socket com SSL
	 * @throws IOException
	 * @throws KeyManagementException
	 * @throws NoSuchAlgorithmException
	 */
	public static void start() throws IOException, KeyManagementException, NoSuchAlgorithmException {
		System.out.println("Iniciando Service SSL Socket");
		try {
			server = new SSLSocketServer().getServerSocket();
		} catch (SSLConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean keepAlive = true;
		while (keepAlive) {
			//Preparando o socket para esperar por requisicoes
			SSLSocket client = (SSLSocket) server.accept();
			System.out.println("Nova conexão com " + client.getInetAddress().getHostAddress());
			ThreadSocket ts = new ThreadSocket(client);
			Thread t 		= new Thread(ts);
			t.start();
		}
	}

	/**
	 * 
	 * @param port
	 * @return
	 * @throws IOException
	 */
	public static SSLServerSocket createSSLServer(int port) throws IOException {
		SSLServerSocket server;
		SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
		server = (SSLServerSocket) factory.createServerSocket(port);
		return server;
	}
	

	/**
	 * 
	 * @return
	 * @throws SSLConnectionException
	 */
	public SSLServerSocket getServerSocket() throws SSLConnectionException {
	    try {
	    	KeyStore ksKeys = KeyStore.getInstance("pkcs12");
			InputStream is = getClass().getClassLoader().getResourceAsStream("Certificado Otica Golden.pfx");
			ksKeys.load(is, password);
	        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
	        KeyManagerFactory kmf   = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
	        kmf.init(ksKeys, getPassword());
	        tmf.init(ksKeys);
	        SSLContext ctx = SSLContext.getInstance("SSL");
	        ctx.init(kmf.getKeyManagers(), null, null);
	        SSLServerSocketFactory factory = ctx.getServerSocketFactory();
	        return (SSLServerSocket) factory.createServerSocket(SocketServer.SERVER_PORT);
	    } catch (Exception e) {
	        throw new SSLConnectionException("Problem starting auth server: "  + e.getMessage());
	    }
	}

	public static char[] getPassword() {
		return password;
	}

	public static void setPassword(char[] password) {
		SSLSocketServer.password = password;
	}
}
