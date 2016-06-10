package br.com.barcadero.commons.xml;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.StringReader;
import java.text.Normalizer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.stream.StreamSource;

public class HandleXML {
	
	public static String getXMLFromObject(Object objJAXB) throws Exception {
		return marshal(objJAXB);
	}
	
	/**
	 * Salva um objeto xml JAX-B em um arquivo .xml
	 * @param objJAXB
	 * @param dir
	 * @param fileName
	 * @throws Exception
	 */
	public static void toFile(Object objJAXB, String dir, String fileName) throws Exception {
		marshalToFile(objJAXB, dir + File.separator + fileName);
	}
	
	private static String marshal(Object objJAXB) throws Exception {	
		ByteArrayOutputStream result = new ByteArrayOutputStream(); 
		newMarshaller(objJAXB.getClass()).marshal(objJAXB, newWriter(result));	
		return result.toString();
	}
	
	private static void marshalToFile(Object objJAXB, String fullFileName) throws Exception {	
		newMarshaller(objJAXB.getClass()).marshal(objJAXB, new File(fullFileName));	
	}
	
	private static Marshaller newMarshaller(Class<?> classJAXB) throws Exception {
		return newContext(classJAXB).createMarshaller();
	}
	
	private static XMLStreamWriter newWriter(ByteArrayOutputStream result) throws Exception {
		XMLOutputFactory output = XMLOutputFactory.newInstance();		
		XMLStreamWriter writer = output.createXMLStreamWriter(result);
		return writer;
	}
	
	private static JAXBContext newContext(Class<?> classJAXB) throws Exception {
		return JAXBContext.newInstance(classJAXB);
	}
	
	/**
	 * 
	 * @param xml
	 * @param classJAXB
	 * @return
	 * @throws JAXBException
	 * @throws Exception
	 */
	public static Object unMarshal(String xml, Class<?> classJAXB) throws JAXBException, Exception {
		Unmarshaller unmarshaller 	= null;
		unmarshaller = newContext(classJAXB).createUnmarshaller();
		return (Object)unmarshaller.unmarshal(new StreamSource(new StringReader(xml)));
	}
	
	/**
	 * Obtem o objeto a patir de um arquivo
	 * @param fullFilePaht
	 * @param classJAXB
	 * @return null caso o arquivo xml nao exista
	 * @throws JAXBException
	 */
	public static Object unMarshalFromFile(String fullFilePaht, Class<?> classJAXB) throws JAXBException {
		JAXBContext jc 	= JAXBContext.newInstance( classJAXB );
	    Unmarshaller u 	= jc.createUnmarshaller();
	    File file		= new File( fullFilePaht );
	    if(file.exists()){
	    	 Object o = u.unmarshal( file );
	    	 return o;
	    }else{
	    	return null;
	    }
	}
	/**
	 * Obtem um XML a partir de um arquivo
	 * @param fullFilePaht
	 * @param classJAXB
	 * @return
	 * @throws Exception
	 */
	public static String getXMLFromAFile(String fullFilePaht, Class<?> classJAXB) throws Exception {
		Object xmlObj = unMarshalFromFile(fullFilePaht, classJAXB);
		if(xmlObj != null){
			String xml = getXMLFromObject(xmlObj);
			return xml;
		}else{
			return "";
		}
	}
	
	/**
	 * Normalizar XML
	 * @param xml
	 * @return
	 */
	public static String normalize(String xml) {		
		return Normalizer.normalize(xml, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").replaceAll("&amp;quot;", "&quot;").replaceAll("&amp;#39;", "&#39;");
	}
}
