package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.tables.Endereco;

public class DaoEndereco extends DaoModelo<Endereco> {

	public DaoEndereco(Session session) {
		super(session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Endereco> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Endereco find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}
