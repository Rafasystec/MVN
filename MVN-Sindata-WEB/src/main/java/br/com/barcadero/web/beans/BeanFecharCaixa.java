package br.com.barcadero.web.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.barcadero.tables.CaixaFechamento;

@ManagedBean
@RequestScoped
public class BeanFecharCaixa extends SuperBean<CaixaFechamento> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 730567893970605416L;

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

	@Override
	public boolean validar(CaixaFechamento entidade) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
