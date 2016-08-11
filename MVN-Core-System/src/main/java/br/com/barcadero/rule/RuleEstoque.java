package br.com.barcadero.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.dao.DaoEstoque;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Estoque;
import br.com.barcadero.tables.Loja;
@Service
public class RuleEstoque extends RuleModelo<Estoque> {

	private DaoEstoque daoEstoque;
	@Autowired
	public RuleEstoque(DaoEstoque daoEstoque) {
		// TODO Auto-generated constructor stub
		this.daoEstoque = daoEstoque;
	}
	
//	public RuleEstoque(Empresa empresa, Loja loja, Session session) {
//		super(empresa, loja, session);
//		daoEstoque = new DaoEstoque(empresa, loja, session);
//	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		return daoEstoque.insert(entidade);
	}

	@Override
	public String delete(long codigo) throws Exception {
		return daoEstoque.delete(codigo);
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		return daoEstoque.update(entidade);
	}

	@Override
	public Estoque find(long codigo) throws Exception {
		return daoEstoque.find(codigo);
	}

	@Override
	public List<Estoque> findAll() throws Exception {
		return daoEstoque.findAll();
	}

	@Override
	public List<Estoque> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estoque> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
