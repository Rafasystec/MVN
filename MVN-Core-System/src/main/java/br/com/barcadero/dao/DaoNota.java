package br.com.barcadero.dao;

import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import br.com.barcadero.core.util.GlobalNameParam;
import br.com.barcadero.tables.Nota;
import br.com.barcadero.tables.NotaItens;

@Repository
public class DaoNota extends DaoModelo<Nota> {

	

	public DaoNota() {
		System.out.println("Auto-generated constructor stub for DaoNota");
	}
	
//	public DaoNota(Empresa empresa, Loja loja, Session session) {
//		super(empresa, loja, session);
//		// TODO Auto-generated constructor stub
//	}

	@Override
	public Nota find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Nota> findAll() throws Exception {
		Query qry = manager.createNamedQuery(Nota.FIND_ALL);
		return qry.getResultList();
	}
	
	/**
	 * Consulta uma nota pelo seu codigo
	 * @param codigo
	 * @return
	 */
	public Nota findNota(long codigo) {
		Query qry =  manager.createNamedQuery(Nota.FIND_BY_CODE);
		qry.setParameter("codigo", codigo)
		.setParameter(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo())
		.setParameter(GlobalNameParam.PARAM_COD_LOJA, getLoja().getCodigo());
		return (Nota)qry.getSingleResult();
	}

	/**
	 * Consulta os itens de uma nota pelo codigo da nota
	 * @param codNota
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<NotaItens> getItensByCodeNota(long codNota) {
		Query qry = manager.createNamedQuery(NotaItens.FIND_BY_CODE_NOTA);
		 qry.setParameter(NotaItens.PARAM_COD_NOTA, codNota)
			.setParameter(GlobalNameParam.PARAM_COD_EMP, empresa.getCodigo())
			.setParameter(GlobalNameParam.PARAM_COD_LOJA, loja.getCodigo());
		return qry.getResultList();
	}
}
