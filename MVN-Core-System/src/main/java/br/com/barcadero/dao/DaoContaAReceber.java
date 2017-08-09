package br.com.barcadero.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.barcadero.tables.ContaReceber;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;

/**
 * Para as Contas a pagar
 * @author root
 * @since 1.0 dia 26/06/2016 as 17:36
 */
@Repository
public class DaoContaAReceber extends DaoModelo <ContaReceber>{

	public DaoContaAReceber() {
	}

	@Override
	public ContaReceber find(long codigo) throws Exception {
		return find(codigo, ContaReceber.class);
	}

	@Override
	public List<ContaReceber> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContaReceber> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContaReceber> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
