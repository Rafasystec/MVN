package br.com.barcadero.core.webservice.soap;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.security.Security;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import br.com.barcadero.core.exeptions.SOAPException;
import br.com.barcadero.core.webservice.SOAPDados;

public class SOAPFactory {
	
	private SOAPConnectionFactory factory = null;
	private SOAPConnection connection	 = null;
	/**
	 * 
	 * @throws SOAPException
	 */
	private SOAPFactory() throws SOAPException{
		try {
			initializeSSL();
			factory 	= SOAPConnectionFactory.newInstance();
			connection 	= factory.createConnection();
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new SOAPException(e);
		}
		
	}
	
	private void initializeSSL() {
		
		System.clearProperty("java.protocol.handler.pkgs");  
		System.clearProperty("javax.net.ssl.keyStoreType");  
		System.clearProperty("javax.net.ssl.keyStore");  
		System.clearProperty("javax.net.ssl.keyStorePassword");  
		System.clearProperty("javax.net.ssl.trustStore");  
		System.clearProperty("javax.net.ssl.trustStoreType");  
		  
		System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");  
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());  
		System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");  
		System.setProperty("javax.net.ssl.keyStore", "/media/DataWhereHouse/Projetos/Sindacta/Core-System/src/resource/07221070v2016.pfx");  
		System.setProperty("javax.net.ssl.keyStorePassword", "_cert@gbo");  
		System.setProperty("javax.net.ssl.trustStoreType", "JKS");  
		System.setProperty("javax.net.ssl.trustStore", "/media/DataWhereHouse/Projetos/Sindacta/Core-System/NFeCacerts");  
		 
	}
	
	/**
	 * 
	 * @param messageToSend
	 * @param urlEndPoint
	 * @return
	 * @throws SOAPException
	 * @throws javax.xml.soap.SOAPException
	 */
	public static SOAPMessage enviar(SOAPMessage messageToSend, URL urlEndPoint) throws SOAPException, javax.xml.soap.SOAPException {
		SOAPConnection conn = null;
		try {
			conn = SOAPFactory.newInstance().getConnection();
			return conn.call(messageToSend, urlEndPoint);
		} catch (Exception e) {
			// TODO: handle exception
			throw new SOAPException(e);
		}finally{
			if(conn != null){conn.close();}
		}
	}
	
	/**
	 * 
	 * @return
	 * @throws SOAPException
	 */
	private static SOAPMessage createMessage() throws SOAPException{
		MessageFactory fac = null;
		try {
			fac = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
			return fac.createMessage();
		} catch (Exception e) {
			// TODO: handle exception
			throw new SOAPException(e);
		}
	}
	
	/**
	 * 
	 * @param dados
	 * @param messageToSend
	 * @param version
	 * @return
	 * @throws SOAPException
	 */
	public static SOAPMessage getMessageXMLNFe(SOAPDados dados, String messageToSend, String version) throws SOAPException{
		try {
			SOAPMessage message = createMessage();
			if(message != null){
				SOAPPart soapPart 		= message.getSOAPPart();
				SOAPEnvelope envelop	= soapPart.getEnvelope();
				envelop.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
				envelop.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema-instance");
				//----------------------------------------------------------------
				//Motando o Header da Mensagem
				//----------------------------------------------------------------
				SOAPHeader header 				= message.getSOAPHeader();
				SOAPHeaderElement headerElement = header.addHeaderElement(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/" + dados.getServiceName(), "nfeCabecMsg",""));
				SOAPElement versaoDados 		= headerElement.addChildElement("versaoDados");
				versaoDados.addTextNode(version);
				SOAPElement uf 					= headerElement.addChildElement("cUF");
				uf.addTextNode(dados.getcUF());
				//------------------------------------------------
				//Motando o body
				//------------------------------------------------
				SOAPBody body = message.getSOAPBody();
				SOAPBodyElement bodyElement = body.addBodyElement(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/" + dados.getServiceName(), "nfeDadosMsg", ""));
				//bodyElement.addTextNode("<![CDATA[" + messageToSend.replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", "") + "]]>");
				bodyElement.addTextNode("<![CDATA[" + messageToSend + "]]>");
				message.saveChanges();
				return message;
			}else{
				throw new SOAPException("SOAPMessage esta nulo.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new SOAPException(e);
		}
	}
	
		
	/**
	 * 
	 * @return
	 * @throws SOAPException
	 */
	public static SOAPFactory newInstance() throws SOAPException{
		try {
			return new SOAPFactory();
		} catch (Exception e) {
			// TODO: handle exception
			throw new SOAPException(e);
		}
	}
	
	/**
	 * 
	 * @param message
	 * @return
	 * @throws SOAPException
	 */
	public synchronized static String getString(SOAPMessage message) throws SOAPException{
		try {
			ByteArrayOutputStream outPut = new ByteArrayOutputStream();
			message.writeTo(outPut);
			return new String(outPut.toByteArray());
		} catch (Exception e) {
			// TODO: handle exception
			throw new SOAPException(e);
		}
	}
	
	/**
	 * 
	 * @param message
	 * @return
	 * @throws SOAPException
	 */
	public static String getStringByTransformation(SOAPMessage message) throws SOAPException{
		final StringWriter sw = new StringWriter();
		try {
			TransformerFactory.newInstance()
					.newTransformer()
					.transform(new DOMSource(message.getSOAPPart()), new StreamResult(sw));
			return sw.toString();
		} catch (Exception e) {
			// TODO: handle exception
			throw new SOAPException(e);
		}
	}

	public SOAPConnectionFactory getFactory() {
		return factory;
	}

	public void setFactory(SOAPConnectionFactory factory) {
		this.factory = factory;
	}

	public SOAPConnection getConnection() {
		return connection;
	}

	public void setConnection(SOAPConnection connection) {
		this.connection = connection;
	}
	
	public static Document convertStringToDocument(String xmlStr) {
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder;
	    try {
	        builder = factory.newDocumentBuilder();
	        Document doc = builder.parse(new InputSource(new StringReader(xmlStr)));
	        return doc;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
}
