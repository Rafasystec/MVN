package br.com.barcadero.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.barcadero.tables.Avisos;

@Repository
public class DaoAvisos extends DaoModelo<Avisos> {

	public DaoAvisos() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Avisos find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Avisos> findAll() throws Exception {
		Query qry = manager.createNamedQuery(Avisos.FIND_ALL);
		qry.setParameter(Avisos.PARAM_DT_VALIDADE, new Date());
		qry.setParameter(Avisos.PARAM_DT_EXIBIR, new Date());
		return qry.getResultList();
	}

	
}
