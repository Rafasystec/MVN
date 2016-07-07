package br.com.barcadero.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Produto;

public class DaoProduto extends DaoModelo <Produto>{

	public DaoProduto(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Produto find(long codigo) throws Exception {
		Query qry = getSession().getNamedQuery(Produto.FIND_BY_CODE);
		qry.setParameter("codigo", codigo);
		return (Produto)qry.uniqueResult();
	}

	@Override
	public List<Produto> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Produto> findByDataCadastro(Date date) throws Exception {
		Query qry = getSession().getNamedQuery(Produto.FIND_BY_DATE);
		qry.setParameter("date", date);
		return qry.list();
	}
	
	/**
	 * rocura o produto pelo codigo ou pela descricao
	 * @param codigoOrDesc
	 * @return
	 * @throws Exception
	 */
	public List<Produto> findByCodOrDesc(String codigoOrDesc) throws Exception{
		Query qry  = getSession().getNamedQuery(Produto.FIND_BY_COD_OR_DESC);
		long codigo = 0;
		try {
			codigo = Long.parseLong(codigoOrDesc);
		} catch (Exception e) {
			codigo = 0;
		}
		qry.setParameter("codigo"	, codigo);
		qry.setParameter("descricao", "%"+codigoOrDesc+"%");
		return qry.list();
	}

}
