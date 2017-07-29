package br.com.barcadero.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import br.com.barcadero.tables.ContaPagar;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
@Repository
public class DaoContaPagar extends DaoModelo <ContaPagar>{

	

	public DaoContaPagar() {
		System.out.println(mesageInstanceSpring+DaoContaPagar.class.getName());
	}
	public DaoContaPagar(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
	}

	@Override
	public ContaPagar find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		//Query qry = getSession().getNamedQuery(ContaPagar.FIND_BY_CODE);
		//qry.setParameter(ContaPagar.PARAM_CODIGO, codigo);
		//return (ContaPagar) qry.uniqueResult();
		return null;
		
	}

	@Override
	public List<ContaPagar> findAll() throws Exception {
		TypedQuery<ContaPagar> qry = manager.createNamedQuery(ContaPagar.FIND_ALL, ContaPagar.class);
		return qry.getResultList();
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
