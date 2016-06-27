package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.tables.EntidadeFiliada;

public class DaoEntidadeFiliada extends DaoModelo<EntidadeFiliada> {
	//private EntityManager manager;
	
	public DaoEntidadeFiliada(Session session) {
		super(session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<EntidadeFiliada> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntidadeFiliada find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
