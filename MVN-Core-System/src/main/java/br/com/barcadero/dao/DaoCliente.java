package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.tables.Cliente;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;

public class DaoCliente extends DaoModelo<Cliente> {

	
	public DaoCliente(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Cliente find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
