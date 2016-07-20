package br.com.barcadero.rule;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.core.enums.EnumStatusPedido;
import br.com.barcadero.dao.DaoPedido;
import br.com.barcadero.tables.Caixa;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Pedido;
import br.com.barcadero.tables.Usuario;

public class RulePedido extends RuleModelo<Pedido> {

	private RuleCaixa ruleCaixa;
	private DaoPedido daoPedido;
	public RulePedido(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		ruleCaixa = new RuleCaixa(empresa, loja, session);
		daoPedido = new DaoPedido(empresa, loja, session);
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
	
	public String fecharPedido(Pedido pedido) {
		try {
			pedido.setFlStPed(EnumStatusPedido.FECHADO);
			return daoPedido.update(pedido);
		} catch (Exception e) {
			return e.getMessage();
		}	
	}
	
	public List<Pedido> findPedidosByDate(Date date) {
		return daoPedido.findPedidosByDate(date);
	}
	
	public List<Pedido> findPedidosAFaturarHoje(Date date) {
		return daoPedido.findPedidosAFaturarHoje(date);
	}
	
	public void faturarPedido(Pedido pedido) throws Exception{
		if(pedido != null){
			//Faturar pedido
		}
	}

}