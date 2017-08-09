package br.com.barcadero.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.barcadero.dao.DaoContaAReceber;
import br.com.barcadero.tables.ContaReceber;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;

@Service
public class RuleContaAReceber extends RuleModelo<ContaReceber> {

	@Autowired
	private DaoContaAReceber daoContaAReceber;
	
	public RuleContaAReceber() {
		
	}
	

	@Transactional
	@Override
	public String delete(long codigo) throws Exception {
		return daoContaAReceber.delete(codigo);
	}

	@Override
	public ContaReceber find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContaReceber> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContaReceber> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContaReceber> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContaReceber insert(ContaReceber entidade) throws Exception {
		return daoContaAReceber.insert(entidade);
	}

	@Override
	public ContaReceber update(ContaReceber entidade) throws Exception {
		return daoContaAReceber.update(entidade);
	}


	public DaoContaAReceber getDaoContaAReceber() {
		return daoContaAReceber;
	}


	public void setDaoContaAReceber(DaoContaAReceber daoContaAReceber) {
		this.daoContaAReceber = daoContaAReceber;
	}

}
