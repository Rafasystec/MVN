package br.com.systeconline.core.webservice.soap;

import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.soap.Detail;
import javax.xml.soap.DetailEntry;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;

public class HandleSOAP {
	
	/**
	 * 
	 * @param message
	 * @throws javax.xml.soap.SOAPException
	 */
	public static SOAPFaultObject getFault(SOAPMessage message) throws javax.xml.soap.SOAPException {
		SOAPBody body 			 = message.getSOAPBody();
		SOAPFaultObject objFault = null;;
		if(body.hasFault()){
			SOAPFault newFault = body.getFault();
		    objFault		   = new SOAPFaultObject();
			QName code = newFault.getFaultCodeAsQName();
		    String string = newFault.getFaultString();
		    String actor = newFault.getFaultActor();
		    System.out.println("SOAP fault contains: ");
		    System.out.println("  Fault code = " + code.toString());
		    objFault.setCode(code.toString());
		    System.out.println("  Local name = " + code.getLocalPart());
		    objFault.setLocalName(code.getLocalPart());
		    System.out.println("  Namespace prefix = " +
		        code.getPrefix() + ", bound to " + code.getNamespaceURI());
		    System.out.println("  Fault string = " + string);
		    objFault.setFullMessage(string);
		    if ( actor != null ) {
		        System.out.println("  Fault actor = " + actor);
		        objFault.setActor(actor);
		    }
		    Detail newDetail = newFault.getDetail();
		    if (newDetail != null) {
		        Iterator<?> entries = newDetail.getDetailEntries();
		        while ( entries.hasNext() ) {
		            DetailEntry newEntry = (DetailEntry)entries.next();
		            String value = newEntry.getValue();
		            System.out.println("  Detail entry = " + value);
		        }
		    }
		}
		return objFault;
	}


}
