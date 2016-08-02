package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.SystemProperties;

public class DaoSystemProperties extends DaoModelo<SystemProperties> {

	public DaoSystemProperties(Session session) {
		// TODO Auto-generated constructor stub
		super(session);
	}
	
	public DaoSystemProperties(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<SystemProperties> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SystemProperties find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public SystemProperties find() throws Exception {
		Query qry = getSession().getNamedQuery(SystemProperties.FIND);
		return (SystemProperties) qry.uniqueResult();
	}

}
