package br.com.systeconline.dao.basicos;

import java.util.List;

import org.hibernate.Session;

import br.com.systeconline.tables.basicos.Entidade;

public class DaoEndereco extends DaoModelo {

	public DaoEndereco(Session session) {
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
