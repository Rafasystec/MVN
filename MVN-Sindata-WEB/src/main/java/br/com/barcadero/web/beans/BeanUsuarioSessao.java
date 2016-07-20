package br.com.barcadero.web.beans;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.barcadero.rule.RuleUsuario;

/**
 * Controla todas as acoes do usuario e guarda as informacoes do mesmo
 * ao longo da sessao. Ele tambem sera o resposavel por manter a sessao com o usuario.
 * Esta classe devera ter um EventListener para verificar se o usuario esta autenticado, ele
 * sera incluido em todas as paginas de acessorestrito atraves da tag <f:event>
 * @author rafael
 * Classe criada dia 15/11/2013 as 19:20
 */
@ManagedBean
@SessionScoped
public class BeanUsuarioSessao {
	 
	private long codigo;
	private long codGrupo;
	private long codPermissoes;
	private String login;
	private String senha;
	private Date dtCadastro;
	private RuleUsuario facadeUsuario;
	private HttpSession session;
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public long getCodGrupo() {
		return codGrupo;
	}
	public void setCodGrupo(long codGrupo) {
		this.codGrupo = codGrupo;
	}
	public long getCodPermissoes() {
		return codPermissoes;
	}
	public void setCodPermissoes(long codPermissoes) {
		this.codPermissoes = codPermissoes;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Date getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	
	public BeanUsuarioSessao(){
		try{
			pegarManager();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void pegarManager() throws Exception{
		try {
			//session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
			//facadeUsuario = new FacadeUsuario((EntityManager)request.getAttribute("manager"));
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
}
