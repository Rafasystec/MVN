package br.com.barcadero.rule;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.dao.DaoCaixaFechamento;
import br.com.barcadero.tables.CaixaFechamento;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;

public class RuleCaixaFechamento extends RuleModelo<CaixaFechamento> {

	DaoCaixaFechamento daoFechamento;
	public RuleCaixaFechamento(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		daoFechamento = new DaoCaixaFechamento(empresa, loja, session);
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		return daoFechamento.insert(entidade);
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoFechamento.delete(codigo);
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		return daoFechamento.update(entidade);
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
}
