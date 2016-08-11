package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.PessoaJuridica;

@Repository
public class DaoPessoaJuridica extends DaoModelo<PessoaJuridica> {

	public DaoPessoaJuridica() {
		System.out.println("Auto-generated constructor stub DaoPessoaJuridica");
	}
//	public DaoPessoaJuridica(Session session) {
//		super(session);
//		// TODO Auto-generated constructor stub
//	}

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

	@Override
	public List<PessoaJuridica> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PessoaJuridica> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
