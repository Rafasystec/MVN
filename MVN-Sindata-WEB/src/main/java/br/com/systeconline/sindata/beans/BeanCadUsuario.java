package br.com.systeconline.sindata.beans;

import javax.faces.bean.ManagedBean;

import br.com.systeconline.rule.FacadeUsuario;
import br.com.systeconline.tables.basicos.Usuario;

@ManagedBean(name="cadUsuario")
public class BeanCadUsuario extends SuperBean {

	private Usuario usuario 		= null;
	private String confirm  		= "";
	private FacadeUsuario fcdUser 	= null;
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
		usuario = new Usuario(null);
		fcdUser = new FacadeUsuario(getDataBaseSession());
	}
	@Override
	public String salvar() throws Exception {
		// TODO Auto-generated method stub
		fcdUser.salvar(usuario);
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
