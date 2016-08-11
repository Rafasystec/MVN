package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.tables.CaixaFechamento;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;

public class DaoCaixaFechamento extends DaoModelo<CaixaFechamento> {

	public DaoCaixaFechamento(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
	}

	@Override
	public List<CaixaFechamento> findAll() throws Exception {
		return null;
	}

	@Override
	public CaixaFechamento find(long codigo) throws Exception {
		return null;
	}

	@Override
	public List<CaixaFechamento> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CaixaFechamento> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
