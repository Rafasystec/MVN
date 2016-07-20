package br.com.barcadero.rule;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.core.enums.EnumStatusPedido;
import br.com.barcadero.core.util.FormasPagamento;
import br.com.barcadero.dao.DaoPedido;
import br.com.barcadero.tables.Caixa;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Pedido;
import br.com.barcadero.tables.PedidoItens;
import br.com.barcadero.tables.Usuario;

public class RulePedido extends RuleModelo<Pedido> {

	private RuleCaixa ruleCaixa;
	private DaoPedido daoPedido;
	private RuleNota ruleNota;
	public RulePedido(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		ruleCaixa = new RuleCaixa(empresa, loja, session);
		daoPedido = new DaoPedido(empresa, loja, session);
		ruleNota  = new RuleNota(empresa, loja, session);
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoPedido.insert(entidade);
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoPedido.delete(codigo);
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoPedido.update(entidade);
	}

	@Override
	public Pedido find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoPedido.find(codigo);
	}

	@Override
	public List<Pedido> findAll() throws Exception {
		// TODO Auto-generated method stub
		return daoPedido.findAll();
	}
	
	/**
	 * 
	 * @param usuario
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	public Pedido createPedido(Usuario usuario, String ip) throws Exception {
		Pedido pedido = new Pedido(getEmpresa(), getLoja(), usuario);
		Caixa caixa = ruleCaixa.findByIp(getLoja().getCodigo(), ip);
		pedido.setCaixa(caixa);
		return pedido;
	}
	
	/**
	 * 
	 * @param pedido
	 * @return
	 */
	public String fecharPedido(Pedido pedido) {
		try {
			if(pedido != null){
				pedido.setFlStPed(EnumStatusPedido.FECHADO);
				daoPedido.update(pedido);
				return "Pedido Fechado com sucesso!";
			}else{
				return "Nenhum pedido para ser FECHADO";
			}
		} catch (Exception e) {
			return e.getMessage();
		}	
	}
	
	public List<Pedido> findPedidosByDate(Date date) {
		List<Pedido> pedidos = daoPedido.findPedidosByDate(date);
		return totalizarTodosOsPedidos(pedidos);
	}
	
	public List<Pedido> findPedidosAFaturarHoje(Date date) {
		List<Pedido> pedidos = daoPedido.findPedidosAFaturarHoje(date);
		return totalizarTodosOsPedidos(pedidos);
	}
	
	public List<Pedido> findPedidosAFaturarHoje() {
		List<Pedido> pedidos = daoPedido.findPedidosAFaturarHoje();
		pedidos = totalizarTodosOsPedidos(pedidos);
		return pedidos;
	}
	
	public String faturarPedido(Pedido pedido, FormasPagamento formasPagamento, Usuario usuario) throws Exception{
		if(pedido != null){
			//Faturar pedido
			ruleNota.parse(pedido, usuario,formasPagamento);
			return "Pedido Faturado";
		}else{
			return "Nenhum produto para ser FATURADO.";
		}
	}
	
	/**
	 * Totaliza um pedido, pega todos os itens e soma o valor total um a um.
	 * @param pedido
	 * @return
	 */
	public BigDecimal totalizarPedido(Pedido pedido) {
		BigDecimal total = new BigDecimal(0.00);
		if(pedido != null){
			for (PedidoItens item : pedido.getItens()) {
				total = total.add(item.getVlTotal());
			}
		}
		return total;
	}
	
	/**
	 * Totaliza uma lista de pedidos
	 * @param pedidos
	 * @return
	 */
	public List<Pedido> totalizarTodosOsPedidos(List<Pedido> pedidos) {
		for (Pedido pedido : pedidos) {
			pedido.setVlTotal(totalizarPedido(pedido));
		}
		return pedidos;
	}
}
