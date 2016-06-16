package br.com.barcadero.rule;

import org.hibernate.Session;

import br.com.barcadero.dao.DaoContaPagar;
import br.com.barcadero.tables.ContaPagar;
import br.com.barcadero.tables.Entidade;


public class RuleContaPagar extends RuleModelo {

	DaoContaPagar daoContaPagar;
	public RuleContaPagar(Session session) {
		super(session);
		daoContaPagar = new DaoContaPagar(session);
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
	public Entidade find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoContaPagar.find(codigo);
	}

}
