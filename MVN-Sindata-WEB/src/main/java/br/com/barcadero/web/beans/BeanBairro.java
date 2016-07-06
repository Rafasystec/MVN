package br.com.barcadero.web.beans;

import javax.faces.bean.ManagedBean;

import br.com.barcadero.rule.FacadeBairro;
import br.com.barcadero.tables.Bairro;

@ManagedBean
public class BeanBairro extends SuperBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5859355521669947983L;
	private Bairro bairro;
	private FacadeBairro fcdBairro;
	
	public BeanBairro() {
		// TODO Auto-generated constructor stub
		bairro 		= new Bairro(getUsuarioLogado());
		fcdBairro	= new FacadeBairro(getEmpresaLogada(), getLojaLogada(), getDataBaseSession());
	}
	
	@Override
	public String salvar() throws Exception {
		// TODO Auto-generated method stub
		String ret = fcdBairro.insert(bairro);
		System.out.println(ret);
		return null;
	}

	@Override
	public String alterar() throws Exception {
		String ret = fcdBairro.update(bairro);
		System.out.println(ret);
		return null;
	}

	@Override
	public String deletar() throws Exception {
		String ret = fcdBairro.delete(bairro.getCodigo());
		System.out.println(ret);
		return null;
	}

	@Override
	public String novo() throws Exception {
		// TODO Auto-generated method stub
		bairro = new Bairro(getUsuarioLogado());
		return null;
	}

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

}
