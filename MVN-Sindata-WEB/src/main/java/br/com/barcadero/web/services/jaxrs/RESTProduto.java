package br.com.barcadero.web.services.jaxrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.barcadero.core.xml.entities.RSGenericResponse;
import br.com.barcadero.core.xml.entities.XMLProduto;
import br.com.barcadero.rule.RuleProduto;

@Path("/produtos")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class RESTProduto {
	
	private RuleProduto ruleProduto;
	
	public RESTProduto() {
		ruleProduto = new RuleProduto(null, null, null);
	}
	
	@GET
	@Path("/{param}")
	public Response getProduto(@PathParam("param") String param) {
		String result = "RESTful example: " + param;
		return Response.status(200).entity(result).build();
	}
	
	@POST
	@Path("/add")
	public Response addProduto(XMLProduto produto) {
		RSGenericResponse response = new RSGenericResponse();
		if(1 == 2){
			//Verificar se existe o recurso
			response.setStatus(false);
            response.setMessage("Employee Already Exists");
            response.setErrorCode("EC-01");
            return Response.status(422).entity(response).build();
		}
		//ruleProduto.insert(null); Realizar adicao
		response.setStatus(true);
        response.setMessage("Employee created successfully");
        return Response.ok(response).build();
	}
	
	@DELETE
    @Path("/{id}/delete")
    public Response deleteProduto(@PathParam("id") int id) {
        RSGenericResponse response = new RSGenericResponse();
        System.out.println("Deletando produto");
        if(1 > 1){
            response.setStatus(false);
            response.setMessage("Employee Doesn't Exists");
            response.setErrorCode("EC-02");
            return Response.status(404).entity(response).build();
        }
        //ruleProduto.delete(id); //Remover o recurso
        response.setStatus(true);
        response.setMessage("Produto deletado com sucesso!");
        return Response.ok(response).build();
    }
	
    @GET
    @Path("/{id}/get")
    public XMLProduto getProduto(@PathParam("id") int id) {
    	System.out.println("Getting product with id " + id);
        return new XMLProduto();
    }
    
    @GET
    @Path("/getAll")
    public XMLProduto[] getAllProdutos() {
    	 XMLProduto[] produtos = new  XMLProduto[3];
        return  produtos;
    }
}
