package br.com.barcadero.web.services.jaxrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.barcadero.core.xml.entities.XMLCliente;

@Path("/clientes")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class RESTCliente {
	
	public void name() {
		
	}
	
	@GET
	@Path("/{id}/get")
	public XMLCliente getProduto(@PathParam("id") int id) {
		System.out.println("Getting client with id " + id);
		return new XMLCliente();
	}

}
