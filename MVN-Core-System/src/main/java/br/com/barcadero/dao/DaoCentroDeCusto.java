package br.com.barcadero.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.barcadero.tables.CentroDeCusto;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;

@Repository
public class DaoCentroDeCusto extends DaoModelo<CentroDeCusto> {

	public DaoCentroDeCusto() {
		
	}
	
	@Override
	public List<CentroDeCusto> findByEmpresa(Empresa empresa) throws Exception {
		TypedQuery<CentroDeCusto> qry = manager.createNamedQuery(CentroDeCusto.FIND_ALL_BY_EMP, CentroDeCusto.class)
				.setParameter(Entidade.PARAM_EMPRESA, empresa);
		return qry.getResultList();
	}

	@Override
	public List<CentroDeCusto> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CentroDeCusto> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CentroDeCusto find(long codigo) throws Exception {
		return find(codigo, CentroDeCusto.class);
	}

}
