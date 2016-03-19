package br.com.systeconline.core.nfe.soap;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public class SendAndReceive {
	
	private Connection connection;
	
	public SendAndReceive() throws UnsupportedOperationException, SOAPException {
		// TODO Auto-generated constructor stub
		connection = new Connection();
	}
	
	public SOAPMessage sendAndReceive(SOAPMessage message, String endPoint) {
		URL endPointURL 	 = null;
		SOAPMessage response = null;
		try {
			endPointURL = new URL(endPoint);
			response	= connection.getSoapConnection().call(message, endPointURL);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

}
