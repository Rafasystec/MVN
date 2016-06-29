package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.PlanoConta;

public class DaoPlanoContas extends DaoModelo<PlanoConta> {


	public DaoPlanoContas(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
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
