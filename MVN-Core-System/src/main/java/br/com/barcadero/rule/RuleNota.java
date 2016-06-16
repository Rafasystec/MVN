package br.com.barcadero.rule;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.core.enums.EnumNaturezaOperacao;
import br.com.barcadero.core.enums.EnumNotaFaturada;
import br.com.barcadero.core.exeptions.DAOException;
import br.com.barcadero.dao.DaoMeioPgto;
import br.com.barcadero.dao.DaoNota;
import br.com.barcadero.dao.DaoNotaItens;
import br.com.barcadero.tables.Caixa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.MeiosPagamento;
import br.com.barcadero.tables.Nota;
import br.com.barcadero.tables.NotaItens;
import br.com.barcadero.tables.NotaMeioPgto;
import br.com.barcadero.tables.Usuario;


public class RuleNota extends RuleModelo {

	private final DaoNota daoNota;
	private final DaoMeioPgto daoMeio;
	private final DaoNotaItens daoItens;
	private final RuleCaixa ruleCaixa;
	public RuleNota(Session session) {
		super(session);
		daoNota = new DaoNota(session);
		daoMeio = new DaoMeioPgto(session);
		daoItens= new DaoNotaItens(session);
		ruleCaixa= new RuleCaixa(session); 
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoNota.insert(entidade);
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoNota.delete(codigo);
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoNota.update(entidade);
	}

	@Override
	public Entidade find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return (Nota)daoNota.find(codigo);
	}
	
	public Nota findNota(long codigo) throws Exception {
		return daoNota.findNota(codigo);
	}
	
	public void inserirMeioPgtoNota(long codNota, NotaMeioPgto meio) throws Exception {
		if(meio == null){
			throw new DAOException(new Exception("O meio de pagamento da nota veio com valor nulo"));
		}
		Nota nota = findNota(codNota); 
		if(nota != null){
			MeiosPagamento meioPgto = (MeiosPagamento) daoMeio.find(meio.getCodMeioPgto());
			if(meioPgto == null){
				throw new DAOException(new Exception("Erro ao tentar salvar o meio de pagmento da "
						+ "Nota. Nenhum meio_pagamento encontrado para o codigo " + meio.getCodMeioPgto()));
			}
			meio.setNota(nota);
			meio.setSerieNota(nota.getSerieNota());
			meio.setMeioPagamento(meioPgto);
			daoNota.insert(meio);
		}
	}
	
	/**
	 * Inserir um item passando a nota.
	 * @param nota
	 * @param item
	 * @throws Exception
	 */
	public void inserirItem(Nota nota,NotaItens item)throws Exception {
		System.out.println("Insert item was called.");
		if(nota != null && item != null){
			System.out.println("Item insert message >> " + daoItens.insert(item)); 
		}else{
			if(nota == null){
				throw new Exception("Nota veio nulo. Impossivel adicionar o item");
			}else{
				throw new Exception("Erro ao tentar iserir o item na nota. Impossivel adicionar o item");
			}
		}
	}
	
	/**
	 * Inserir um item dando a nota
	 * @param codeNota
	 * @param item
	 * @throws Exception
	 */
	public void inserirItem(long codeNota,NotaItens item)throws Exception {
		Nota nota = findNota(codeNota); 
		if(nota != null){
			item.setNota(nota);
			System.out.println("Item insert message >> " + daoItens.insert(item));
		}else{
			throw new Exception("Nao foi possivel encontrar a nota de numero >> " + codeNota);
		}
	}
	
	public List<NotaItens> getItensByCodeNota(long codNota) {
		return daoNota.getItensByCodeNota(codNota);
	}
	
	/**
	 * Cria uma nota
	 * @param loja
	 * @param usuario
	 * @return
	 * @throws Exception 
	 */
	public Nota createNota(Loja loja, Usuario usuario, String ip) throws Exception {
		Caixa caixa = ruleCaixa.findByIp(loja.getCodigo(), ip);
		Nota nota = new Nota(loja, usuario);
		nota.setFlFaturado(EnumNotaFaturada.NAO);
		nota.setInfAdicionais("SOMENTE PARA HOMOLOGACAO");
		nota.setNaturezaOperacao(EnumNaturezaOperacao.SAIDA);
		nota.setSerieNota(getSerieNota());
		nota.setTpImpostoIcms("");
		nota.setModelo(caixa.getTipoNota());
		nota.setVlTotTributos(new BigDecimal(0));
		nota.setCaixa(caixa);
		return nota;
	}
	
	/**
	 * Gera a serie da nota
	 * @return
	 */
	public String getSerieNota() {
		return "01S"; //Por valor provisorio
	}

}
