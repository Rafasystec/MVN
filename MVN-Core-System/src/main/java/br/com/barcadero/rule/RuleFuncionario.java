package br.com.barcadero.rule;

import org.hibernate.Session;

import br.com.barcadero.dao.DaoFuncionario;
import br.com.barcadero.tables.Entidade;


public class RuleFuncionario extends RuleModelo {

	private DaoFuncionario dao;
	public RuleFuncionario(Session session) {
		super(session);
		this.dao = new DaoFuncionario(session);
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
	public Entidade find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return dao.find(codigo);
	}

}
