package br.com.barcadero.web.beans;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import br.com.barcadero.rule.RuleSystemProperties;
import br.com.barcadero.tables.SystemProperties;
import br.com.barcadero.tables.Usuario;

@ManagedBean(name="index")
@SessionScoped
public class BeanIndex extends SuperBean{

	private static final long serialVersionUID = -8956924425290321691L;
	private String userName;
	private boolean isLogado;
	private Usuario user;
	private String versaoSystema;
	@ManagedProperty("#{ruleSystemProperties}")
	private RuleSystemProperties ruleSystemProperties;
	
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}


	public boolean isLogado() {
		return isLogado;
	}

	public void setLogado(boolean isLogado) {
		this.isLogado = isLogado;
	}

	public String getUserName() {
		
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String logOut() throws IOException {
		SessionContext.getInstance().encerrarSessao();
		SessionContext.getInstance().redirectToLogin();
		System.out.println("Sessao encerrada. Indo para o login.");
		return null;
	}


	public String getVersaoSystema() {
		return versaoSystema;
	}


	public void setVersaoSystema(String versaoSystema) {
		this.versaoSystema = versaoSystema;
	}
	
	private String getVersao() {
		SystemProperties properties = null;
		try {
			properties = ruleSystemProperties.find();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(properties != null){
			return properties.getVersaoSistema();
		}else{
			return "1.0 - Indefinido";
		}
	}


	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String salvar() throws Exception {
		// TODO Auto-generated method stub
		return null;
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

	public RuleSystemProperties getRuleSystemProperties() {
		return ruleSystemProperties;
	}

	public void setRuleSystemProperties(RuleSystemProperties ruleSystemProperties) {
		this.ruleSystemProperties = ruleSystemProperties;
	}

}
