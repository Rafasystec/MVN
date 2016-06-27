package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.tables.PlanoConta;

public class DaoPlanoContas extends DaoModelo<PlanoConta> {

	public DaoPlanoContas(Session session) {
		super(session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public PlanoConta find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlanoConta> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
