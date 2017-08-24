package br.com.barcadero.rule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.barcadero.core.enums.EnumCompeTotalNota;
import br.com.barcadero.core.enums.EnumModeloNota;
import br.com.barcadero.core.enums.EnumNaturezaOperacao;
import br.com.barcadero.core.enums.EnumNotaFaturada;
import br.com.barcadero.core.enums.EnumStatusOrdemServico;
import br.com.barcadero.core.enums.EnumStatusPedido;
import br.com.barcadero.core.enums.EnumTipoMeioPgto;
import br.com.barcadero.core.util.FormasPagamento;
import br.com.barcadero.dao.DaoNota;
import br.com.barcadero.dao.DaoOrdemServico;
import br.com.barcadero.dao.DaoPedido;
import br.com.barcadero.tables.Caixa;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Nota;
import br.com.barcadero.tables.NotaItens;
import br.com.barcadero.tables.NotaMeioPgto;
import br.com.barcadero.tables.OrdemServico;
import br.com.barcadero.tables.OrdemServicoItens;
import br.com.barcadero.tables.Pedido;
import br.com.barcadero.tables.PedidoItens;
import br.com.barcadero.tables.Produto;
import br.com.barcadero.tables.Usuario;

@Service
public class RuleNota extends RuleModelo<Nota> {

	@Autowired
	private DaoNota daoNota;
//	@Autowired
//	private DaoMeioPgto daoMeio;
	@Autowired
	private DaoPedido daoPedido;
	@Autowired
	private DaoOrdemServico daoOrdemServico;
	@Autowired
	private RuleNotaItens ruleNotaItens;
	@Autowired
	private RuleCaixa ruleCaixa;
	
	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoNota.delete(codigo);
	}

	@Override
	public Nota find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return (Nota)daoNota.find(codigo);
	}
	
	public Nota findNota(long codigo) throws Exception {
		return daoNota.findNota(codigo);
	}
//	/**
//	 * Inserir meio de pagamento na Nota
//	 * @param codNota
//	 * @param meio
//	 * @throws Exception
//	 */
//	public void inserirMeioPgtoNota(long codNota, NotaMeioPgto meio) throws Exception {
//		if(meio == null){
//			throw new DAOException(new Exception("O meio de pagamento da nota veio com valor nulo"));
//		}
//		Nota nota = findNota(codNota); 
//		if(nota != null){
//			MeiosPagamento meioPgto = (MeiosPagamento) daoMeio.find(meio.getCodMeioPgto());
//			if(meioPgto == null){
//				throw new DAOException(new Exception("Erro ao tentar salvar o meio de pagmento da "
//						+ "Nota. Nenhum meio_pagamento encontrado para o codigo " + meio.getCodMeioPgto()));
//			}
//			meio.setNota(nota);
//			meio.setSerieNota(nota.getSerieNota());
//			meio.setMeioPagamento(meioPgto);
//			daoNota.insert(meio);
//		}
//	}
	
	/**
	 * Inserir um item passando a nota.
	 * @param nota
	 * @param item
	 * @throws Exception
	 */
	public void inserirItem(Nota nota,NotaItens item)throws Exception {
		System.out.println("Insert item was called.");
		if(nota != null && item != null){
			//getSession().save(nota);
			daoNota.insert(nota);
			System.out.println("Item insert message >> " + ruleNotaItens.insert(item)); 
		}else{
			if(nota == null){
				throw new Exception("Nota veio nulo. Impossivel adicionar o item");
			}else{
				throw new Exception("Erro ao tentar iserir o item na nota. Impossivel adicionar o item");
			}
		}
	}
	
	public void inserirItem(Nota nota,NotaItens item, Produto produto)throws Exception {
		if(nota != null && item != null){
			//getSession().save(nota);
			daoNota.insert(nota);
			item.setProduto(produto);
			System.out.println("Item insert message >> " + ruleNotaItens.insert(item)); 
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
		Caixa caixa = ruleCaixa.findByIp(loja, ip);
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
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public Nota parse(Caixa caixa,Pedido pedido, Usuario usuario, FormasPagamento formasPagamento) throws Exception{
		Nota result = null;
		try{
			if(pedido != null){
				Nota nota = new Nota(pedido.getLoja(), usuario);
				nota.setCaixa(caixa);
				nota.setEmpresa(pedido.getEmpresa());
				nota.setFlFaturado(EnumNotaFaturada.NAO);
				nota.setLoja(pedido.getLoja());
				nota.setInfAdicionais("NOTA GERADA A PARTIR DO PEDIDO " + pedido.getCodigo());
				nota.setModelo(caixa.getTipoNota());
				nota.setNaturezaOperacao(EnumNaturezaOperacao.SAIDA);
				nota.setSerieNota(String.valueOf(getSerie(caixa)));
				//------------------------------------------
				//Montando a lista de itens para a nota
				//------------------------------------------
				List<NotaItens> itens = getItensNota(nota,pedido,usuario);
				//------------------------------------------
				//Inserir as formas de pagamento
				//------------------------------------------
				 nota.setMeiosPgto(getMeiosPagamento(nota, formasPagamento, usuario));
				 nota.setItens(itens);
				 nota.setFlFaturado(EnumNotaFaturada.SIM);
				 nota = insert(nota);
				 pedido.setFlStPed(EnumStatusPedido.FATURADO);
				 daoPedido.update(pedido);
				 result = nota;
			}
		}catch(Exception e){
			throw new Exception("Erro ao transformar o pedido " + pedido.getCodigo() + " em uma Nota.");
		}
		return result;
	}
	/**
	 * Transforma uma ordem de servico em nota
	 * @param ordemServico
	 * @param usuario
	 * @param formasPagamento
	 * @return
	 * @throws Exception
	 */
	public Nota parse(Caixa caixa, OrdemServico ordemServico, Usuario usuario, FormasPagamento formasPagamento) throws Exception{
		Nota result = null;
		try {
			if(ordemServico != null){
				Nota nota = new Nota(getLoja(), usuario);
				nota.setCaixa(caixa);
				nota.setEmpresa(getEmpresa());
				nota.setFlFaturado(EnumNotaFaturada.NAO);
				nota.setLoja(ordemServico.getLoja());
				nota.setInfAdicionais("NOTA GERADA A PARTIR DO PEDIDO " + ordemServico.getCodigo());
				nota.setModelo(caixa.getTipoNota());
				nota.setNaturezaOperacao(EnumNaturezaOperacao.SAIDA);
				nota.setSerieNota(String.valueOf(getSerie(caixa)));
				//------------------------------------------
				//Montando a lista de itens para a nota
				//------------------------------------------
				List<NotaItens> itens = getItensNota(nota,ordemServico,usuario);
				//------------------------------------------
				//Inserir as formas de pagamento
				//------------------------------------------
				 nota.setMeiosPgto(getMeiosPagamento(nota, formasPagamento, usuario));
				 nota.setItens(itens);
				 nota.setFlFaturado(EnumNotaFaturada.SIM);
				 insert(nota);
				 ordemServico.setStatus(EnumStatusOrdemServico.FATURADA);
				 daoOrdemServico.update(ordemServico);
				 result = nota;
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Erro ao tentar converter Ordem de Serviço em Nota: " + e.getMessage());
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
			notaItens.setProduto(itemPed.getProduto());
			notaItens.setDescricao(itemPed.getProduto().getDescricao());
			notaItens.setFlCompoeTotNota(EnumCompeTotalNota.S);
			notaItens.setLoja(getLoja());
			notaItens.setPcDesc(itemPed.getPcDesconto());
			notaItens.setQuantidade(itemPed.getQuantidade());
			notaItens.setSerieNota(nota.getSerieNota());
			notaItens.setUsuario(usuario);
			notaItens.setVlDesc(itemPed.getVlDesconto());
			notaItens.setVlTotal(itemPed.getVlTotal());
			notaItens.setVlUnidade(itemPed.getVlUnitario());
			itens.add(notaItens);
		}
		return itens;
	}
	/**
	 * Transforma os itens da O.S em itens de uma nota.
	 * @param nota
	 * @param ordemServico
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public List<NotaItens> getItensNota(Nota nota, OrdemServico ordemServico, Usuario usuario) throws Exception{
		List<NotaItens> itens = new ArrayList<>();
		for (OrdemServicoItens itemOS : ordemServico.getItens()) {
			NotaItens notaItens = new NotaItens(getEmpresa(), getLoja(), usuario);
			notaItens.setNota(nota);
			notaItens.setNrItem(itemOS.getNrItem());
			notaItens.setProduto(itemOS.getProduto());
			notaItens.setDescricao(itemOS.getProduto().getDescricao());
			notaItens.setFlCompoeTotNota(EnumCompeTotalNota.S);
			notaItens.setLoja(getLoja());
			//notaItens.setPcDesc(itemPed.getPcDesconto());
			notaItens.setQuantidade(itemOS.getQuantidade());
			notaItens.setSerieNota(nota.getSerieNota());
			notaItens.setUsuario(usuario);
			//notaItens.setVlDesc(itemOS.getVlDesconto());
			notaItens.setVlTotal(itemOS.getValorTotal());
			notaItens.setVlUnidade(itemOS.getValorUnitario());
			itens.add(notaItens);
		}
		return itens;
	}
	
	public List<NotaMeioPgto> getMeiosPagamento(Nota nota, FormasPagamento formasPagamento, Usuario usuario) {
		 List<NotaMeioPgto> meioPgtos = new ArrayList<>();
		 if(formasPagamento.getVlTEF().floatValue()  > 0.00f){
			 NotaMeioPgto meioPgto = new NotaMeioPgto(nota.getEmpresa(), nota.getLoja(), usuario);
			 meioPgto.setNota(nota);
			 meioPgto.setCdAdministradora(999);
			 meioPgto.setEmpresa(getEmpresa());
			 //meioPgto.setMeioPagamento(EnumTipoMeioPgto.TEF);
			 meioPgto.setQtParcelas(0);
			 meioPgto.setSerieNota(nota.getSerieNota());
			 meioPgto.setTipoMeioPgto(EnumTipoMeioPgto.TEF); 
			 meioPgto.setValor(formasPagamento.getVlTEF());
			 meioPgtos.add(meioPgto);
		 }
		 if(formasPagamento.getVlCheque().floatValue() > 0.00f){
			 NotaMeioPgto meioPgto = new NotaMeioPgto(nota.getEmpresa(), nota.getLoja(), usuario);
			 meioPgto.setNota(nota);
			 meioPgto.setCdAdministradora(0);
			 meioPgto.setEmpresa(getEmpresa());
			 //meioPgto.setMeioPagamento(EnumTipoMeioPgto.TEF);
			 meioPgto.setQtParcelas(0);
			 meioPgto.setSerieNota(nota.getSerieNota());
			 meioPgto.setTipoMeioPgto(EnumTipoMeioPgto.CHEQUE);
			 meioPgto.setValor(formasPagamento.getVlCheque());
			 meioPgtos.add(meioPgto);
		 }
		 if(formasPagamento.getVlDinheiro().floatValue() > 0.00f){
			 NotaMeioPgto meioPgto = new NotaMeioPgto(nota.getEmpresa(), nota.getLoja(), usuario);
			 meioPgto.setNota(nota);
			 meioPgto.setCdAdministradora(0);
			 meioPgto.setEmpresa(getEmpresa());
			 //meioPgto.setMeioPagamento(EnumTipoMeioPgto.TEF);
			 meioPgto.setQtParcelas(0);
			 meioPgto.setSerieNota(nota.getSerieNota());
			 meioPgto.setTipoMeioPgto(EnumTipoMeioPgto.DINHEIRO);
			 meioPgto.setValor(formasPagamento.getVlDinheiro());
			 meioPgtos.add(meioPgto);
		 }
		 return meioPgtos;
	}

	@Override
	public List<Nota> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Nota> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Nota insert(Nota nota) throws Exception {
		return daoNota.insert(nota);
	}

	@Override
	public Nota update(Nota nota) throws Exception {
		return daoNota.update(nota);
	}

}
