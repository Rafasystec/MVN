package br.com.barcadero.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.barcadero.tables.Marcas;
@Repository
public class DaoMarcas extends DaoModelo<Marcas> {
	
	public DaoMarcas() {
		// TODO Auto-generated constructor stub
	}

//	public DaoMarcas(Empresa empresa, Loja loja, Session session) {
//		super(empresa, loja, session);
//	}

	@Override
	public List<Marcas> findAll() throws Exception {
		
		return null;
	}

	@Override
	public Marcas find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
