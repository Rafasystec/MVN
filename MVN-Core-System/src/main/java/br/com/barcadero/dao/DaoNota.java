package br.com.barcadero.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import br.com.barcadero.core.util.GlobalNameParam;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Nota;
import br.com.barcadero.tables.NotaItens;

@Repository
public class DaoNota extends DaoModelo<Nota> {

	

	public DaoNota() {
		System.out.println("Auto-generated constructor stub for DaoNota");
	}

	@Override
	public Nota find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Nota> findAll() throws Exception {
		TypedQuery<Nota> qry = manager.createNamedQuery(Nota.FIND_ALL,Nota.class);
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

	@Override
	public List<Nota> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Nota> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Nota> findNotasFaturadasDoDia(Empresa empresa, Loja loja) {
		TypedQuery<Nota> qry = getManager().createNamedQuery(Nota.FIND_DO_DIA_BY_EMP_LOJA, Nota.class)
				.setParameter("empresa", empresa)
				.setParameter("loja", loja)
				.setParameter("dtCadastro", new Date())
				.setParameter("flNotaCancelada", false);
		return qry.getResultList();
	}
}
