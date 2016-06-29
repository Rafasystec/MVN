package br.com.barcadero.dao;

import java.util.List;
import org.hibernate.Session;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Marcas;

public class DaoMarcas extends DaoModelo<Marcas> {
	
	

	public DaoMarcas(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
	}

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
