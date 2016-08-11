package br.com.barcadero.rule;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.dao.DaoContaPagar;
import br.com.barcadero.tables.ContaPagar;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;


public class RuleContaPagar extends RuleModelo<ContaPagar> {

	DaoContaPagar daoContaPagar;
	public RuleContaPagar(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		daoContaPagar = new DaoContaPagar(empresa, loja, session);
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		ContaPagar conta = (ContaPagar)entidade;
		return daoContaPagar.insert(conta);
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoContaPagar.delete(codigo);
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoContaPagar.update(entidade);
	}

	@Override
	public ContaPagar find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoContaPagar.find(codigo);
	}


	@Override
	public List<ContaPagar> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
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
