package br.com.barcadero.rule;

import org.hibernate.Session;

import br.com.barcadero.dao.DaoVendedor;
import br.com.barcadero.tables.Entidade;


public class RuleVendedor extends RuleModelo {

	private DaoVendedor daoVendedor;
	public RuleVendedor(Session session) {
		super(session);
		daoVendedor = new DaoVendedor(session);
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoVendedor.insert(entidade);
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoVendedor.delete(codigo);
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoVendedor.update(entidade);
	}

	@Override
	public Entidade find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
