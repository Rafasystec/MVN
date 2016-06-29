package br.com.barcadero.rule;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.dao.DaoCliente;
import br.com.barcadero.tables.Cliente;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;

public class FacadeCliente extends RuleModelo<Cliente> {

	

	private final DaoCliente daoCliente;
	
	public FacadeCliente(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		daoCliente = new DaoCliente(empresa, loja, session);
	}
	
	@Override
	public String insert(Entidade entidade) throws Exception {
		Cliente cliente = (Cliente)entidade;
//		PessoaFisica pf = cliente.getPessoaFisica();
//		getSession().merge(pf);
//		cliente.setPessoaFisica(pf);
		
		return daoCliente.insert(cliente);
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoCliente.delete(codigo);
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoCliente.update(entidade);
	}

	@Override
	public List<Cliente> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
