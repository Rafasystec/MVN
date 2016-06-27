package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.tables.Cliente;

public class DaoCliente extends DaoModelo<Cliente> {

	public DaoCliente(Session session) {
		super(session);
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
