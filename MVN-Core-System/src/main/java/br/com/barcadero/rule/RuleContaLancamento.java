package br.com.barcadero.rule;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.barcadero.dao.DaoContaLancamento;
import br.com.barcadero.tables.ContaLancamento;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Usuario;

@Service
public class RuleContaLancamento extends RuleModelo<ContaLancamento> {

	private DaoContaLancamento dao;
	public RuleContaLancamento(Empresa empresa, Loja loja, Usuario usuario) {
		this.dao = new DaoContaLancamento(empresa, loja);
	}
	
	@Override
	public String insert(Entidade entidade) throws Exception {
		return "";
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
	public ContaLancamento find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContaLancamento> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContaLancamento> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContaLancamento> findAll() throws Exception {
		return null;
	}

	@Override
	public ContaLancamento insert(ContaLancamento entidade) throws Exception {
		return dao.insert(entidade);
	}

	@Override
	public ContaLancamento update(ContaLancamento entidade) throws Exception {
		return dao.update(entidade);
	}

}
