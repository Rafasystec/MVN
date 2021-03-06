package br.com.barcadero.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Receita;
@Repository
public class DaoReceita extends DaoModelo<Receita> {

	public DaoReceita() {
	}
	@Override
	public List<Receita> findByEmpresa(Empresa empresa) throws Exception {
		TypedQuery<Receita> qry = manager.createNamedQuery(Receita.FIND_RECEITAS_FIXAS, Receita.class)
				.setParameter(Receita.PARAM_EMPRESA, empresa)
				.setParameter(Receita.PARAM_FL_ATIVO, true);
		return qry.getResultList();
	}

	@Override
	public List<Receita> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Receita> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Receita find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
