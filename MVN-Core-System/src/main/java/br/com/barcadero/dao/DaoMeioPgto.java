package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.MeiosPagamento;

public class DaoMeioPgto extends DaoModelo {

	public DaoMeioPgto(Session session) {
		super(session);
	}

	@Override
	public Entidade find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		Query qry = getSession().getNamedQuery(MeiosPagamento.FIND_BY_CODE);
		qry.setParameter("codigo", codigo);
		return (MeiosPagamento)qry.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entidade> findAll() throws Exception {
		// TODO Auto-generated method stub
		Query qry = getSession().getNamedQuery(MeiosPagamento.FIND_ALL);
		qry.setMaxResults(100);
		return (List<Entidade>)qry.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<MeiosPagamento> getAll() {
		Query qry = getSession().getNamedQuery(MeiosPagamento.FIND_ALL);
		qry.setMaxResults(100);
		return qry.list();
	}
	
	

}
