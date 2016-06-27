package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.tables.PessoaJuridica;

public class DaoPessoaJuridica extends DaoModelo<PessoaJuridica> {

	public DaoPessoaJuridica(Session session) {
		super(session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<PessoaJuridica> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PessoaJuridica find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
