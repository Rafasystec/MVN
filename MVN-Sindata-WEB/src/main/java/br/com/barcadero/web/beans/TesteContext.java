package br.com.barcadero.web.beans;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class TesteContext {
	FacesContext context = FacesContext.getCurrentInstance();
	public void teste() {
		ExternalContext co = context.getExternalContext();
		co.getRequest();
	}
}
