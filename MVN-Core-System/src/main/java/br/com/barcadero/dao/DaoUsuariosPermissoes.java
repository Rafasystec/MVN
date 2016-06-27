package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.tables.UsuarioPermissoes;

public class DaoUsuariosPermissoes extends DaoModelo <UsuarioPermissoes>{

	public DaoUsuariosPermissoes(Session session) {
		super(session);
	}

	@Override
	public List<UsuarioPermissoes> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioPermissoes find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
