package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.MeiosPagamento;

public class DaoMeioPgto extends DaoModelo<MeiosPagamento> {


	public DaoMeioPgto(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public MeiosPagamento find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		Query qry = getSession().getNamedQuery(MeiosPagamento.FIND_BY_CODE);
		qry.setParameter("codigo", codigo);
		return (MeiosPagamento)qry.uniqueResult();
	}

	@Override
	public List<MeiosPagamento> findAll() throws Exception {
		// TODO Auto-generated method stub
		Query qry = getSession().getNamedQuery(MeiosPagamento.FIND_ALL);
		qry.setMaxResults(100);
		return (List<MeiosPagamento>)qry.list();
	}
	
	
	public List<MeiosPagamento> getAll() {
		Query qry = getSession().getNamedQuery(MeiosPagamento.FIND_ALL);
		qry.setMaxResults(100);
		return qry.list();
	}
	
	

}
