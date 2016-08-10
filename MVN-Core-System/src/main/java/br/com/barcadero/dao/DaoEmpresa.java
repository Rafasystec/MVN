package br.com.barcadero.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import br.com.barcadero.tables.Empresa;

@Repository
public class DaoEmpresa extends DaoModelo<Empresa> {

	public DaoEmpresa() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Empresa find(long codigo) throws Exception {
		Query qry = manager.createNamedQuery(Empresa.FIND)
				.setParameter("codigo", codigo);
		return (Empresa) qry.getSingleResult();
	}

	@Override
	public List<Empresa> findAll() throws Exception {
		// TODO Auto-generated method stub
		return findAll();
	}
	
}
