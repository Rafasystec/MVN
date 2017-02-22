package br.com.barcadero.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.barcadero.tables.Avisos;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;

@Repository
public class DaoAvisos extends DaoModelo<Avisos> {

	public DaoAvisos() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Avisos find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return manager.find(Avisos.class, codigo);
	}


	public List<Avisos> findAll() throws Exception {
		Query qry = manager.createNamedQuery(Avisos.FIND_ALL);
		qry.setParameter(Avisos.PARAM_DT_VALIDADE, new Date());
		qry.setParameter(Avisos.PARAM_DT_EXIBIR, new Date());
		return qry.getResultList();
	}

	@Override
	public List<Avisos> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Avisos> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
