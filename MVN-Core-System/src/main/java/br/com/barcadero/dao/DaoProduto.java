package br.com.barcadero.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.barcadero.core.util.GlobalNameParam;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Produto;

@Repository
public class DaoProduto extends DaoModelo <Produto>{

	public DaoProduto() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Produto find(long codigo) throws Exception {
		Query qry = manager.createNamedQuery(Produto.FIND_BY_CODE);
		qry.setParameter("codigo", codigo);
		return (Produto)qry.getSingleResult();
	}

	@Override
	public List<Produto> findAll() throws Exception {
		javax.persistence.Query qry = manager.createNamedQuery(Produto.FIND_ALL);
		return qry.getResultList();
	}
	
	public List<Produto> findByDataCadastro(Date date) throws Exception {
		javax.persistence.Query qry = manager.createNamedQuery(Produto.FIND_BY_DATE);
		qry.setParameter("date", date);
		return qry.getResultList();
	}
	
	/**
	 * rocura o produto pelo codigo ou pela descricao
	 * @param codigoOrDesc
	 * @return
	 * @throws Exception
	 */
	public List<Produto> findByCodOrDesc(Empresa empresa,String codigoOrDesc) throws Exception{
		TypedQuery<Produto> qry  = manager.createNamedQuery(Produto.FIND_BY_COD_OR_DESC,Produto.class);
		long codigo = 0;
		try {
			codigo = Long.parseLong(codigoOrDesc);
		} catch (Exception e) {
			codigo = 0;
		}
		qry.setParameter("codigo"	, codigo);
		qry.setParameter("descricao", "%"+codigoOrDesc+"%");
		qry.setParameter(GlobalNameParam.PARAM_COD_EMP, empresa);
		return qry.getResultList();
	}

	@Override
	public List<Produto> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
