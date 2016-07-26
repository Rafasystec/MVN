package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.OrdemServicoItens;

public class DaoOrdemServicoItens extends DaoModelo<OrdemServicoItens> {

	public DaoOrdemServicoItens(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<OrdemServicoItens> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdemServicoItens find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
