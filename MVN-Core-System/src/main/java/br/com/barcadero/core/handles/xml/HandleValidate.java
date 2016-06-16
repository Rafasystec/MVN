package br.com.barcadero.core.handles.xml;

import java.io.StringReader;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.ValidationEventCollector;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.helpers.DefaultHandler;

public class HandleValidate {
	
	/**
	 * Validar xml junto ao schema
	 * @param location
	 * @param xml
	 * @throws Exception
	 */
	public void validate(String location, XMLObject xml, JAXBContext context) throws Exception{
		SchemaFactory factory = null;
		Schema schema 		  = null;
		HandleXML handle	  = null;
		try {
			factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			//schema	= factory.newSchema(new URL(location));
			schema	= factory.newSchema(getClass().getResource(location));
			handle  = new HandleXML();
			Marshaller mar = handle.getMarshaller(context);
			mar.setSchema(schema);
			mar.marshal(xml, new DefaultHandler());
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	public void validate(String location, String schemaName, XMLObject xml,JAXBContext context) throws Exception{
		SchemaFactory factory = null;
		Schema schema 		  = null;
		HandleXML handle	  = null;
		Unmarshaller unmar	  = null;
		ValidationEventCollector vec = null;
		try {
			vec = new ValidationEventCollector();
			factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			URL url = getClass().getResource(location + schemaName);
			schema	= factory.newSchema(url);
			handle  = new HandleXML();
			unmar	= handle.getUnmarshaller(xml);
			unmar.setSchema(schema);
			StringReader reader = new StringReader(xml.toString());
			unmar.setEventHandler(vec);
			unmar.unmarshal(reader);
		} catch (javax.xml.bind.UnmarshalException ex) {

	        if (vec != null && vec.hasEvents()) {
	            //erreurs = new ArrayList<MessageErreur>();
//	            for (ValidationEvent ve : vec.getEvents()) {
//	                MessageErreur erreur = new MessageErreur();
//	                String msg = ve.getMessage();
//	                ValidationEventLocator vel = ve.getLocator();
//	                int numLigne = vel.getLineNumber();
//	                int numColonne = vel.getColumnNumber();
//	                erreur.setMessage(msg);
//	                msgErreur.setCode(ve.getSeverity())
//	                erreur.setException(ve.getLinkedException());
//	                erreur.setPosition(numLigne, numColonne);
//	                erreurs.add(erreur);
//
//	                logger.debug("Erreur de validation xml" + "erreur : " + numLigne + "." + numColonne + ": " + msg);
//	            }
	        }

	    }

	}

}
