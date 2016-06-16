package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.barcadero.tables.ContaPagar;
import br.com.barcadero.tables.Entidade;

public class DaoContaPagar extends DaoModelo {

	public DaoContaPagar(Session session) {
		super(session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Entidade find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		Query qry = getSession().getNamedQuery(ContaPagar.FIND_BY_CODE);
		qry.setParameter(ContaPagar.PARAM_CODIGO, codigo);
		return (Entidade) qry.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entidade> findAll() throws Exception {
		// TODO Auto-generated method stub
		Query qry = getSession().getNamedQuery(ContaPagar.FIND_ALL);
		return qry.list();
	}

}
