package br.com.barcadero.rule;

import java.util.List;
import org.hibernate.Session;
import br.com.barcadero.dao.DaoEstoque;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Estoque;
import br.com.barcadero.tables.Loja;

public class RuleEstoque extends RuleModelo<Estoque> {

	private DaoEstoque daoEstoque;
	public RuleEstoque(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		daoEstoque = new DaoEstoque(empresa, loja, session);
	}

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

}
