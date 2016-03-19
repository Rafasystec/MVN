package br.com.systeconline.dao.nota;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import br.com.systeconline.dao.basicos.DaoModelo;
import br.com.systeconline.tables.basicos.Entidade;
import br.com.systeconline.tables.nota.Nota;
import br.com.systeconline.tables.nota.NotaItens;

public final class DaoNota extends DaoModelo {

	public DaoNota(Session session) {
		super(session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Entidade find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entidade> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Consulta uma nota pelo seu codigo
	 * @param codigo
	 * @return
	 */
	public Nota findNota(long codigo) {
		Query qry =  getSession().getNamedQuery(Nota.FIND_BY_CODE);
		qry.setParameter("codigo", codigo);
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
		qry.setParameter(NotaItens.PARAM_COD_NOTA, codNota);
		return qry.list();
	}
}
