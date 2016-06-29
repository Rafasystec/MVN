package br.com.barcadero.rule;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.dao.DaoPessoaJuridica;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.PessoaJuridica;

public class RulePessoaJuridica extends RuleModelo<PessoaJuridica> {

	
	private DaoPessoaJuridica daoPessoa;
	public RulePessoaJuridica(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		daoPessoa = new DaoPessoaJuridica(session);
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		PessoaJuridica pj = (PessoaJuridica)entidade;
		String cnpj 	= pj.getCnpj().replace(".", "").replace("-", "").replace("/", "");
		String contato	= pj.getFone().replace("(", "").replace(")", "").replace("-", "");
		pj.setCnpj(cnpj);
		pj.setFone(contato);
		return daoPessoa.insert(pj);
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoPessoa.delete(codigo);
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoPessoa.update(entidade);
	}

	@Override
	public PessoaJuridica find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PessoaJuridica> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
