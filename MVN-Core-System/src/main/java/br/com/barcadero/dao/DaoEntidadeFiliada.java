package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.EntidadeFiliada;
import br.com.barcadero.tables.Loja;

public class DaoEntidadeFiliada extends DaoModelo<EntidadeFiliada> {
	//private EntityManager manager;
	
	public DaoEntidadeFiliada(Session session) {
		super(session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<EntidadeFiliada> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntidadeFiliada find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntidadeFiliada> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntidadeFiliada> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
