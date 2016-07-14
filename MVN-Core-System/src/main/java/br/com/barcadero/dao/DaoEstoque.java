package br.com.barcadero.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import br.com.barcadero.core.util.GlobalNameParam;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Estoque;
import br.com.barcadero.tables.Loja;

public class DaoEstoque extends DaoModelo<Estoque> {

	public DaoEstoque(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
	}

	@Override
	public List<Estoque> findAll() throws Exception {
		return getMainQuery(Estoque.FIND_ALL).list();
	}

	@Override
	public Estoque find(long codigo) throws Exception {
		Query qry = getMainQuery(Estoque.FIND_BY_COD).setLong("codigo", codigo);
		return (Estoque) qry.uniqueResult();
	}
	
	public List<Estoque> findByCodigoOrDescricao(String codigoDescricao) throws Exception {
		return null;
	}
	
	private Query getMainQuery(String queryName) {
		Query qry = getSession().getNamedQuery(queryName)
				.setLong(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo());
		return qry;
	}

}
