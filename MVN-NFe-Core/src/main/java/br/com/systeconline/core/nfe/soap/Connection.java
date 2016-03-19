package br.com.systeconline.core.nfe.soap;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;

public class Connection {
	private final SOAPConnection soapConnection;
	
	public Connection() throws UnsupportedOperationException, SOAPException {
		// TODO Auto-generated constructor stub
		SOAPConnectionFactory factory = SOAPConnectionFactory.newInstance();
		soapConnection = factory.createConnection();
	}

	public SOAPConnection getSoapConnection() {
		return soapConnection;
	}
}
