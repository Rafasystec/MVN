package br.com.barcadero.rule;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.barcadero.core.enums.EnumNotaFaturada;
import br.com.barcadero.core.enums.EnumStatusPedido;
import br.com.barcadero.core.util.FormasPagamento;
import br.com.barcadero.dao.DaoPedido;
import br.com.barcadero.module.sat.exceptions.SATException;
import br.com.barcadero.tables.Caixa;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Nota;
import br.com.barcadero.tables.Pedido;
import br.com.barcadero.tables.PedidoItens;
import br.com.barcadero.tables.Usuario;
@Service
public class RulePedido extends RuleModelo<Pedido> {

	@Autowired
	private DaoPedido daoPedido;
	@Autowired
	private RuleNota ruleNota;
	@Autowired
	private RuleGenarateCFe ruleGenarateCFe;
	@Autowired
	private RuleCupomEletronico ruleCupomEletronico;
	
	@Override
	public String delete(long codigo) throws Exception {
		return daoPedido.delete(codigo);
	}

	@Override
	public Pedido find(long codigo) throws Exception {
		return daoPedido.find(codigo);
	}

	@Override
	public List<Pedido> findAll() throws Exception {
		return daoPedido.findAll();
	}
	
	/**
	 * 
	 * @param usuario
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	public Pedido createPedido(Empresa empresa,Loja loja, Usuario usuario, String ip) throws Exception {
		Pedido pedido = new Pedido(empresa, loja, usuario);
		return pedido;
	}
	
	/**
	 * 
	 * @param pedido
	 * @return
	 */
	@Transactional(readOnly=false)
	public String fecharPedido(Pedido pedido) throws Exception{
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
	
	public List<Pedido> findPedidosAFaturarHoje(Empresa empresa,Loja loja) {
		List<Pedido> pedidos = daoPedido.findPedidosAFaturarHoje(empresa,loja);
		pedidos = totalizarTodosOsPedidos(pedidos);
		return pedidos;
	}
	
	/**
	 * Fatura o pedido de fato, ou seja, gera nota e emite o tipo de documento configurado no caixa.
	 * @param pedido
	 * @param formasPagamento
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public String faturarPedido(Caixa caixa, Pedido pedido, FormasPagamento formasPagamento, Usuario usuario) throws Exception{
		if(pedido != null){
			Nota nota 	= ruleNota.parse(caixa, pedido, usuario, formasPagamento);
			return faturarPedidoDeAcordoComModeloDeNota(caixa, pedido, usuario, nota);	
		}else{
			return "Nenhum produto para ser FATURADO.";
		}
	}

	private String faturarPedidoDeAcordoComModeloDeNota(Caixa caixa, Pedido pedido, Usuario usuario, Nota nota) throws SATException, Exception {
		if(caixa != null){
			switch (caixa.getTipoNota()) {
			case MOD_55:
				return "Nota fiscal eletrônica ainda não implementada";
			case MOD_57:
				return "CT-e ainda não suportado";
			case MOD_59:
				return realizarVendaComCFe(caixa, usuario, nota);
			case MOD_65:
				//NFC-e
				return "NFC-e ainda não implementado.";
			default:
				break;
			}
			pedido.setFlStPed(EnumStatusPedido.FATURADO);
			daoPedido.update(pedido);
			return "Pedido Faturado";
		}else{
			throw new Exception("Caixa não foi configurado");
		}
	}
	/**
	 * Realizar venda com CF-e
	 * @param caixa
	 * @param usuario
	 * @param nota
	 * @return
	 * @throws SATException
	 * @throws Exception
	 */
	private String realizarVendaComCFe(Caixa caixa, Usuario usuario, Nota nota) throws SATException, Exception {
		String result 		= ruleGenarateCFe.executarVendaSAT(caixa,nota, usuario);
		nota.setFlFaturado(EnumNotaFaturada.SIM);
		nota = ruleNota.update(nota);
		nota.getPedido().setFlStPed(EnumStatusPedido.FATURADO);
		update(nota.getPedido());
		String msgAdicional = "";
		try {
			ruleCupomEletronico.imprimirExtratoCFe(nota);
		} catch (Exception e) {
			msgAdicional = "Porém com erro de impressão :" + e.getMessage(); 
		}
		return result + msgAdicional;
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
	
	/**
	 * Cancelar um pedido
	 * @param pedido
	 * @return
	 * @throws Exception
	 */
	public String canelar(Pedido pedido, Usuario usuario) throws Exception {
		if(pedido != null){
			pedido.setFlStPed(EnumStatusPedido.CANCELADO);
			daoPedido.update(pedido);
			return "Pedido " + pedido.getCodigo() + " cancelado.";
		}else{
			return "Pedido tem valor inválido ou está nulo.";
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

	@Override
	public Pedido insert(Pedido entidade) throws Exception {
		return daoPedido.insert(entidade);
	}


	@Override
	public Pedido update(Pedido entidade) throws Exception {
		return daoPedido.update(entidade);
	}
	
}
