package br.com.barcadero.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.barcadero.rule.RuleUsuario;
import br.com.barcadero.tables.Usuario;
/**
 * Para controlar a popup de usuario
 * @author Rafael Rocha
 * @since 1.0 dia 24/05/2016
 */
@ManagedBean(name="popUsuario")
@RequestScoped
public class BeanPopUsuario extends SuperBean {

	@ManagedProperty("#{ruleUsuario}")
	private RuleUsuario ruleUsuario;
	private static final long serialVersionUID = 736684237610838273L;
	
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
	
	public List<Usuario> getUsuarios() {
		try {
			return ruleUsuario.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Usuario>();
		}
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

}
