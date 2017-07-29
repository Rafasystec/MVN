package br.com.barcadero.web.beans.complets;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.barcadero.rule.RuleCliente;

@ManagedBean
@RequestScoped
public class BeanCompletClient {//extends SuperBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9085742702494040494L;
	private RuleCliente ruleCliente;
	
		
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
