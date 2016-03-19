package br.com.systeconline.core.handles.xml;

import java.io.File;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class HandleDOM {
	
	private DocumentBuilderFactory factory = null;
	private DocumentBuilder builder		   = null;
	
	public HandleDOM() throws ParserConfigurationException {
		factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();
	}
	
	public Document getDocumentDOM(String fileName, String directory) throws DOMException{
		Document document = null;
		File file		  = null;
		try {
			file = new File(directory + File.separator + fileName);
			if(!file.exists()){
				throw new DOMException((short)12, "Impossivel realizar o parse. Arquivo " + file.getAbsolutePath() + " nao existe");
			}
			document = builder.parse(file);
			return document;
		} catch (DOMException dom){
			throw dom;
		} catch (Exception e) {
			// TODO: handle exception
			throw new DOMException((short) 10, e.getMessage());
		}
	}

	public Document getDocumentDOM(InputSource is) throws DOMException{
		Document document = null;
		try {
			document = builder.parse(is);
			return document;
		} catch (DOMException dom){
			throw dom;
		} catch (Exception e) {
			// TODO: handle exception
			throw new DOMException((short) 10, e.getMessage());
		}
	}
	
	public Document getDocumentDOM(InputStream is) throws DOMException{
		Document document = null;
		try {
			document = builder.parse(is);
			return document;
		} catch (DOMException dom){
			throw dom;
		} catch (Exception e) {
			// TODO: handle exception
			throw new DOMException((short) 10, e.getMessage());
		}
	}
	
	public Document getDocumentDOM(String uri) throws DOMException{
		Document document = null;
		try {
			document = builder.parse(uri);
			return document;
		} catch (DOMException dom){
			throw dom;
		} catch (Exception e) {
			// TODO: handle exception
			throw new DOMException((short) 10, e.getMessage());
		}
	}
}
