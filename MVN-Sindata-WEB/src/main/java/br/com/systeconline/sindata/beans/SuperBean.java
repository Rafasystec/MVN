package br.com.systeconline.sindata.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import br.com.systeconline.controller.SessionContext;
import br.com.systeconline.core.db.util.HibernateHelper;
import br.com.systeconline.web.attributes.Attributs;

public abstract class SuperBean  implements Serializable{
	
	private static final long serialVersionUID = -7940750516142819573L;
	
	abstract public String salvar()throws Exception;
	abstract public String alterar()throws Exception;
	abstract public String deletar()throws Exception;
	abstract public String novo()throws Exception;
	private SessionContext session;
	@SuppressWarnings("unused")
	private HttpSession httpSession;
	public SuperBean() {
		// TODO Auto-generated constructor stub
		this.session = SessionContext.getInstance();
	}
	
	public SessionContext getSession() {
		return session;
	}
	
	protected HttpServletRequest getCurrentRequest() {
		FacesContext context = FacesContext.getCurrentInstance();
		this.httpSession = (HttpSession)context.getExternalContext().getSession(true);
		return (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}
	
	protected Session getDataBaseSession() {
		HttpServletRequest request = getCurrentRequest();
		Object session = request.getAttribute(Attributs.ATT_SESSION_DB);
		if(session != null){
			this.session.setAttribute(Attributs.ATT_SESSION_DB, (Session)session);
			return (Session)session;
		}else{
			return null;
		}
	}
	
	public void failed() {
		SessionContext.failed();
	}
	
	protected void exibirErroGrave(Exception e) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,null,"Erro ao tentar logar: " + e.getMessage()));
	}
	
	protected void exibirErroGrave(String msgErro) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,null,msgErro));
	}
	
	protected void exibirMensagem(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,mensagem));
	}
	
	protected void exibirMsgAlerta(String msgAlert) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,null,msgAlert));
	}
	
	protected Session getDBSessionForViewScope() {
		return HibernateHelper.getSession();
	}
	
}