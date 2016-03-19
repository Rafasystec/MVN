package br.com.barcadero.rule.backoffice;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.barcadero.dao.backoffice.DaoProduto;
import br.com.systeconline.rule.RuleModelo;
import br.com.systeconline.tables.backoffice.Produto;
import br.com.systeconline.tables.basicos.Entidade;

public class RuleProduto extends RuleModelo {

	private final DaoProduto daoProduto;
	public RuleProduto(Session session) {
		super(session);
		daoProduto = new DaoProduto(session);
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
	public Entidade find(long codigo) throws Exception {
		return daoProduto.find(codigo);
	}
	
	public List<Produto> findByDataCadastro(Date date) throws Exception {
		return daoProduto.findByDataCadastro(date);
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> findAll() {
		Query qry = getSession().getNamedQuery(Produto.FIND_ALL);
		return (List<Produto>)qry.list();
	}
	

}
