package br.com.barcadero.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.dao.DaoPessoaJuridica;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.PessoaJuridica;
@Service
public class RulePessoaJuridica extends RuleModelo<PessoaJuridica> {

	
	private DaoPessoaJuridica daoPessoa;
	
	@Autowired
	public RulePessoaJuridica(DaoPessoaJuridica daoPessoa) {
		// TODO Auto-generated constructor stub
		this.daoPessoa = daoPessoa;
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

	@Override
	public List<PessoaJuridica> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PessoaJuridica> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
