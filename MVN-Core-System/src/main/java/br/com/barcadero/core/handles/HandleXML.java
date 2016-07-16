package br.com.barcadero.core.handles;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.text.Normalizer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import br.com.barcadero.core.exeptions.XMLException;
import br.com.barcadero.core.util.XMLRetornoGeralNFe;

public class HandleXML {
	
	
	/**
	 * Salva o xml em arquivo mais não verifica e nem cria o diretorio. Metodo Unsafe.
	 * @param fullFileName
	 * @param xml
	 * @throws XMLException
	 */
	public void objectXMLToFile(String fullFileName, Object xml, JAXBContext context) throws XMLException{
		File file 				= null;
		Marshaller marshaller	= null;
		try {
			file 		= new File(fullFileName);
			marshaller	= getMarshaller(context);
			marshaller.marshal(xml, file);
		} catch (XMLException e) {
			throw e;
		} catch(Exception e){
			throw new XMLException(e.getMessage());
		}
	}
	
	public String getXMLObjectAsString(Object xml, JAXBContext context) throws XMLException{
		Marshaller marshaller		 = null;
		ByteArrayOutputStream outPut = new ByteArrayOutputStream();
		try {
			marshaller = getMarshaller(context);
			marshaller.marshal(xml, outPut);
			return new  String(outPut.toByteArray());
		} catch (Exception e) {
			// TODO: handle exception
			throw new XMLException(e.getMessage());
		}
	}
	
	public String getXMLObjectAsStringWriter(Object xml, JAXBContext context) throws XMLException{
		StringWriter writer = new StringWriter();
		Marshaller marshaller = null;
		try {
			marshaller = getMarshaller(context);
			marshaller.marshal(xml, writer);
			return normalizar(writer.toString());
		} catch (Exception e) {
			// TODO: handle exception
			throw new XMLException(e.getMessage());
		}
	}
	
	/**
	 * Criar um arquivo com o xml passado e verifica se o diretorio existe e o cria caso nao exista. Metodo Safe.
	 * @param fileName
	 * @param dirToSave
	 * @param xml
	 * @throws XMLException
	 */
	public void objectXMLToFile(String fileName, String dirToSave, Object xml, JAXBContext context) throws XMLException{
		File fileDir = new File(dirToSave);
		if(!fileDir.exists()){
			fileDir.mkdirs();
		}
		String fullFileName = dirToSave + File.separator + fileName;
		objectXMLToFile(fullFileName, xml, context);
	}
	
	/**
	 * Obtem um objeto xml a partir de um arquivo
	 * @param fullFileName
	 * @return
	 * @throws XMLException
	 */
	public XMLObject getXMLFromFile(String fullFileName,XMLObject obj) throws XMLException{
		File file 			= null;
		Unmarshaller unmars = null;
		try {
			file 		= new File(fullFileName);
			unmars		= getUnmarshaller(obj);
			return (XMLObject)unmars.unmarshal(file);
		} catch (Exception e) {
			throw new XMLException(e.getMessage());
		}
	}
	
	public XMLObject getXMLObject(FileInputStream stream, XMLObject obj) throws Exception{
		return (XMLObject) getUnmarshaller(obj).unmarshal(stream);
	}
	
	public XMLObject getXMLObject(String URL, XMLObject obj) throws Exception{
		URL url = new URL(URL);
		return (XMLObject) getUnmarshaller(obj).unmarshal(url);
	}
	
	public XMLObject getXMLObject(StringBuffer buffer, XMLObject obj) throws Exception{
		return (XMLObject) getUnmarshaller(obj).unmarshal(new StreamSource(new StringReader(buffer.toString())));
	}
	
	private JAXBContext getContext(XMLObject obj) throws Exception{
		return JAXBContext.newInstance(obj.getClass().getName());
	}

	protected Unmarshaller getUnmarshaller(XMLObject obj) throws Exception {
		return getContext(obj).createUnmarshaller();
	}
	
	protected Marshaller getMarshaller(JAXBContext context) throws Exception{
		Marshaller marshaller = context.createMarshaller();
		//marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		return marshaller;
	}
	
//	private Marshaller getMarshaller(boolean withIdentation) throws Exception{
//		Marshaller marshaller = getContext().createMarshaller();
//		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, withIdentation);
//		return marshaller;
//	}
	
	public static String normalizar(String xml) {
		return Normalizer.normalize(xml, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").replaceAll("&amp;quot;","&quot;").replaceAll("&amp;#39;", "&#39;"); 
	}
	
	public static Document getDocument(SOAPMessage message) throws Exception{
		Document document;
		try {
			document = message.getSOAPBody().extractContentAsDocument();
			return document;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	/**
	 * 
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public static XMLRetornoGeralNFe getRetornoGeral(SOAPMessage message) throws Exception {	
		SOAPFaultObject objFault 	= HandleSOAP.getFault(message);
		XMLRetornoGeralNFe retorno 	= new XMLRetornoGeralNFe();
		try{
			if(objFault != null){
				//Falha no envio da mensagem
				retorno.setFalt(objFault);
				retorno.setcStat(XMLRetornoGeralNFe.CODIGO_SOAP_FAULT);
				retorno.setMotivo("Falha na mensagem SOAP.");
			}else{
				Document doc 	= HandleXML.getDocument(message);
				NodeList list 	= doc.getElementsByTagName("cStat");
				retorno.setFalt(null);
				if(list.getLength() > 0){
					org.w3c.dom.Node node = list.item(0);
					//retorno.setcStat(Integer.parseInt(node.getTextContent()));
				}
				list = doc.getElementsByTagName("xMotivo");
				if(list.getLength() > 0){
					org.w3c.dom.Node node = list.item(0);
					//retorno.setMotivo(node.getTextContent());
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			retorno.setcStat(0);
			retorno.setFalt(null);
			retorno.setMotivo("Erro grave ao tentar obter o retorno geral: " + e.getMessage());
		}
		return retorno;
	}
}
