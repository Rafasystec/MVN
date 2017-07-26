package br.com.barcadero.rule;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.barcadero.dao.DaoOrdemServicoItens;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.OrdemServico;
import br.com.barcadero.tables.OrdemServicoItens;

@Service
public class RuleOrdemServicoItens extends RuleModelo<OrdemServicoItens> {

	private DaoOrdemServicoItens daoOrdemServicoItens;
	
	@Autowired
	public RuleOrdemServicoItens(DaoOrdemServicoItens daoOrdemServicoItens) {
		System.out.println("Auto-generated constructor stub RuleOrdemServicoItens");
		this.daoOrdemServicoItens = daoOrdemServicoItens;
	}

//	@Override
//	public String insert(Entidade entidade) throws Exception {
//		// TODO Auto-generated method stub
//		return daoOrdemServicoItens.insert(entidade);
//	}

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

	@Override
	public List<OrdemServicoItens> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdemServicoItens> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdemServicoItens insert(OrdemServicoItens entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdemServicoItens update(OrdemServicoItens entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
