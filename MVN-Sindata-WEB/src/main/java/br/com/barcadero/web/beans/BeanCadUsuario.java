package br.com.barcadero.web.beans;

import javax.faces.bean.ManagedBean;

import br.com.barcadero.rule.FacadeUsuario;
import br.com.barcadero.rule.RuleEmpresa;
import br.com.barcadero.tables.Usuario;


@ManagedBean(name="cadUsuario")
public class BeanCadUsuario extends SuperBean {

	private static final long serialVersionUID = 746108176250467310L;
	private Usuario usuario 		= null;
	private String confirm  		= "";
	private FacadeUsuario fcdUser 	= null;
	private RuleEmpresa ruleEmpresa;
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public BeanCadUsuario() {
		// TODO Auto-generated constructor stub
		usuario 	= new Usuario(null);
		fcdUser 	= new FacadeUsuario(getEmpresaLogada(),getLojaLogada(),getDataBaseSession());
		ruleEmpresa = new RuleEmpresa(getEmpresaLogada(),getLojaLogada(),getDataBaseSession());
	}
	@Override
	public String salvar() throws Exception {
		// TODO Auto-generated method stub
		fcdUser.salvar(usuario);
		ruleEmpresa.inserirEmpresaPadrao(usuario);
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
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
