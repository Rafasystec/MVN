package br.com.barcadero.web.beans;

import java.io.Serializable;
import java.net.UnknownHostException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Usuario;
import br.com.barcadero.web.attributes.Attributs;
import br.com.barcadero.web.functions.HandleFaceContext;

public abstract class SuperBean<T extends Entidade>  implements Serializable, IBeanClass<T>{
	
	private static final long serialVersionUID = -7940750516142819573L;
	
	abstract public String salvar()throws Exception;
	abstract public String alterar()throws Exception;
	abstract public String deletar()throws Exception;
	abstract public String novo()throws Exception;
	
	public String validar() {
		return "";
	}
	
	private SessionContext session;
	@SuppressWarnings("unused")
	private HttpSession httpSession;
	public SuperBean() {
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
	
	protected Loja getLojaLogada() {
		return getSession().getLojaLogada();
	}
	
	protected Usuario getUsuarioLogado() {
		return getSession().getUsuarioLogado();
	}
	
	protected Empresa getEmpresaLogada() {
		return getSession().getEmpresaLogada();
	}
	
	protected void mensagemInfor(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
	}
	
	protected void autorizarLogin(Usuario usuario) {
		getSession().setAttribute("autorizado", true);
		getSession().setAttribute(Attributs.USER_NOME,   usuario.getNome());
		getSession().setAttribute(Attributs.USER_LOGIN,  usuario.getUsuario());
		getSession().setAttribute(Attributs.USER_CODIGO, usuario.getCodigo());
		getSession().setAttribute(Attributs.USER, usuario);
	}
	
	public String getIp() {
		try {
			return HandleFaceContext.getIpAddress();
		} catch (UnknownHostException e) {
			return "";
		}
	}
	
	
}
