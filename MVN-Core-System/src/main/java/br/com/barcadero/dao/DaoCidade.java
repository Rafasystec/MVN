package br.com.barcadero.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.barcadero.core.enums.EnumUF;
import br.com.barcadero.tables.Cidade;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Estado;
import br.com.barcadero.tables.Loja;

@Repository
public class DaoCidade extends DaoModelo<Cidade>{

	
	private DaoEstado daoEstado;
	
	@Autowired
	public DaoCidade(DaoEstado daoEstado) {
		this.daoEstado = daoEstado;
	}

	@Override
	public Cidade find(long codigo) throws Exception {
		return find(codigo, Cidade.class);
	}
	
//	@Override
//	public String insert(Entidade entidade) throws Exception {
//		if(entidade instanceof Cidade){
//			Cidade cidade = (Cidade)entidade;
//			for (Bairro bairro : cidade.getBairros()) {
//				super.insert(bairro);
//			}
//		}else{
//			throw new Exception("Entidade não é do Tipo :" + Cidade.class);
//		}
//		return super.insert(entidade);
//	}
	
	
	
	/**
	 * Obter as cidades por UF
	 * @param uf
	 * @return
	 * @throws Exception
	 */
	public List<Cidade> getCidadesByUF(EnumUF uf) throws Exception{
		List<Cidade> cidades	= null;
		Query qry				= null;
		try {
			//qry	= getSession().getNamedQuery(Cidade.FIND_BY_UF);
			qry = manager.createNamedQuery(Cidade.FIND_BY_UF)
						 .setParameter("uf", String.valueOf(uf));
			cidades	= qry.getResultList();
			return cidades;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Cidade> getCidadeByEstado(Estado estado) {
		TypedQuery<Cidade> qry = manager.createNamedQuery(Cidade.FIND_BY_ESTADO, Cidade.class)
				.setParameter("estado", estado);
		return qry.getResultList();
	}
	/**
	 * 
	 * @param descricao
	 * @param uf
	 * @return
	 * @throws Exception
	 */
	public Cidade findByDescricaoEUF(String descricao, EnumUF uf) throws Exception{
		Query qry				= null;
		try {
			//qry	= getSession().getNamedQuery(Cidade.FIND_BY_DESC_AND_UF);
			qry = manager.createNamedQuery(Cidade.FIND_BY_DESC_AND_UF);
			qry.setParameter("uf", String.valueOf(uf));
			qry.setParameter("descricao", descricao);
			return (Cidade) qry.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
	
	/*
	------------------------------------------------------------------------------------------------
	Para diminuir a chance de erro, podemos utilizar as Typed Queries. Nesse tipo de consulta, o
	compilador também não verifica o código JPQL. No entanto, devemos especificar o tipo de resul-
	tado esperado para que o compilador verifique o restante do código e garanta que a utilização do
	resultado da consulta seja compatível com o tipo especificado.
	------------------------------------------------------------------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public List<Cidade> getCidades() throws Exception{
		List<Cidade> cidades	= null;
		TypedQuery<Cidade> qry	= null;
		try {
			//qry		= (TypedQuery<Cidade>) getSession().getNamedQuery("Cidade.findAll");
			qry = (TypedQuery<Cidade>) manager.createNamedQuery(Cidade.FIND_ALL);
			cidades	= qry.getResultList();
			return cidades;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Cidade> findAll() throws Exception{
		List<Cidade> cidades	= null;
		Query qry	= null;
		try {
			//qry		= getSession().getNamedQuery("Cidade.findAll");
			qry	= manager.createNamedQuery(Cidade.FIND_ALL);
			cidades	= qry.getResultList();
			return cidades;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * Carrega as cidades cadastradas hoje
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Entidade> findAllCadToday() throws Exception{
		//Query qry = getSession().getNamedQuery(Cidade.FIND_BY_DT_CADASTRO);
		Query qry = manager.createNamedQuery(Cidade.FIND_BY_DT_CADASTRO);
		qry.setParameter("dtCadastro", new Date());
		return qry.getResultList();
	}
	
	/**
	 * Encontra as cidades pela data de cadastro.
	 * @param date
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Entidade> findAllByDtCadastro(Date date) throws Exception{
		//Query qry = getSession().getNamedQuery(Cidade.FIND_BY_DT_CADASTRO);
		Query qry = manager.createNamedQuery(Cidade.FIND_BY_DT_CADASTRO);
		qry.setParameter("dtCadastro", date);
		return qry.getResultList();
	}
	
	/**
	 * Exclui todas as cidades de um estado passando o codigo do IBGE do Estado
	 * @param codeIBGEEstado: codigo IBGE do Estado
	 * @return
	 */
	public int deleteCidadesByEstado(String codeIBGEEstado) {
		Estado estado = daoEstado.findByCodeIBGE(codeIBGEEstado); 
		if(estado != null){
			String query = "DELETE FROM Cidade WHERE uf = :uf";
			//Query qry = getSession().createQuery(query).setParameter("uf", String.valueOf(estado.getUf())) ;
			Query qry = manager.createQuery(query).setParameter("uf", String.valueOf(estado.getUf()));
			//System.out.println("Executando query: " + qry.getQueryString());
			int rows = qry.executeUpdate();
			System.out.println("Quantidade de registros afetados: " + rows);
			return rows;
		}else{
			System.out.println("Nenhum Estado encontrado com o codigo IBGE igual a " + codeIBGEEstado);
			return 0;
		}
	}

	@Override
	public List<Cidade> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cidade> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
