package br.com.barcadero.web.beans.complets;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.barcadero.rule.RuleProduto;
import br.com.barcadero.web.beans.SuperBean;

@ManagedBean
@RequestScoped
public class BeanCompletProduto extends SuperBean {

	private RuleProduto ruleProduto;
	public BeanCompletProduto() {
		ruleProduto = new RuleProduto(getEmpresaLogada(), getLojaLogada(), getDataBaseSession());
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
	
	/**
	 * Retornar a descricao dos produtos em banco de dados
	 * @param query
	 * @return
	 */
	public List<String> completeText(String query)  {
		try {
			return ruleProduto.getAutoComplete(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<String>();
		}
		
	}

}