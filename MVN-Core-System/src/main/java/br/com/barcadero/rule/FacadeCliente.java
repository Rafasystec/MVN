package br.com.barcadero.rule;

import org.hibernate.Session;

import br.com.barcadero.dao.DaoCliente;
import br.com.barcadero.tables.Cliente;
import br.com.barcadero.tables.Entidade;

public class FacadeCliente extends RuleModelo {

	private final DaoCliente daoCliente;
	
	public FacadeCliente(Session session) {
		super(session);
		daoCliente = new DaoCliente(session);
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
	public Entidade find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoCliente.find(codigo);
	}

}
