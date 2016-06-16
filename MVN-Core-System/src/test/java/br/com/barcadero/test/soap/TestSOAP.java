package br.com.barcadero.test.soap;

import javax.xml.soap.SOAPMessage;

import br.com.barcadero.core.exeptions.SOAPException;
import br.com.barcadero.core.webservice.SOAPDados;
import br.com.barcadero.core.webservice.soap.SOAPFactory;

public class TestSOAP {
	
	
	public static void main(String[] args) {
		testeMessage();
	}
	
	public static void testeMessage() {
		try {
			SOAPMessage message = SOAPFactory.getMessageXMLNFe(new SOAPDados(),"xml", "3.10");
			System.out.println(SOAPFactory.getString(message));
			System.out.println(SOAPFactory.getStringByTransformation(message));
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
