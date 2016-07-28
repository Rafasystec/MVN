package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.barcadero.core.util.GlobalNameParam;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Nota;
import br.com.barcadero.tables.NotaItens;

public final class DaoNota extends DaoModelo<Nota> {

	

	public DaoNota(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Nota find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Nota> findAll() throws Exception {
		Query qry = getSession().getNamedQuery(Nota.FIND_ALL);
		return qry.list();
	}
	
	/**
	 * Consulta uma nota pelo seu codigo
	 * @param codigo
	 * @return
	 */
	public Nota findNota(long codigo) {
		Query qry =  getSession().getNamedQuery(Nota.FIND_BY_CODE);
		qry.setLong("codigo", codigo)
		.setLong(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo())
		.setLong(GlobalNameParam.PARAM_COD_LOJA, getLoja().getCodigo());
		return (Nota)qry.uniqueResult();
	}

	/**
	 * Consulta os itens de uma nota pelo codigo da nota
	 * @param codNota
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<NotaItens> getItensByCodeNota(long codNota) {
		Query qry = getSession().getNamedQuery(NotaItens.FIND_BY_CODE_NOTA);
		qry.setLong(NotaItens.PARAM_COD_NOTA, codNota)
			.setLong(GlobalNameParam.PARAM_COD_EMP, empresa.getCodigo())
			.setLong(GlobalNameParam.PARAM_COD_LOJA, loja.getCodigo());
		return qry.list();
	}
}
