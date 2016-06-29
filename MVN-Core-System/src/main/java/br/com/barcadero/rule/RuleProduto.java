package br.com.barcadero.rule;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.barcadero.dao.DaoProduto;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Produto;


public class RuleProduto extends RuleModelo<Produto> {

	private final DaoProduto daoProduto;
	public RuleProduto(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		daoProduto = new DaoProduto(empresa, loja, session);
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoProduto.insert(entidade);
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoProduto.delete(codigo);
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoProduto.update(entidade);
	}

	@Override
	public Produto find(long codigo) throws Exception {
		return daoProduto.find(codigo);
	}
	
	public List<Produto> findByDataCadastro(Date date) throws Exception {
		return daoProduto.findByDataCadastro(date);
	}
	
	public List<Produto> findAll() {
		Query qry = getSession().getNamedQuery(Produto.FIND_ALL);
		return (List<Produto>)qry.list();
	}
	

}
