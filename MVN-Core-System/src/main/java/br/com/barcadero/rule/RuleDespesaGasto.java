package br.com.barcadero.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.barcadero.dao.DaoDespesaGasto;
import br.com.barcadero.tables.DespesaGasto;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;

public class RuleDespesaGasto extends RuleModelo<DespesaGasto> {

	@Autowired
	private DaoDespesaGasto dao;
	
	@Override
	public String insert(Entidade entidade) throws Exception {
		
		return null;
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
	public DespesaGasto find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DespesaGasto> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DespesaGasto> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DespesaGasto> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public DaoDespesaGasto getDao() {
		return dao;
	}

	public void setDao(DaoDespesaGasto dao) {
		this.dao = dao;
	}

	@Override
	public DespesaGasto insert(DespesaGasto entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DespesaGasto update(DespesaGasto entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
