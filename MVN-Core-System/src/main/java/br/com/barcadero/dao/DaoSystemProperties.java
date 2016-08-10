package br.com.barcadero.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.barcadero.tables.SystemProperties;
@Repository
public class DaoSystemProperties extends DaoModelo<SystemProperties> {

	public DaoSystemProperties() {
		System.out.println("Auto-generated constructor stub DaoSystemProperties");
	}
	
//	public DaoSystemProperties(Session session) {
//		// TODO Auto-generated constructor stub
//		super(session);
//	}
	
//	public DaoSystemProperties(Empresa empresa, Loja loja, Session session) {
//		super(empresa, loja, session);
//		// TODO Auto-generated constructor stub
//	}

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
		Query qry = manager.createNamedQuery(SystemProperties.FIND);
		return (SystemProperties) qry.getSingleResult();
	}

}
