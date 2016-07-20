package br.com.barcadero.rule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import br.com.barcadero.core.enums.EnumModeloNota;
import br.com.barcadero.core.enums.EnumNaturezaOperacao;
import br.com.barcadero.core.enums.EnumNotaFaturada;
import br.com.barcadero.core.exeptions.DAOException;
import br.com.barcadero.dao.DaoMeioPgto;
import br.com.barcadero.dao.DaoNota;
import br.com.barcadero.tables.Caixa;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.MeiosPagamento;
import br.com.barcadero.tables.Nota;
import br.com.barcadero.tables.NotaItens;
import br.com.barcadero.tables.NotaMeioPgto;
import br.com.barcadero.tables.Pedido;
import br.com.barcadero.tables.PedidoItens;
import br.com.barcadero.tables.Usuario;


public class RuleNota extends RuleModelo<Nota> {

	private final DaoNota daoNota;
	private final DaoMeioPgto daoMeio;
	//private final DaoNotaItens daoItens;
	private final RuleNotaItens ruleNotaItens;
	private final RuleCaixa ruleCaixa;

	public RuleNota(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		daoNota = new DaoNota(empresa, loja, session);
		daoMeio = new DaoMeioPgto(empresa, loja, session);
		//daoItens= new DaoNotaItens(empresa, loja, session);
		ruleCaixa= new RuleCaixa(empresa, loja, session);
		ruleNotaItens = new RuleNotaItens(empresa, loja, session);
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
	public Nota find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return (Nota)daoNota.find(codigo);
	}
	
	public Nota findNota(long codigo) throws Exception {
		return daoNota.findNota(codigo);
	}
	/**
	 * Inserir meio de pagamento na Nota
	 * @param codNota
	 * @param meio
	 * @throws Exception
	 */
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
			getSession().save(nota);
			System.out.println("Item insert message >> " + ruleNotaItens.insert(item)); 
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
			System.out.println("Item insert message >> " + ruleNotaItens.insert(item));
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
		nota.setEmpresa(getEmpresa());
		return nota;
	}
	
	/**
	 * Gera a serie da nota
	 * @return
	 */
	public String getSerieNota() {
		return "01S"; //Por valor provisorio
	}

	@Override
	public List<Nota> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Transforma um pedido em uma nota para que o mesmo seja faturado.
	 * @param pedido
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public String parse(Pedido pedido, Usuario usuario) throws Exception{
		String result = "";
		if(pedido != null){
			Nota nota = new Nota(getLoja(), usuario);
			nota.setCaixa(pedido.getCaixa());
			nota.setEmpresa(getEmpresa());
			nota.setFlFaturado(EnumNotaFaturada.NAO);
			nota.setLoja(getLoja());
			nota.setInfAdicionais("NOTA GERADA A PARTIR DO PEDIDO " + pedido.getCodigo());
			nota.setModelo(pedido.getCaixa().getTipoNota());
			nota.setNaturezaOperacao(EnumNaturezaOperacao.SAIDA);
			nota.setNrPed(pedido.getCodigo());
			nota.setSerieNota(String.valueOf(getSerie(pedido.getCaixa())));
			//------------------------------------------
			//Montando a lista de itens para a nota
			//------------------------------------------
			insert(nota);
			List<NotaItens> itens = getItensNota(nota,pedido,usuario);
			for (NotaItens notaItens : itens) {
				ruleNotaItens.insert(notaItens);
			}
			
		}else{
			return "O Pedido está com o valor nulo.";
		}
		return result;
	}
	
	/**
	 * Obtem a serie da nota de acordo com o modelo de nota.
	 * @param caixa
	 * @return
	 */
	public long getSerie(Caixa caixa) {
		if(caixa.getTipoNota() == EnumModeloNota.MOD_65){
			//Para NFC-e a Serie sera o numero do caixa
			return caixa.getCdCaixa();
		}else if(caixa.getTipoNota() == EnumModeloNota.MOD_55){
			//Para NF-e a serie sera o codigo da loja
			return  getLoja().getCodigo();
		}else{
			return 0L;
		}
	}
	/**
	 * Transforma os itens de um pedido em uma nota.
	 * @param nota
	 * @param pedido
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public List<NotaItens> getItensNota(Nota nota, Pedido pedido, Usuario usuario) throws Exception{
		List<NotaItens> itens = new ArrayList<>();
		for (PedidoItens itemPed : pedido.getItens()) {
			NotaItens notaItens = new NotaItens(getEmpresa(), getLoja(), usuario);
			notaItens.setNota(nota);
			notaItens.setNrItem(itemPed.getNrItem());
		}
		return itens;
	}

}
