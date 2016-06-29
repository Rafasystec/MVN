package br.com.barcadero.rule;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.dao.DaoFuncionario;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Funcionario;
import br.com.barcadero.tables.Loja;


public class RuleFuncionario extends RuleModelo<Funcionario> {

	private DaoFuncionario dao;
	
	public RuleFuncionario(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		this.dao = new DaoFuncionario(empresa, loja, session);
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return dao.insert(entidade);
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return dao.delete(codigo);
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return dao.update(entidade);
	}

	@Override
	public Funcionario find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return dao.find(codigo);
	}

	@Override
	public List<Funcionario> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
