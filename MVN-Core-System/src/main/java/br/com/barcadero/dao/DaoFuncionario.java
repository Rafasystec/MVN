package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Funcionario;

public class DaoFuncionario extends DaoModelo {

	public DaoFuncionario(Session session) {
		super(session);
	}

	@Override
	public Entidade find(long codigo) throws Exception {
		Query qry = getSession().getNamedQuery(Funcionario.FIND_BY_CODE).setLong("codigo", codigo);
		return (Entidade) qry.uniqueResult();
	}

	@Override
	public List<Entidade> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
