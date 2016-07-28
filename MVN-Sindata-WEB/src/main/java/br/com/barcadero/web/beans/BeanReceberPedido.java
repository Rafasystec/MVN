package br.com.barcadero.web.beans;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.SelectEvent;

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
	private BigDecimal vlSubTotal = new BigDecimal(0.00);

	
	public BeanReceberPedido() {
		rulePedido 		= new RulePedido(getEmpresaLogada(), getLojaLogada(), getDataBaseSession(),getCaixaVenda());
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
				String result = rulePedido.faturarPedido(selectedPedido, formasPagamento, getUsuarioLogado());
				HandleMessage.info("Pedido faturado com sucesso!","Pronto para o próximo");
				HandleMessage.warn("ATENÇÃO: ", result);
			}else{
				HandleMessage.error("Selecione um pedido na grid","");
			}
		} catch (Exception e) {
			getDataBaseSession().getTransaction().rollback();
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

	public BigDecimal getVlSubTotal() {
		return vlSubTotal;
	}

	public void setVlSubTotal(BigDecimal vlSubTotal) {
		this.vlSubTotal = vlSubTotal;
	}

	public void atualizarTotal(Pedido pedido) {
		setVlSubTotal(pedido.getVlTotal());
	}
	
	public void onRowSelect(SelectEvent event) {
		Pedido pedido = (Pedido)event.getObject();
		atualizarTotal(pedido);
		porValorDefaultEmDinheiro(pedido);
	}
	
	public void porValorDefaultEmDinheiro(Pedido pedido) {
		if(formasPagamento != null){
			formasPagamento.setVlDinheiro(pedido.getVlTotal());
		}
	}
	public void cancelar(){
		if(selectedPedido != null){
			System.out.println("Codigo pedido: " + selectedPedido.getCodigo());
			try {
				String ret = rulePedido.canelar(selectedPedido, getUsuarioLogado());
				HandleMessage.info("Cancelamento: ", ret);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				HandleMessage.error("Erro no cancelamento do pedido: ", e.getMessage());
			}
			
		}
	}
	
	
	
}
