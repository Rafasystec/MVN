package br.com.systeconline.dao.nota;

import java.util.List;

import org.hibernate.Session;

import br.com.systeconline.dao.basicos.DaoModelo;
import br.com.systeconline.tables.basicos.Entidade;

/**
 * Para a nota eletronica NF-e
 * @author root
 *
 */
public final class DaoNotaEletronica extends DaoModelo {

	public DaoNotaEletronica(Session session) {
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
