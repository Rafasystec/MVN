package br.com.barcadero.web.functions;

import javax.faces.context.FacesContext;

import br.com.barcadero.web.attributes.Attributs;
import br.com.barcadero.web.beans.SessionContext;

public class HandleHttpSession {

	public static void initSession(){
		FacesContext context = FacesContext.getCurrentInstance();
		sessionCx = (SessionContext) context.getExternalContext().getSession(true);
	}
	private static SessionContext sessionCx;
	
	public static void setRealIp(String ip) {
		sessionCx.setAttribute(Attributs.IP_ADDRESS, ip);	
	}
	
	public static String getRealIp() {
		return (String) sessionCx.getAttribute(Attributs.IP_ADDRESS);
	}
}
