package br.com.systeconline.core.nfe.soap;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public class TesteSoap {
	
	public static void main(String[] args) {
		try {
			Messages message = new Messages();
			SOAPMessage sopamessage = message.getMessage();
			System.out.println(sopamessage.getSOAPHeader().toString()); 
			
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
