package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.tables.ContaReceber;
import br.com.barcadero.tables.Entidade;

/**
 * Para as Contas a pagar
 * @author root
 * @since 1.0 dia 26/06/2016 as 17:36
 */
public class DaoContaAReceber extends DaoModelo <ContaReceber>{

	public DaoContaAReceber(Session session) {
		super(session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ContaReceber find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContaReceber> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
