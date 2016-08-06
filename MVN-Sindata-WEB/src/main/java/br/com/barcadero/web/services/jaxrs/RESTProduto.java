package br.com.barcadero.web.services.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/produtos")
public class RESTProduto {
	@GET
	@Path("/{param}")
	public Response getProduto(@PathParam("param") String param) {
		String result = "RESTful example: " + param;
		return Response.status(200).entity(result).build();
	}
}
