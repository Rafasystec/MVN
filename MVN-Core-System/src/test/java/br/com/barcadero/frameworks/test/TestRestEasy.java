package br.com.barcadero.frameworks.test;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import br.com.barcadero.commons.services.rest.ClientRestEasy;
import br.com.barcadero.commons.xml.HandleXML;
import br.com.barcadero.core.xml.entities.XMLCliente;
import br.com.barcadero.core.xml.entities.XMLProduto;

public class TestRestEasy {

	
	
	@Test
	public void callProduto() {
		XMLProduto produto = new XMLProduto();
		ClientRestEasy clientRestEasy = new ClientRestEasy();
		String xml = clientRestEasy.doClientRest("http://localhost:8080/Nautilus/rest/produtos/12/get");
		try {
			produto = (XMLProduto) HandleXML.unMarshal(xml, XMLProduto.class);
			System.out.println("Codigo: " + produto.getCodigo());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void callClinte() {
		XMLCliente cliente = new XMLCliente();
		ClientRestEasy clientRestEasy = new ClientRestEasy();
		String xml = clientRestEasy.doClientRest("http://localhost:8080/Nautilus/rest/clientes/12/get");
		try {
			cliente = (XMLCliente) HandleXML.unMarshal(xml, XMLCliente.class);
			System.out.println("Codigo: " + cliente.getCodigo());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
