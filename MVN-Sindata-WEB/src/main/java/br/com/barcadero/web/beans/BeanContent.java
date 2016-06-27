package br.com.barcadero.web.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class BeanContent extends SuperBean{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5396916969995659750L;

	public String getLoja() {
		return getSession().getLojaLogada().getPessoaJuridica().getFantasia();
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

}
