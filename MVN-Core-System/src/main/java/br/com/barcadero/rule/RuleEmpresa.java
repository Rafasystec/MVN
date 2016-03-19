package br.com.barcadero.rule;

import org.hibernate.Session;

import br.com.barcadero.dao.DaoEmpresa;
import br.com.systeconline.rule.RuleModelo;
import br.com.systeconline.tables.basicos.Empresa;
import br.com.systeconline.tables.basicos.Entidade;

public class RuleEmpresa extends RuleModelo {

	private DaoEmpresa daoEmpresa;
	public RuleEmpresa(Session session) {
		super(session);
		daoEmpresa  = new DaoEmpresa(session);
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		Empresa empresa = (Empresa)entidade;
		retirarFormatcao(empresa);
		return daoEmpresa.insert(empresa);
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
	public Entidade find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void retirarFormatcao(Empresa empresa) {
		String cnpj = empresa.getPessoaJuridica().getCnpj();
		String fone = empresa.getPessoaJuridica().getFone();
		cnpj = cnpj.replace(".", "").replace("/", "").replace("-", "");
		fone = fone.replace("-", "").replace("(", "").replace(")", "");
		empresa.getPessoaJuridica().setCnpj(cnpj);
		empresa.getPessoaJuridica().setFone(fone);
	}

}
