package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.tables.NotaItens;

public class DaoNotaItens extends DaoModelo<NotaItens>{

	public DaoNotaItens(Session session) {
		super(session);
		
	}

	@Override
	public List<NotaItens> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotaItens find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



}
