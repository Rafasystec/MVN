package br.com.barcadero.dao.backoffice;

import java.util.List;

import org.hibernate.Session;

import br.com.systeconline.dao.basicos.DaoModelo;
import br.com.systeconline.tables.basicos.Entidade;

public class DaoVendedor extends DaoModelo {

	public DaoVendedor(Session session) {
		super(session);
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
