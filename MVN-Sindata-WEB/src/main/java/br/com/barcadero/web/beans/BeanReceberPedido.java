package br.com.barcadero.web.beans;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.barcadero.core.util.FormasPagamento;
import br.com.barcadero.rule.RulePedido;
import br.com.barcadero.tables.Pedido;
import br.com.barcadero.web.functions.HandleMessage;

@ManagedBean
@RequestScoped
public class BeanReceberPedido extends SuperBean {

	private static final long serialVersionUID = -2518308925844030905L;
	private RulePedido rulePedido;
	private List<Pedido> pedidosAFaturarHoje;
	private Pedido selectedPedido;
	private FormasPagamento formasPagamento;
	public BeanReceberPedido() {
		rulePedido 		= new RulePedido(getEmpresaLogada(), getLojaLogada(), getDataBaseSession());
		formasPagamento = new FormasPagamento();
	}
	
	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String salvar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String alterar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String novo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Pedido> getPedidosDeHoje() {
		return rulePedido.findPedidosByDate(new Date());
	}
	
	public List<Pedido> listarPedidosAFaturarHoje() {
		return rulePedido.findPedidosAFaturarHoje();
	}

	public Pedido getSelectedPedido() {
		return selectedPedido;
	}

	public void setSelectedPedido(Pedido selectedPedido) {
		this.selectedPedido = selectedPedido;
	}
	
	public void faturarPedido() {
		try {
			if(selectedPedido != null){
				//rulePedido.faturarPedido(selectedPedido);
				HandleMessage.info("Pedido faturado com sucesso!","Pronto para o próximo");
			}else{
				HandleMessage.error("Selecione um pedido na grid","");
			}
		} catch (Exception e) {
			HandleMessage.error("Erro ao tentar Faturar o pedido", e.getMessage());
		}
	}

	public List<Pedido> getPedidosAFaturarHoje() {
		pedidosAFaturarHoje = listarPedidosAFaturarHoje();
		return pedidosAFaturarHoje;
	}

	public void setPedidosAFaturarHoje(List<Pedido> pedidosAFaturarHoje) {
		this.pedidosAFaturarHoje = pedidosAFaturarHoje;
	}

	public FormasPagamento getFormasPagamento() {
		return formasPagamento;
	}

	public void setFormasPagamento(FormasPagamento formasPagamento) {
		this.formasPagamento = formasPagamento;
	}

}
