package br.com.systeconline.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.ServletRequest;

/**
 * Super classe para os Managed Beans da aplicação.
 * @author Rafael Rocha
 * @since Versão 1.0 Beta
 * Atenção: Só quem pode utilizar o printStackTrace das exceções são os Managed Beans
 * favor não colocar nas outras classes para evitar a poluição do log.
 */
@Deprecated
public class BeanSuperClass {
	private FacesContext context 	= null;
	private ServletRequest request	= null;
	private EntityManager manager	= null;
	private int codEmp				= 0;
	
	public BeanSuperClass() {
		context = FacesContext.getCurrentInstance();
		ExternalContext co = context.getExternalContext();
		request = (ServletRequest)co.getRequest();
		manager = (EntityManager)request.getAttribute("manager");
	}
	
	public int getCodEmpLogado() {
		if(this.request.getAttribute("codEmp") != null){
			return Integer.parseInt(this.request.getAttribute("codEmp").toString());
		}
		return this.codEmp;
	}

	public void setCodEmp(int codEmp) {
		this.codEmp = codEmp;
	}

	public EntityManager getManager(){
		return this.manager;
	}
	
	public void exibirMensagem(String mensagem) {
		try {
			FacesContext.getCurrentInstance().addMessage("msgForm", new FacesMessage(mensagem));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * Leva os erros da aplicacao para a pagina padrao de erro do sistema.
	 * @return Pagina padrao de erro.
	 * @since versao 1.0 Beta.
	 */
	public String chamaPagErro(Exception e) {
		try {
			FacesContext.getCurrentInstance().addMessage("msgErro", new FacesMessage("Excecao do Sistema: " + e.getMessage()));
			return "PagErro";
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return chamaPagErro(ex);
		}
	}
}
