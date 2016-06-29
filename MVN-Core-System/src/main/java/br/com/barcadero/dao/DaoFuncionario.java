package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Funcionario;
import br.com.barcadero.tables.Loja;

public class DaoFuncionario extends DaoModelo<Funcionario> {

	public DaoFuncionario(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Funcionario find(long codigo) throws Exception {
		Query qry = getSession().getNamedQuery(Funcionario.FIND_BY_CODE).setLong("codigo", codigo);
		return (Funcionario) qry.uniqueResult();
	}

	@Override
	public List<Funcionario> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
