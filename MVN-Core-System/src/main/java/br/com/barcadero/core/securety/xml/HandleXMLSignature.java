package br.com.barcadero.core.securety.xml;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Collections;
import java.util.Iterator;

import javax.xml.crypto.AlgorithmMethod;
import javax.xml.crypto.KeySelector;
import javax.xml.crypto.KeySelectorException;
import javax.xml.crypto.KeySelectorResult;
import javax.xml.crypto.XMLCryptoContext;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.dom.DOMValidateContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.omg.CORBA.StringHolder;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import br.com.barcadero.core.exeptions.XMLException;

public class HandleXMLSignature {
	
	public DOMValidateContext createValidationContext(KeySelector key, Node node) throws Exception{
		try {
			DOMValidateContext context = new DOMValidateContext(key, node);
			return context;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	public XMLSignature unmarsXMLSignature(DOMValidateContext contex)throws XMLException{
		try {
			XMLSignatureFactory factory = XMLSignatureFactory.getInstance("DOM");
			XMLSignature signature = factory.unmarshalXMLSignature(contex);
			return signature;
		} catch (Exception e) {
			// TODO: handle exception
			throw new XMLException(e.getMessage());
		}
	}
	
	public boolean validateXMLSignature(DOMValidateContext context) throws XMLException, XMLSignatureException{
		XMLSignature signature = null;
		try {
			signature = unmarsXMLSignature(context);
			return signature.validate(context);
		} catch (Exception e) {
			// TODO: handle exceptions
			Iterator<?> i = signature.getSignedInfo().getReferences().iterator();
			for (int j=0; i.hasNext(); j++) {
			  boolean refValid = ((Reference) 
			    i.next()).validate(context);
			  System.out.println("ref["+j+"] validity status: " + 
			    refValid);
			}
			throw new XMLException(e.getMessage());
		}
	}
	
	public void validateSignature(String fileName) throws XMLException{
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(Boolean.TRUE);
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new FileInputStream(fileName));
			NodeList list = doc.getElementsByTagNameNS(XMLSignature.XMLNS, "Signature");
			if(list.getLength() == 0){
				throw new XMLException("Tag Signature nao foi encontrada no documento DOM.");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void sing(String xml) {
		try {
			/*
			 Instantiating the Document to be Signed
			 First, we use a JAXP DocumentBuilderFactory to parse the XML document that 
			 we want to sign. An application obtains the default implementation for 
			 DocumentBuilderFactory by calling the following line of code:
			 */
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			//We must also make the factory namespace-aware:
			factory.setNamespaceAware(Boolean.TRUE);
			//Next, we use the factory to get an instance of a DocumentBuilder, which is used to parse the document:
			DocumentBuilder builder = factory.newDocumentBuilder();  
			Document doc = builder.parse(new String(xml)); 
			/*
			 Creating a Public Key Pair
			We generate a public key pair. Later in the example, we will use the private key to 
			generate the signature. We create the key pair with a KeyPairGenerator. In this example, 
			we will create a DSA KeyPair with a length of 512 bytes :
			 */
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA");
			kpg.initialize(512);
			KeyPair kp = kpg.generateKeyPair(); 
			//In practice, the private key is usually previously generated and stored in a KeyStore file with an associated public key certificate.
			/*
			 Creating a Signing Context
			We create an XML Digital Signature XMLSignContext containing input parameters for generating 
			the signature. Since we are using DOM, we instantiate a DOMSignContext (a subclass of XMLSignContext), 
			and pass it two parameters, the private key that will be used to sign the document and the root of the 
			document to be signed:
			 */
			DOMSignContext dsc = new DOMSignContext
			(kp.getPrivate(), doc.getDocumentElement()); 
			/*
			 Assembling the XML Signature
			We assemble the different parts of the Signature element into an XMLSignature object. These objects are all 
			created and assembled using an XMLSignatureFactory object. An application obtains a DOM implementation of 
			XMLSignatureFactory by calling the following line of code:
			 */
			XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");
			/*
			 We then invoke various factory methods to create the different parts of the XMLSignature object as shown below. We create a Reference object, passing to it the following:

The URI of the object to be signed (We specify a URI of "", which implies the root of the document.)
The DigestMethod (we use SHA1)
A single Transform, the enveloped Transform, which is required for enveloped signatures so that the signature itself is removed before calculating the signature value
			 */
			Reference ref = fac.newReference
					  ("", fac.newDigestMethod(DigestMethod.SHA1, null),
					    Collections.singletonList
					      (fac.newTransform(Transform.ENVELOPED,
					        (TransformParameterSpec) null)), null, null); 
			
			/*
			 Next, we create the SignedInfo object, which is the object that is actually signed, as shown below. When creating the SignedInfo, we pass as parameters:

The CanonicalizationMethod (we use inclusive and preserve comments)
The SignatureMethod (we use DSA)
A list of References (in this case, only one)
			 */
			SignedInfo si = fac.newSignedInfo
					  (fac.newCanonicalizationMethod
					    (CanonicalizationMethod.INCLUSIVE_WITH_COMMENTS,
					      (C14NMethodParameterSpec) null),
					    fac.newSignatureMethod(SignatureMethod.DSA_SHA1, null),
					    Collections.singletonList(ref)); 
		/*
		Next, we create the optional KeyInfo object, which contains information that enables the recipient to find the key needed to validate the signature. In this example, we add a KeyValue object containing the public key. To create KeyInfo and its various subtypes, we use a KeyInfoFactory object, which can be obtained by invoking the getKeyInfoFactory method of the XMLSignatureFactory, as follows:
		 */
			KeyInfoFactory kif = fac.getKeyInfoFactory();
		//We then use the KeyInfoFactory to create the KeyValue object and add it to a KeyInfo object:
			KeyValue kv = kif.newKeyValue(kp.getPublic());
			KeyInfo ki = kif.newKeyInfo(Collections.singletonList(kv));
		//Finally, we create the XMLSignature object, passing as parameters the SignedInfo and KeyInfo objects that we created earlier:
			XMLSignature signature = fac.newXMLSignature(si, ki); 
			
			/*
			 Notice that we haven't actually generated the signature yet; we'll do that in the next step.

Generating the XML Signature
Now we are ready to generate the signature, which we do by invoking the sign method on the XMLSignature object, and pass it the signing context as follows:


			 */
			signature.sign(dsc); 
			//The resulting document now contains a signature, which has been inserted as the last child element of the root element.
		/*
		 Printing or Displaying the Resulting Document
You can use the following code to print the resulting signed document to a file or standard output:
		 */
			OutputStream os;
//			if (args.length > 1) {
//			  os = new FileOutputStream(args[1]);
//			} else {
			  os = System.out;
//			} 
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer trans = tf.newTransformer();
			trans.transform(new DOMSource(doc), new StreamResult(os));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
