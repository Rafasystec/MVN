package br.com.barcadero.dao;

import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import br.com.barcadero.tables.MeiosPagamento;

@Repository
public class DaoMeioPgto extends DaoModelo<MeiosPagamento> {

	public DaoMeioPgto() {
		// TODO Auto-generated constructor stub
	}

//	public DaoMeioPgto(Empresa empresa, Loja loja, Session session) {
//		super(empresa, loja, session);
//		// TODO Auto-generated constructor stub
//	}

	@Override
	public MeiosPagamento find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		Query qry = manager.createNamedQuery(MeiosPagamento.FIND_BY_CODE);
		qry.setParameter("codigo", codigo);
		return (MeiosPagamento)qry.getSingleResult();
	}

	@Override
	public List<MeiosPagamento> findAll() throws Exception {
		// TODO Auto-generated method stub
		Query qry = manager.createNamedQuery(MeiosPagamento.FIND_ALL);
		qry.setMaxResults(100);
		return (List<MeiosPagamento>)qry.getResultList();
	}
	
	
	public List<MeiosPagamento> getAll() {
		Query qry = manager.createNamedQuery(MeiosPagamento.FIND_ALL);
		qry.setMaxResults(100);
		return qry.getResultList();
	}
	
	

}
