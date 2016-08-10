package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.UsuarioPermissoes;

@Repository
public class DaoUsuariosPermissoes extends DaoModelo <UsuarioPermissoes>{

	public DaoUsuariosPermissoes() {
		// TODO Auto-generated constructor stub
	}
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
