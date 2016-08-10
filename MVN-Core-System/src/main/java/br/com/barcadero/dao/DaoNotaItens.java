package br.com.barcadero.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.barcadero.tables.NotaItens;

@Repository
public class DaoNotaItens extends DaoModelo<NotaItens>{


	public DaoNotaItens() {
		System.out.println("Auto-generated constructor stub DaoNotaItens");
	}
//	public DaoNotaItens(Empresa empresa, Loja loja, Session session) {
//		super(empresa, loja, session);
//		// TODO Auto-generated constructor stub
//	}

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
