package br.com.barcadero.rule;

import org.hibernate.Session;

import br.com.barcadero.dao.DaoPessoaJuridica;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.PessoaJuridica;

public class RulePessoaJuridica extends RuleModelo {

	private DaoPessoaJuridica daoPessoa;
	public RulePessoaJuridica(Session session) {
		super(session);
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
	public Entidade find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
