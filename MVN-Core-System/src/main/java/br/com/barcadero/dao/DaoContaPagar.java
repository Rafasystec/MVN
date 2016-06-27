package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.barcadero.tables.ContaPagar;

public class DaoContaPagar extends DaoModelo <ContaPagar>{

	public DaoContaPagar(Session session) {
		super(session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ContaPagar find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		Query qry = getSession().getNamedQuery(ContaPagar.FIND_BY_CODE);
		qry.setParameter(ContaPagar.PARAM_CODIGO, codigo);
		return (ContaPagar) qry.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ContaPagar> findAll() throws Exception {
		// TODO Auto-generated method stub
		Query qry = getSession().getNamedQuery(ContaPagar.FIND_ALL);
		return qry.list();
	}

}
