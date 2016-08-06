package br.com.barcadero.web.services.jaxrs;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class ProdutoApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	 
    public ProdutoApplication() {
        singletons.add(new RESTProduto());
    }
 
    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
