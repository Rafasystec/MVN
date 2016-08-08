package br.com.barcadero.commons.services.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ClientRestEasy implements IClientRest {
	
	public static final String TARGET = "http://localhost/Nautilus";
	
	public String doClientRest(String requestedTarget) {
		Response response = null;
		WebTarget target  = null;
		Client client	  = null;
		String result	  = null;
		try {
			client 	= ClientBuilder.newClient();
			target 	= client.target(requestedTarget);
			response= target.request(MediaType.APPLICATION_XML).get();
			if(response.getStatus() != 200){
				throw new RuntimeException("Erro ao consumir: " + requestedTarget + " - Codigo: " + response.getStatus());
			}
			result 	= response.readEntity(String.class);
		} finally {
			if(response != null){response.close();}
			if(client != null){client.close();}
		}
		
		return result;
	}

}
