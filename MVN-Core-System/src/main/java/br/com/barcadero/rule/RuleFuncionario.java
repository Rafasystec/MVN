package br.com.barcadero.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.dao.DaoFuncionario;
import br.com.barcadero.tables.Empresa;
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
	

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return dao.delete(codigo);
	}

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
