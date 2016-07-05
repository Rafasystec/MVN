package br.com.barcadero.commons.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class SocketUtil {
	
	/**
	 * Obter objeto do socket
	 * @param stream
	 * @return
	 */
	public synchronized static SocketCommand getObjectFromStream(InputStream stream, String ipHost) {
		Object temp;
		SocketCommand cmd = null;
		ObjectInputStream input;
		try {
			input = new ObjectInputStream(stream);
			temp  = input.readObject();
			if(temp instanceof SocketCommand){
				cmd = (SocketCommand)temp;
				cmd.setIpHost(ipHost);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cmd;
	}


	/**
	 * Obter objeto do socket
	 * @param stream
	 * @return
	 */
	public synchronized static SocketCommand getObjectFromStream(Socket client) {
		Object temp;
		SocketCommand cmd = null;
		ObjectInputStream input;
		
		try {
			
			input = new ObjectInputStream(client.getInputStream());
			temp  = input.readObject();
			if(temp instanceof SocketCommand){
				cmd = (SocketCommand)temp;
				String ipHost = client.getInetAddress().getHostAddress();
				cmd.setIpHost(ipHost);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cmd;
	}
	
	
	
}
