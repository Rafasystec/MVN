package br.com.barcadero.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.barcadero.tables.Produto;

public class DaoProduto extends DaoModelo <Produto>{

	public DaoProduto(Session session) {
		super(session);
	}

	@Override
	public Produto find(long codigo) throws Exception {
		Query qry = getSession().getNamedQuery(Produto.FIND_BY_CODE);
		qry.setParameter("codigo", codigo);
		return (Produto)qry.uniqueResult();
	}

	@Override
	public List<Produto> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Produto> findByDataCadastro(Date date) throws Exception {
		Query qry = getSession().getNamedQuery(Produto.FIND_BY_DATE);
		qry.setParameter("date", date);
		return qry.list();
	}

}
