package br.com.barcadero.rule;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.dao.DaoPedidoItens;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Pedido;
import br.com.barcadero.tables.PedidoItens;
import br.com.barcadero.tables.Produto;

public class RulePedidoItens extends RuleModelo<Pedido> {

	private DaoPedidoItens daoPedidoItens;
	private RuleProduto ruleProduto;
	public RulePedidoItens(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		daoPedidoItens 	= new DaoPedidoItens(empresa, loja, session);
		//ruleProduto		= new RuleProduto(empresa, loja, session);
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoPedidoItens.insert(entidade);
	}
	/**
	 * Inserir um item no pedido
	 * @param pedido
	 * @param pedidoItens
	 * @return
	 * @throws Exception
	 */
	public String insert(Pedido pedido, PedidoItens pedidoItens) throws Exception {
		// TODO Auto-generated method stub
		if(pedido != null){
			try{
				getSession().save(pedido);
			}catch(Exception e){
				throw e;
			}
			Produto produto = pedidoItens.getProduto();
			BigDecimal vlUnitario = ruleProduto.getPreco(produto);
			pedidoItens.setVlUnitario(vlUnitario);
			pedidoItens.setVlTotal(vlUnitario.multiply(new BigDecimal(pedidoItens.getQuantidade())));
			pedidoItens.setPedido(pedido);
			return daoPedidoItens.insert(pedidoItens);
		}else{
			throw new Exception("Pedido não foi criado.");
		}
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
	public Pedido find(long codigo) throws Exception {
		return null;
	}

	@Override
	public List<Pedido> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 
	 * @param pedido
	 * @return
	 */
	public List<PedidoItens> findByPedido(Pedido pedido) {
		return daoPedidoItens.findByPedido(pedido);
	}

}
