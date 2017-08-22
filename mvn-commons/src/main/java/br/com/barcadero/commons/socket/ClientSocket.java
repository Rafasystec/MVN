package br.com.barcadero.commons.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;


public class ClientSocket {
	
	private String ipServidor = "";
	
	public static final int PORT	= 9083; 
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		ClientSocket cliente = new ClientSocket();		
		cliente.setIpServidor ("10.1.1.81");
        
        SocketCommand cmd = new SocketCommand();
        cmd.setCommand("VetorComando");
        cliente.send(cmd);
		
		System.out.println("Resposta do servidor: " + cmd.getResponse());
	}

	/**
	 * Realiza uma chamda socket ao servidor desse ip
	 * @param value
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public void send(String value) throws UnknownHostException, IOException {
		PrintStream saida = null;
		Socket client	  = null;
		try{
			client 	= new Socket(getIpServidor(), SocketServer.SERVER_PORT);
			saida 	= new PrintStream(client.getOutputStream());
			saida.append(value);
		}finally{
			if(saida != null)saida.close();
			if(client != null)client.close();
		}
	}
	
	/**
	 * Envia objeto via socket
	 * @param comando
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public void send(SocketCommand comando) throws UnknownHostException, IOException {
		Socket client	  		= null;
		ObjectOutputStream	out = null;
		try{
			client	= new Socket(getIpServidor(), SocketServer.SERVER_PORT);
			out 	= new ObjectOutputStream(client.getOutputStream());
			out.writeObject(comando);
			System.out.println("Enviou comando");
		}finally{
			if(out != null){
				out.flush();
				out.reset();
				out.close();
			}
			if(client != null)client.close();
		}
	}
	/**
	 * Enviar resposta direto para o servidor
	 * @param comando
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public void sendForRemoteServer(SocketCommand comando) throws UnknownHostException, IOException {
		Socket client	  		= null;
		ObjectOutputStream	out = null;
		try{
			client	= new Socket(getIpServidor(), SocketServer.SERVER_PORT);
			out 	= new ObjectOutputStream(client.getOutputStream());
			out.writeObject(comando);
			System.out.println("Enviou comando");
		}finally{
			if(out != null){
				out.flush();
				out.reset();
				out.close();
			}
			if(client != null)client.close();
		}
	}
	
	/**
	 * 
	 * @param comando
	 * @return
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public SocketCommand sendAndReceive(SocketCommand comando) throws UnknownHostException, IOException {
		//PrintStream saida	 	= null;
		Socket client	  		= null;
		ObjectOutputStream	out = null;
		ServerSocket server		= null;
		try{
			client	= new Socket(getIpServidor(), SocketServer.SERVER_PORT);
			out 	= new ObjectOutputStream(client.getOutputStream());
			out.writeObject(comando);
			System.out.println("Enviou comando");
			server = new ServerSocket(SocketServer.SERVER_PORT);
			server.setSoTimeout(30000);
			Socket cliente = server.accept();
			SocketCommand comandoRet = SocketUtil.getObjectFromStream(cliente);
			return comandoRet;
		}finally{
			if(out != null){
				out.flush();
				out.reset();
				out.close();
			}
			if(client != null)client.close();
			if(server != null)server.close();
		}
	}
	
	/**
	 * Realiza uma chamada socket via protocolo SSL.
	 * @param comando
	 * @return
	 * @throws UnknownHostException
	 * @throws IOException
	 * @throws SSLConnectionException 
	 */
	public SocketCommand callAndReceiveSSL(SocketCommand comando) throws UnknownHostException, IOException, SSLConnectionException {
		SSLSocket client = null;
		try {
			client = getSocketConnection();
		} catch (SSLConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectOutputStream	out = null;
		SSLServerSocket sslServer = null;
		try {
			out 	= new ObjectOutputStream(client.getOutputStream());
			out.writeObject(comando);
			System.out.println("Enviou comando");
			//sslServer = SSLServer.createSSLServer(Integer.parseInt(comando.getIpHost()));
			sslServer = new SSLSocketServer().getServerSocket();
			sslServer.setSoTimeout(50000);
			SSLSocket cliente = (SSLSocket) sslServer.accept();
			SocketCommand comandoRet = SocketUtil.getObjectFromStream(cliente);
			return comandoRet;
		} finally {
			// TODO: handle finally clause
			if(sslServer != null)sslServer.close();
		}
	}
	
	/**
	 * Apenas envia a responta sem esperear nenhum retorno.
	 * @param comando
	 * @throws UnknownHostException
	 * @throws IOException
	 * @throws SSLConnectionException
	 */
	public void sendSSL(SocketCommand comando) throws UnknownHostException, IOException, SSLConnectionException {
		SSLSocket client = null;
		try {
			client = getSocketConnection();
		} catch (SSLConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectOutputStream	out = null;
		SSLServerSocket sslServer = null;
		try {
			out 	= new ObjectOutputStream(client.getOutputStream());
			out.writeObject(comando);
			System.out.println("Enviou comando");
		} finally {
			// TODO: handle finally clause
			if(sslServer != null)sslServer.close();
		}
	}

	public String getIpServidor() {
		return ipServidor;
	}

	public void setIpServidor(String ipServidor) {
		this.ipServidor = ipServidor;
	}
	
	
	private SSLSocket getSocketConnection() throws SSLConnectionException {
	    try {
	    	KeyStore ksKeys = KeyStore.getInstance("pkcs12");
	    	InputStream is = getClass().getClassLoader().getResourceAsStream("Certificado Otica Golden.pfx");
			ksKeys.load(is, SSLSocketServer.getPassword());
	        /* Get factory for the given keystore */
	        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
	        tmf.init(ksKeys);
	        SSLContext ctx = SSLContext.getInstance("SSL");
	        ctx.init(null, tmf.getTrustManagers(), null);
	        SSLSocketFactory factory = ctx.getSocketFactory();

	        return (SSLSocket) factory.createSocket(getIpServidor(), SocketServer.SERVER_PORT);
	    } catch (Exception e) {
	        throw new SSLConnectionException(
	                "Problem connecting with remote controller: "
	                        + e.getMessage());
	    }
	}
	
	/**
	 * 
	 * @param comando
	 * @return
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public SocketCommand callAndReceive(SocketCommand comando) throws UnknownHostException, IOException {
		//PrintStream saida	 	= null;
		Socket client	  		= null;
		ObjectOutputStream	out = null;
		ServerSocket server		= null;
		try{
			client	= new Socket(getIpServidor(), SocketServer.SERVER_PORT);
			out 	= new ObjectOutputStream(client.getOutputStream());
			//comando.setIpHost(client.getLocalSocketAddress().toString());
			out.writeObject(comando);
			System.out.println("Enviou comando");
			server = new ServerSocket(PORT);
			server.setSoTimeout(50000);
			Socket cliente = server.accept();
			SocketCommand comandoRet = SocketUtil.getObjectFromStream(cliente);
			return comandoRet;
		}finally{
			//if(saida != null)saida.close();
			//if(client != null)client.close();
			if(out != null){
				out.flush();
				out.reset();
				out.close();
			}
			if(client != null)client.close();
			if(server != null)server.close();
		}
	}

}
