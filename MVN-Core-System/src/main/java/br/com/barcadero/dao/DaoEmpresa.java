package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;

public class DaoEmpresa extends DaoModelo<Empresa> {

	

	private DaoPessoaJuridica daoPJ;
	private DaoEndereco daoEndereco;
	
	public DaoEmpresa(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		daoPJ 		= new DaoPessoaJuridica(session);
		daoEndereco = new DaoEndereco(empresa, loja, session);
	}
	
	@Override
	public Empresa find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return find(codigo);
	}

	@Override
	public List<Empresa> findAll() throws Exception {
		// TODO Auto-generated method stub
		return findAll();
	}
	
}
