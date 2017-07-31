package br.com.barcadero.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.barcadero.tables.Bancos;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;

@Repository
public class DaoBancos extends DaoModelo<Bancos> {

	public DaoBancos() {
		System.out.println(mesageInstanceSpring+DaoBancos.class.getName());
	}
	@Override
	public List<Bancos> findByEmpresa(Empresa empresa) throws Exception {
		TypedQuery<Bancos> qry = manager.createNamedQuery(Bancos.FIND_BY_EMPRESA, Bancos.class)
				.setParameter(Entidade.PARAM_EMPRESA, empresa);
		return qry.getResultList();
	}

	@Override
	public List<Bancos> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bancos> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bancos find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
