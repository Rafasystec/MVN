package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.tables.CaixaOperacoes;

public class DaoCaixaOperacoes extends DaoModelo<CaixaOperacoes> {

	public DaoCaixaOperacoes(Session session) {
		super(session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public CaixaOperacoes find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CaixaOperacoes> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
