package br.com.barcadero.dao.backoffice;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.systeconline.dao.basicos.DaoModelo;
import br.com.systeconline.tables.backoffice.Produto;
import br.com.systeconline.tables.basicos.Entidade;

public class DaoProduto extends DaoModelo {

	public DaoProduto(Session session) {
		super(session);
	}

	@Override
	public Entidade find(long codigo) throws Exception {
		Query qry = getSession().getNamedQuery(Produto.FIND_BY_CODE);
		qry.setParameter("codigo", codigo);
		return (Produto)qry.uniqueResult();
	}

	@Override
	public List<Entidade> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Produto> findByDataCadastro(Date date) throws Exception {
		Query qry = getSession().getNamedQuery(Produto.FIND_BY_DATE);
		qry.setParameter("date", date);
		return qry.list();
	}

}
