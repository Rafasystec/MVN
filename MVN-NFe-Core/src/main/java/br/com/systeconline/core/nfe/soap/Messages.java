package br.com.systeconline.core.nfe.soap;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
//import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;

public class Messages {
	
	private final SOAPMessage message;
	private final SOAPHeader header;
	private final SOAPBody body;
	
	public Messages() throws SOAPException {
		// TODO Auto-generated constructor stub
		MessageFactory factory = MessageFactory.newInstance(getSoap12Protocol());
		message = factory.createMessage();
		header  = message.getSOAPHeader();
		body    = message.getSOAPBody();
		creatNameSpaceNFeHeader("1.3");
		createNameSpaceNFeBody("");
				
	}
	
	
	private void creatNameSpaceNFeHeader(String nfeVersionHeader) throws SOAPException {
//		QName xmlns 	= new QName("http://www.portalfiscal.inf.br/sce/wsdl/NfeRecepcao2", "nfeCabecMsg");
//		QName version	= new QName("versaoDados");
//		SOAPHeaderElement element = header.addHeaderElement(xmlns);
		message.saveChanges();
		System.out.println(header.getNamespaceURI());
		//SOAPElement elementVesion = header.addChildElement(version);
		//elementVesion.addTextNode(nfeVersionHeader);
		
	}
	
	private void createNameSpaceNFeBody(String xmlForSend) throws SOAPException {
		QName xmlns = new QName("http://www.portalfiscal.inf.br/sce/wsdl/NfeRecepcao2", "nfeRecepcao");
		SOAPBodyElement bodyElement = body.addBodyElement(xmlns);
		QName nfeDadosMsg = new QName("nfeDadosMsg");
		SOAPElement nfeElement = bodyElement.addChildElement(nfeDadosMsg);
		nfeElement.addTextNode(xmlForSend);
		
		
	}
	
	public SOAPMessage getMessage() {
		return this.message;
	}
	
	String getSoap11And12Protocol(){
		return SOAPConstants.DYNAMIC_SOAP_PROTOCOL;
	}
	
	String getSoap12Protocol(){
		return SOAPConstants.SOAP_1_2_PROTOCOL;
	}
	
//	private void deleteHeader(SOAPHeader header) {
//		header.detachNode();
//	}
//	
//	private void createNameSpaceExemple() throws SOAPException {
//		SOAPBody body = message.getSOAPBody();
//		QName bodyName = new QName("http://wombat.ztrade.com", "GetLastTradePrice", "m");
//		SOAPBodyElement bodyElement = body.addBodyElement(bodyName);
//	}

}
