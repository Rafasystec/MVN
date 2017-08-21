package br.com.barcadero.web.beans.complets;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.barcadero.rule.RuleCliente;
import br.com.barcadero.tables.Cliente;
import br.com.barcadero.web.beans.SuperBean;

@ManagedBean
@RequestScoped
public class BeanCompletClient extends SuperBean<Cliente> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9085742702494040494L;
	@ManagedProperty("#{ruleCliente}")
	private RuleCliente ruleCliente;
	
		
	public List<String> completeText(String query)  {
		try {
			return ruleCliente.getAutoComplet(getEmpresaLogada(), query);
		} catch (Exception e) {
			return new ArrayList<String>();
		}
		
	}


	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean validar(Cliente entidade) throws Exception {
		// TODO Auto-generated method stub
		return false;
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


	public RuleCliente getRuleCliente() {
		return ruleCliente;
	}


	public void setRuleCliente(RuleCliente ruleCliente) {
		this.ruleCliente = ruleCliente;
	}

}
