package br.com.barcadero.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.barcadero.tables.OrdemServico;

@Repository
public class DaoOrdemServico extends DaoModelo<OrdemServico> {

	public DaoOrdemServico() {
		System.out.println("Auto-generated constructor stub DaoOrdemServico");
	}
//	public DaoOrdemServico(Empresa empresa, Loja loja, Session session) {
//		super(empresa, loja, session);
//		// TODO Auto-generated constructor stub
//	}

	@Override
	public List<OrdemServico> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdemServico find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
