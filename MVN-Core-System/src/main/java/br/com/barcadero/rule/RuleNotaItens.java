package br.com.barcadero.rule;

import java.util.ArrayList;
import org.hibernate.Session;

import br.com.barcadero.core.enums.EnumCompeTotalNota;
import br.com.barcadero.core.enums.EnumItemCancelado;
import br.com.barcadero.dao.DaoProduto;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Nota;
import br.com.barcadero.tables.NotaItens;
import br.com.barcadero.tables.Produto;

/**
 * Classe para manipular os itens da nota.
 * @author Rafael Rocha
 * @since versao 1.0 dia 23/02/2016 as 20:13
 */
public class RuleNotaItens extends RuleModelo {

	private DaoProduto daoProduto; 
	private RuleNota ruleNota;
	public RuleNotaItens(Session session) {
		// TODO Auto-generated constructor stub
		super(session);
		daoProduto  = new DaoProduto(session);
		ruleNota	= new RuleNota(session);
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return "Metodo nao implementado";
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entidade find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Obtem um item baseado em um produto passando o codigo do mesmo.
	 * @param codProduto : codigo do produto;
	 * @param nota : nota que o item pertence
	 * @return
	 * @throws Exception
	 */
	public NotaItens getItemFromProduto(long codProduto, Nota nota) throws Exception {
		 Produto produto = (Produto) daoProduto.find(codProduto);
		 NotaItens item;
		 if(produto != null){
			 item = new NotaItens(nota.getLoja(),nota.getUsuario());
			 item.setCdProd(produto.getCdProd());
			 item.setCodProduto(produto.getCodigo());
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
	
	/**
	 * Inserir item em uma nota a partir do codigo de um produto
	 * @param codProduto
	 * @param nota
	 * @param item
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public String saveItemNotaFromProduto(long codProduto, Nota nota, NotaItens pItem) throws Exception {
		ArrayList<NotaItens> itens = new ArrayList<NotaItens>();
		NotaItens item = getItemFromProduto(codProduto, nota);
		item.setFlCompoeTotNota(EnumCompeTotalNota.S);
		item.setQuantidade(pItem.getQuantidade());
		itens.add(item);
		nota.setItens(itens);
		return ruleNota.insert(nota);
	}
	/**
	 * Inserir item em uma nota a partir do codigo de um produto
	 * @param nota
	 * @param pItem
	 * @return
	 * @throws Exception
	 */
	public NotaItens saveItemNotaFromProduto(Nota nota, NotaItens pItem) throws Exception {
		ArrayList<NotaItens> itens = new ArrayList<NotaItens>();
		NotaItens item = getItemFromProduto(pItem.getCodProduto(), nota);
		item.setFlCompoeTotNota(EnumCompeTotalNota.S);
		item.setQuantidade(pItem.getQuantidade());
		itens.add(item);
		nota.setItens(itens);
		System.out.println("Salvar item na nota: >>> " + ruleNota.insert(nota));
		return item;
	}

}
