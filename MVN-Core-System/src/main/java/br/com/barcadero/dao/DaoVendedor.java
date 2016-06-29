package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Vendedor;

public class DaoVendedor extends DaoModelo <Vendedor>{

	public DaoVendedor(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Vendedor> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vendedor find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
