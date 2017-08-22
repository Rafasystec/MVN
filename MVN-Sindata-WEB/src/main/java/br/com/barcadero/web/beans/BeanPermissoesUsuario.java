package br.com.barcadero.web.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.barcadero.tables.UsuarioPermissoes;

@ManagedBean
@ViewScoped
public class BeanPermissoesUsuario extends SuperBean<UsuarioPermissoes> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3338667789275938312L;
	private UsuarioPermissoes permissoes;
	
	@PostConstruct
	public void init() {
		System.out.println("CARREGANDO AS PERMISSÕES DE USUÁRIO");
		setPermissoes(getUsuarioLogado().getPermissoes());
	}
	
	
	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validar(UsuarioPermissoes entidade) throws Exception {
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


	public UsuarioPermissoes getPermissoes() {
		return permissoes;
	}


	public void setPermissoes(UsuarioPermissoes permissoes) {
		this.permissoes = permissoes;
	}

}
