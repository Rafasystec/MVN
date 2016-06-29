package br.com.barcadero.rule;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.dao.DaoVendedor;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Vendedor;


public class RuleVendedor extends RuleModelo<Vendedor> {

	

	private DaoVendedor daoVendedor;

	public RuleVendedor(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		// TODO Auto-generated constructor stub
		daoVendedor = new DaoVendedor(empresa, loja, session);
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
	public List<Vendedor> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vendedor find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
