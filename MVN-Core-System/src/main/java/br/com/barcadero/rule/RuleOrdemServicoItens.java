package br.com.barcadero.rule;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.barcadero.dao.DaoOrdemServicoItens;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.OrdemServico;
import br.com.barcadero.tables.OrdemServicoItens;

public class RuleOrdemServicoItens extends RuleModelo<OrdemServicoItens> {

	private DaoOrdemServicoItens daoOrdemServicoItens;
	public RuleOrdemServicoItens(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		daoOrdemServicoItens = new DaoOrdemServicoItens(empresa, loja, session);
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoOrdemServicoItens.insert(entidade);
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdemServicoItens find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdemServicoItens> findAll() throws Exception {
		// TODO Auto-generated method stub
		return daoOrdemServicoItens.findAll();
	}
	
	public List<OrdemServicoItens> findByOS(OrdemServico ordemServico) throws Exception {
		return daoOrdemServicoItens.findByOS(ordemServico);
	}
	

}
