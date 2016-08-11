package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.barcadero.tables.ContaPagar;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;

public class DaoContaPagar extends DaoModelo <ContaPagar>{

	

	public DaoContaPagar(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ContaPagar find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		Query qry = getSession().getNamedQuery(ContaPagar.FIND_BY_CODE);
		qry.setParameter(ContaPagar.PARAM_CODIGO, codigo);
		return (ContaPagar) qry.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ContaPagar> findAll() throws Exception {
		// TODO Auto-generated method stub
		Query qry = getSession().getNamedQuery(ContaPagar.FIND_ALL);
		return qry.list();
	}

	@Override
	public List<ContaPagar> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContaPagar> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
