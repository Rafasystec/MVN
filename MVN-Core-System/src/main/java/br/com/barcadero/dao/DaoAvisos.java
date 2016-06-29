package br.com.barcadero.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import br.com.barcadero.tables.Avisos;

public class DaoAvisos extends DaoModelo<Avisos> {

	public DaoAvisos(Session session) {
		super(session);
	}

	@Override
	public Avisos find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Avisos> findAll() throws Exception {
		Query qry = getSession().getNamedQuery(Avisos.FIND_ALL);
		qry.setParameter(Avisos.PARAM_DT_VALIDADE, new Date());
		qry.setParameter(Avisos.PARAM_DT_EXIBIR, new Date());
		return qry.list();
	}

	
}
