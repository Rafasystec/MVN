package br.com.barcadero.rule;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.core.enums.EnumItemCancelado;
import br.com.barcadero.dao.DaoNotaItens;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Nota;
import br.com.barcadero.tables.NotaItens;
import br.com.barcadero.tables.Produto;

/**
 * Classe para manipular os itens da nota.
 * @author Rafael Rocha
 * @since versao 1.0 dia 23/02/2016 as 20:13
 */
public class RuleNotaItens extends RuleModelo<NotaItens> {
 
	//private RuleNota ruleNota;
	private DaoNotaItens daoNotaItens;
	private RuleProduto ruleProduto;
	
	public RuleNotaItens(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		ruleProduto = new RuleProduto(empresa, loja, session);
		//ruleNota	= new RuleNota(empresa, loja, session);
		daoNotaItens= new DaoNotaItens(empresa, loja, session);
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		if(entidade instanceof NotaItens){
			NotaItens itens = (NotaItens) entidade;
			Produto produto = itens.getProduto();
			itens.setVlTotal(itens.getQuantidade().multiply(ruleProduto.getPreco(produto)));
			return daoNotaItens.insert(itens);
		}else{
			throw new Exception("Entidade passada como parametro não é do tipo:");
		}
		
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoNotaItens.delete(codigo);
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoNotaItens.update(entidade);
	}

	@Override
	public NotaItens find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoNotaItens.find(codigo);
	}
	
	/**
	 * Obtem um item baseado em um produto passando o codigo do mesmo.
	 * @param codProduto : codigo do produto;
	 * @param nota : nota que o item pertence
	 * @return
	 * @throws Exception
	 */
	public NotaItens getItemFromProduto(long codProduto, Nota nota) throws Exception {
		 Produto produto = (Produto) ruleProduto.find(codProduto);
		 NotaItens item;
		 if(produto != null){
			 item = new NotaItens(nota.getLoja(),nota.getUsuario());
			 item.setCdProd(produto.getCdProd());
			 item.setDescricao(produto.getDescricao());
			 item.setFlCancelado(EnumItemCancelado.N);
			 item.setNota(nota);
			 if(nota.getItens() == null){
				 item.setNrItem(1);
			 }else{
				 item.setNrItem(nota.getItens().size() + 1);
			 }
			 item.setSerieNota(nota.getSerieNota());
			 //NOTE: Depois por a logica para ver se o produto esta em promocao
			 item.setVlTotal(produto.getPrecoVenda());
			 item.setVlUnidade(produto.getPrecoVenda());
		 }else {
			 throw new Exception("Nao foi encontrado produto com o codigo >> " + codProduto);
		 }
		 return item;
	}
	
//	/**
//	 * Inserir item em uma nota a partir do codigo de um produto
//	 * @param codProduto
//	 * @param nota
//	 * @param item
//	 * @return
//	 * @throws Exception
//	 */
//	@Deprecated
//	public String saveItemNotaFromProduto(long codProduto, Nota nota, NotaItens pItem) throws Exception {
//		ArrayList<NotaItens> itens = new ArrayList<NotaItens>();
//		NotaItens item = getItemFromProduto(codProduto, nota);
//		item.setFlCompoeTotNota(EnumCompeTotalNota.S);
//		item.setQuantidade(pItem.getQuantidade());
//		itens.add(item);
//		nota.setItens(itens);
//		return ruleNota.insert(nota);
//	}
//	/**
//	 * Inserir item em uma nota a partir do codigo de um produto
//	 * @param nota
//	 * @param pItem
//	 * @return
//	 * @throws Exception
//	 */
//	@Deprecated
//	public NotaItens saveItemNotaFromProduto(Nota nota, NotaItens pItem) throws Exception {
//		ArrayList<NotaItens> itens = new ArrayList<NotaItens>();
//		NotaItens item = getItemFromProduto(0, nota);
//		item.setFlCompoeTotNota(EnumCompeTotalNota.S);
//		item.setQuantidade(pItem.getQuantidade());
//		itens.add(item);
//		nota.setItens(itens);
//		System.out.println("Salvar item na nota: >>> " + ruleNota.insert(nota));
//		return item;
//	}

	@Override
	public List<NotaItens> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
