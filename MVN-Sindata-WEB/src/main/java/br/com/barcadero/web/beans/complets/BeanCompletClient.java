package br.com.barcadero.web.beans.complets;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.barcadero.rule.RuleCliente;
import br.com.barcadero.rule.RuleVendedor;
import br.com.barcadero.web.beans.SuperBean;

@ManagedBean
@RequestScoped
public class BeanCompletClient extends SuperBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9085742702494040494L;
	private RuleCliente ruleCliente;
	
	public BeanCompletClient() {
		ruleCliente = new RuleCliente(getEmpresaLogada(), getLojaLogada(), getDataBaseSession());
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
	
	public List<String> completeText(String query)  {
		try {
			return ruleCliente.getAutoComplet(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<String>();
		}
		
	}

}
