package br.com.barcadero.rule;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.dao.DaoContaPagar;
import br.com.barcadero.tables.ContaPagar;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;


@Service
public class RuleContaPagar extends RuleModelo<ContaPagar> {

	public RuleContaPagar() {
		System.out.println("Auto-generated constructor stub for class " + RuleContaPagar.class.getName()); 
	}
	@Autowired
	DaoContaPagar daoContaPagar;
	public RuleContaPagar(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		daoContaPagar = new DaoContaPagar(empresa, loja, session);
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoContaPagar.delete(codigo);
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

	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContaPagar insert(ContaPagar entidade) throws Exception {
		return daoContaPagar.insert(entidade);
	}

	@Override
	public ContaPagar update(ContaPagar entidade) throws Exception {
		return daoContaPagar.update(entidade);
	}

}
