package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.tables.CartaoPresenteUtilizacoes;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;

public class DaoCartaoPresenteUtilizacoes extends DaoModelo<CartaoPresenteUtilizacoes> {

	public DaoCartaoPresenteUtilizacoes(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
	}

	@Override
	public List<CartaoPresenteUtilizacoes> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartaoPresenteUtilizacoes find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartaoPresenteUtilizacoes> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartaoPresenteUtilizacoes> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
