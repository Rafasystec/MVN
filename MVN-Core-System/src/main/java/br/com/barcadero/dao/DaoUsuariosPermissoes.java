package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.UsuarioPermissoes;

public class DaoUsuariosPermissoes extends DaoModelo <UsuarioPermissoes>{

	public DaoUsuariosPermissoes(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		// TODO Auto-generated constructor stub
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
