package br.com.barcadero.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.barcadero.tables.OrdemServico;
import br.com.barcadero.tables.OrdemServicoItens;

@Repository
public class DaoOrdemServicoItens extends DaoModelo<OrdemServicoItens> {

	public DaoOrdemServicoItens() {
		System.out.println("Auto-generated constructor stub DaoOrdemServicoItens");
	}
//	public DaoOrdemServicoItens(Empresa empresa, Loja loja, Session session) {
//		super(empresa, loja, session);
//		// TODO Auto-generated constructor stub
//	}

	@Override
	public List<OrdemServicoItens> findAll() throws Exception {
		Query qry = manager.createNamedQuery(OrdemServicoItens.FIND_ALL)
				.setParameter("empresa", getEmpresa().getCodigo());
		return qry.getResultList();
	}
	
	public List<OrdemServicoItens> findByOS(OrdemServico ordemServico) {
		Query qry = manager.createNamedQuery(OrdemServicoItens.FIND_BY_OS)
				.setParameter("empresa", getEmpresa().getCodigo())
				.setParameter("ordemservico", ordemServico.getCodigo());
		return qry.getResultList();
	}

	@Override
	public OrdemServicoItens find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
