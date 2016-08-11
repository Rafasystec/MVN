package br.com.barcadero.dao;

import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import br.com.barcadero.core.util.GlobalNameParam;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Estoque;
import br.com.barcadero.tables.Loja;

@Repository
public class DaoEstoque extends DaoModelo<Estoque> {

	public DaoEstoque() {
		
	}

	@Override
	public List<Estoque> findAll() throws Exception {
		return getMainQuery(Estoque.FIND_ALL).getResultList();
	}

	@Override
	public Estoque find(long codigo) throws Exception {
		Query qry = getMainQuery(Estoque.FIND_BY_COD).setParameter("codigo", codigo);
		return (Estoque) qry.getSingleResult();
	}
	
	public List<Estoque> findByCodigoOrDescricao(String codigoDescricao) throws Exception {
		return null;
	}
	
	private Query getMainQuery(String queryName) {
		Query qry = manager.createNamedQuery(queryName)
				.setParameter(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo());
		return qry;
	}

	@Override
	public List<Estoque> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estoque> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
