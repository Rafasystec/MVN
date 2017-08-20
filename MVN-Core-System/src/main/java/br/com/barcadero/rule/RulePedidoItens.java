package br.com.barcadero.rule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.dao.DaoPedido;
import br.com.barcadero.dao.DaoPedidoItens;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Pedido;
import br.com.barcadero.tables.PedidoItens;
import br.com.barcadero.tables.Produto;

@Service
public class RulePedidoItens extends RuleModelo<Pedido> {

	@Autowired
	private DaoPedidoItens daoPedidoItens;
	@Autowired
	private RuleProduto ruleProduto;
	@Autowired
	private DaoPedido daoPedido;
	
//	@Autowired
//	public RulePedidoItens(DaoPedidoItens daoPedidoItens,RuleProduto ruleProduto,DaoPedido daoPedido) {
//		// TODO Auto-generated constructor stub
//		this.daoPedidoItens = daoPedidoItens;
//		this.daoPedido		= daoPedido;
//		this.ruleProduto	= ruleProduto;
//	}
//
//	@Override
//	public String insert(Entidade entidade) throws Exception {
//		// TODO Auto-generated method stub
//		return daoPedidoItens.insert(entidade);
//	}
//	/**
//	 * Inserir um item no pedido
//	 * @param pedido
//	 * @param pedidoItens
//	 * @return
//	 * @throws Exception
//	 */
	public PedidoItens insert(Pedido pedido, PedidoItens pedidoItens) throws Exception {
		// TODO Auto-generated method stub
		if(pedido != null){
			try{
				//getSession().save(pedido);
				daoPedido.insert(pedido);
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
		if(pedido != null && pedido.getCodigo() > 0){
			return daoPedidoItens.findByPedido(pedido);
		}else{
			return new ArrayList<>();
		}
	}

	@Override
	public List<Pedido> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public DaoPedidoItens getDaoPedidoItens() {
		return daoPedidoItens;
	}

	public void setDaoPedidoItens(DaoPedidoItens daoPedidoItens) {
		this.daoPedidoItens = daoPedidoItens;
	}

	public RuleProduto getRuleProduto() {
		return ruleProduto;
	}

	public void setRuleProduto(RuleProduto ruleProduto) {
		this.ruleProduto = ruleProduto;
	}

	public DaoPedido getDaoPedido() {
		return daoPedido;
	}

	public void setDaoPedido(DaoPedido daoPedido) {
		this.daoPedido = daoPedido;
	}

	@Override
	public Pedido insert(Pedido entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Pedido update(Pedido entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
