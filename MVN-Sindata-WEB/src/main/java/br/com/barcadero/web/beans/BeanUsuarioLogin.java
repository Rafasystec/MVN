package br.com.barcadero.web.beans;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import org.apache.log4j.Logger;

import br.com.barcadero.rule.RuleUsuario;
import br.com.barcadero.tables.Usuario;

/**
 * Classe responsavel por controlar as acoes do usuario.
 * tambem acula as funcoes de login.
 * @author RafaelRocha
 * Classe criada dia 27/11/2013 as 22:12
 */
@ManagedBean(name="usuario")
public class BeanUsuarioLogin extends SuperBean<Usuario>{

	private static final long serialVersionUID = 6123392904973257391L;
	@ManagedProperty("#{ruleUsuario}")
	private RuleUsuario ruleUsuario;
	private boolean autorizado;
	@ManagedProperty(value="#{user}")
	private Usuario user;
	private String login;
	private String senha;
	private String ipAddress;
	private static Logger logger = Logger.getLogger(BeanUsuarioLogin.class);
	
	public boolean isAutorizado() {
		return autorizado;
	}
	public void setAutorizado(boolean autorizado) {
		this.autorizado = autorizado;
	}
			
	public List<Usuario> getUsuarios() throws Exception{
		try {
			return ruleUsuario.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * Autentica o usuario.
	 * @since versao 1.0 Gsind dia 26/11/2013 as 13:19 
	 * @author RafaelRocha
	 * @return o nome da pagina que sera redirecionada
	 */
	public String logar() {
		logger.info("Tentando acessar aplicacao pelo login: " + getLogin());
		String target 		= "index";
		Usuario usuario 	= null;
		try {	
			usuario = ruleUsuario.login(getLogin(), getSenha());
			if(usuario != null){
				autorizarLogin(usuario,getIpFromJSON(getIpAddress()));
				return "/private/PagEscolherEmpresa.xhtml?faces-redirect=true";
			}else{
				autorizado = false;
				target = null;
				FacesContext.getCurrentInstance().addMessage("form:msgLogin", new FacesMessage("Usuário ou Senha inválidos."));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,null,"Erro ao tentar logar: " + e.getMessage()));
			target = null;
		}
		return target;
	}
	
	/**
	 * Realiza a saida do operador.
	 * @return a tela que deverar ser acessada ao sair.
	 */
	public String logOut(){
		try {
			getSession().encerrarSessao();
			return "../public/PagLogin";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * Esse metodo verifica se o usuario realmente esta logado.
	 * @param event
	 */
	public void verificarUsuarioLogado(ComponentSystemEvent event) {
		//if(autorizado == false){
		if(getSession().getAttribute("autorizado") != null){
			boolean autoriz = Boolean.parseBoolean(getSession().getAttribute("autorizado").toString());
			if( autoriz == false){
				negarAcesso();
			}
		}else{
			negarAcesso();
		}
	}
	
	public void negarAcesso() {
		try {
			FacesContext.getCurrentInstance().addMessage("msgErro", new FacesMessage("Acesso negado! Senha ou usuário inválido."));
			FacesContext.getCurrentInstance().getExternalContext().redirect("PagLogin.xhtml?msg=Acesso+negado!");
		}catch(IOException ex){
			//Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, "",ex);
		}catch (Exception e) {
			// TODO: handle exception
			
		}
	}
	@Override
	public String alterar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String deletar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String novo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public Usuario getUser() {
		return SessionContext.getInstance().getUsuarioLogado();
	}
	public void setUser(Usuario usuario) {
		this.user = usuario;
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
	@Override
	public String salvar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public RuleUsuario getRuleUsuario() {
		return ruleUsuario;
	}
	public void setRuleUsuario(RuleUsuario ruleUsuario) {
		this.ruleUsuario = ruleUsuario;
	}
	@Override
	public boolean validar(Usuario entidade) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
}
