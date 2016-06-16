package br.com.barcadero.web.beans;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Usuario;
import br.com.barcadero.web.attributes.Attributs;
import br.com.barcadero.web.functions.HandleFaceContext; 
public class SessionContext { 
	private static SessionContext instance; 
	public static SessionContext getInstance(){ 
		if (instance == null){ 
			instance = new SessionContext(); 
		} return instance; 
	} 
	
	private SessionContext(){ 
		
	} 
	private ExternalContext currentExternalContext(){ 
		if (FacesContext.getCurrentInstance() == null){ 
			throw new RuntimeException("O FacesContext não pode ser chamado fora de uma requisição HTTP"); 
		}else{ 
			return FacesContext.getCurrentInstance().getExternalContext(); 
		} 
	} 
	
	public Usuario getUsuarioLogado(){ 
		return (Usuario) getAttribute(Attributs.USER); 
	} 
	public void setUsuarioLogado(Usuario usuario){ 
		setAttribute(Attributs.USER, usuario); 
	} 
	public void encerrarSessao(){ 
		currentExternalContext().invalidateSession(); 
	} 
	public Object getAttribute(String nome){ 
		return currentExternalContext().getSessionMap().get(nome); 
	} 
	public void setAttribute(String nome, Object valor){ 
		currentExternalContext().getSessionMap().put(nome, valor); 
	} 
	
	/**
	 * Obtem a loja logada da sessao
	 * @return
	 */
	public Loja getLojaLogada() {
		Loja loja;
		if(getAttribute(Attributs.LOJA_LOGADA) != null){
			loja = (Loja)getAttribute(Attributs.LOJA_LOGADA);
		}else{
			loja = new Loja(null);
		}
		return loja;
	}
	
	/**
	 * Coloca um objeto Loja na sessao
	 * @param loja
	 */
	public void setLojaLogada(Loja loja) {
		setAttribute(Attributs.LOJA_LOGADA, loja);
	}
	
	public void redirectToLogin() throws IOException {
		redirect("/public/PagLogin.xhtml");
	}
	
	public static void failed() {
		FacesContext.getCurrentInstance().validationFailed();
	}
	
	private void redirect(String page) throws IOException {
		String contextPath = currentExternalContext().getRequestContextPath();
		System.out.println("Context path: " + contextPath); 
		currentExternalContext().redirect(contextPath + page);
	}
	
	public Empresa getEmpresaLogada() {
		return (Empresa) getAttribute(Attributs.EMP_LOGADA);
	}

	public void setEmpresa(Empresa empresa) {
		setAttribute(Attributs.EMP_LOGADA, empresa);
	}
	
	public void setTempCodEmp(long codEmp) {
		setAttribute(Attributs.TEMP_COD_EMP, codEmp);
	}
	
	public long getTempCodEmp() {
		if(getAttribute(Attributs.TEMP_COD_EMP) != null){
			return Long.parseLong(getAttribute(Attributs.TEMP_COD_EMP).toString());
		}else{
			return 0;
		}
	}
	
	public String getIpAddress() throws UnknownHostException {
//		if(getAttribute(Attributs.IP_ADDRESS) != null){
//			return getAttribute(Attributs.IP_ADDRESS).toString();
//		}else{
//			return "127.0.0.1";
//		}
		return HandleFaceContext.getIpAddress();
	}
	
	public void setIpAddress(String ipAddress) {
		setAttribute(Attributs.IP_ADDRESS, ipAddress);
	}
	
}

