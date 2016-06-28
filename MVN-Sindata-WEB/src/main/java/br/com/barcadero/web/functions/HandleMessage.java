package br.com.barcadero.web.functions;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class HandleMessage {

	public static void info(String summary) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, summary+".", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public static void info(String summary, String detail) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, summary+":", detail+".");
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public static void error(String summary, String detail) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary+":", detail+".");
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	public static void warn(String summary, String detail) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, summary+":", detail+".");
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public static FacesMessage validatorError(String detail) {
		return new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de valida��o:", detail+".");
	}
	
	public static FacesMessage converterError(String detail) {
		return new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de convers�o:", detail+".");
	}
		
}
