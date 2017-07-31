package br.com.barcadero.rule;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.dao.DaoCaixaFechamento;
import br.com.barcadero.tables.CaixaFechamento;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;

public class RuleCaixaFechamento extends RuleModelo<CaixaFechamento> {

	DaoCaixaFechamento daoFechamento;
	public RuleCaixaFechamento(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		daoFechamento = new DaoCaixaFechamento(empresa, loja, session);
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoFechamento.delete(codigo);
	}

	@Override
	public CaixaFechamento find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoFechamento.find(codigo);
	}

	@Override
	public List<CaixaFechamento> findAll() throws Exception {
		// TODO Auto-generated method stub
		return daoFechamento.findAll();
	}

	@Override
	public List<CaixaFechamento> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CaixaFechamento> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CaixaFechamento insert(CaixaFechamento entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CaixaFechamento update(CaixaFechamento entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
