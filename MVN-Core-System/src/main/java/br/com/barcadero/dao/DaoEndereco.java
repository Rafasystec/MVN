package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Endereco;
import br.com.barcadero.tables.Loja;

public class DaoEndereco extends DaoModelo<Endereco> {

	

	public DaoEndereco(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
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
