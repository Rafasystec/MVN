package br.com.barcadero.rule.financeiro;

import org.hibernate.Session;

import br.com.systeconline.dao.financeiro.DaoContaPagar;
import br.com.systeconline.rule.RuleModelo;
import br.com.systeconline.tables.basicos.Entidade;
import br.com.systeconline.tables.financeiro.ContaPagar;

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
