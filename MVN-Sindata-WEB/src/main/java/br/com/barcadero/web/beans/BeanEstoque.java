package br.com.barcadero.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.SelectEvent;

import br.com.barcadero.rule.RuleProduto;

@ManagedBean
@RequestScoped
public class BeanEstoque extends SuperBean {

	private static final long serialVersionUID = 2638846429735720878L;
	private String paramProd;
	private RuleProduto ruleProduto;
	
	public BeanEstoque() {
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

	public String getParamProd() {
		return paramProd;
	}

	public void setParamProd(String paramProd) {
		this.paramProd = paramProd;
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
	
	public void onItemSelect(SelectEvent event) {
		String selected = event.getObject().toString();
		System.out.println( selected);
	}
}
