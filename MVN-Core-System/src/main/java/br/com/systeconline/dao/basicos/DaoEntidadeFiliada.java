package br.com.systeconline.dao.basicos;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import br.com.systeconline.tables.basicos.Bairro;
import br.com.systeconline.tables.basicos.Entidade;

public class DaoEntidadeFiliada extends DaoModelo {
	//private EntityManager manager;
	
	public DaoEntidadeFiliada(Session session) {
		super(session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Entidade find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entidade> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
