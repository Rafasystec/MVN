package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.barcadero.core.util.GlobalNameParam;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;

public class DaoLoja extends DaoModelo {

	public DaoLoja(Session session) {
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
		Query qry = getSession().getNamedQuery(Loja.FIND_ALL);
		return qry.list();
	}
	
	/**
	 * Obter todas as lojas de uma determinada empresa.
	 * @param cdEmp
	 * @return
	 * @throws Exception
	 */
	public List<Loja> getLojasDaEmpresa(long cdEmp) throws Exception{
		Query qry = getSession().getNamedQuery(Loja.FIND_BY_EMP);
		qry.setParameter(GlobalNameParam.PARAM_COD_EMP, cdEmp);
		return (List<Loja>)qry.list();
	}

}
