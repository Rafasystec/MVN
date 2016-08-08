package br.com.barcadero.web.services.jaxrs;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

public class RESTApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	 
    public RESTApplication() {
        singletons.add(new RESTProduto());
        singletons.add(new RESTCliente());
    }
 
    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
