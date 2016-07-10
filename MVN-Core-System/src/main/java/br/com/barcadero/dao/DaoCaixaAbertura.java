package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.tables.CaixaAbertura;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;

public class DaoCaixaAbertura extends DaoModelo<CaixaAbertura> {

	public DaoCaixaAbertura(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<CaixaAbertura> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CaixaAbertura find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
