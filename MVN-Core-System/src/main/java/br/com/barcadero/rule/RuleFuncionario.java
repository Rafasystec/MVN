package br.com.barcadero.rule;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.barcadero.dao.DaoFuncionario;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Funcionario;
import br.com.barcadero.tables.Loja;

@Service
public class RuleFuncionario extends RuleModelo<Funcionario> {

	private DaoFuncionario dao;
	@Autowired
	public RuleFuncionario(DaoFuncionario dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
//	public RuleFuncionario(Empresa empresa, Loja loja, Session session) {
//		super(empresa, loja, session);
//		this.dao = new DaoFuncionario(empresa, loja, session);
//	}
//
//	@Override
//	public String insert(Entidade entidade) throws Exception {
//		// TODO Auto-generated method stub
//		return dao.insert(entidade);
//	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return dao.delete(codigo);
	}

//	@Override
//	public String update(Entidade entidade) throws Exception {
//		// TODO Auto-generated method stub
//		return dao.update(entidade);
//	}

	@Override
	public Funcionario find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return dao.find(codigo);
	}

	@Override
	public List<Funcionario> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Funcionario insert(Funcionario entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Funcionario update(Funcionario entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
