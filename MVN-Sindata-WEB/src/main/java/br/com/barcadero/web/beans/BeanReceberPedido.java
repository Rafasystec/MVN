package br.com.barcadero.web.beans;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.SelectEvent;

import br.com.barcadero.core.util.FormasPagamento;
import br.com.barcadero.rule.RuleCaixa;
import br.com.barcadero.rule.RulePedido;
import br.com.barcadero.tables.Caixa;
import br.com.barcadero.tables.Pedido;
import br.com.barcadero.web.functions.HandleMessage;

@ManagedBean
@RequestScoped
public class BeanReceberPedido extends SuperBean<Pedido> {

	private static final long serialVersionUID = -2518308925844030905L;
	private List<Pedido> pedidosAFaturarHoje;
	private Pedido selectedPedido;
	private FormasPagamento formasPagamento;
	private BigDecimal vlSubTotal = new BigDecimal(0.00);
	@ManagedProperty("#{rulePedido}")
	private RulePedido rulePedido;
	@ManagedProperty("#{ruleCaixa}")
	private RuleCaixa ruleCaixa;
	private Caixa caixa;

	@PostConstruct
	private void init() {
		formasPagamento = new FormasPagamento();
		
		obterCaixaDaEstacao();
	}

	private void obterCaixaDaEstacao() {
		try {
			this.caixa = ruleCaixa.findByIp(getLojaLogada(), getSession().getIpAddress(isRealIp()));
			boolean isCaixa = true;
			if(this.caixa != null){
				if(this.caixa.getCodigo() == 0){
					isCaixa = false;
				}
			}else{
				isCaixa = false;
			}
			if(!isCaixa){
				HandleMessage.error("Caixa não encontrado", "O IP " + getSession().getIpAddress(isRealIp()) + " não foi cadastrado como um caixa.");
			}
		} catch (Exception e) {
			this.caixa = null;
		}
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
		return rulePedido.findPedidosAFaturarHoje(getEmpresaLogada(),getLojaLogada());
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
				String result = rulePedido.faturarPedido(caixa,selectedPedido, formasPagamento, getUsuarioLogado());
				HandleMessage.info("Pedido faturado com sucesso!","Pronto para o próximo");
				HandleMessage.warn("ATENÇÃO: ", result);
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

	public RulePedido getRulePedido() {
		return rulePedido;
	}

	public void setRulePedido(RulePedido rulePedido) {
		this.rulePedido = rulePedido;
	}

	@Override
	public boolean validar(Pedido entidade) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public RuleCaixa getRuleCaixa() {
		return ruleCaixa;
	}

	public void setRuleCaixa(RuleCaixa ruleCaixa) {
		this.ruleCaixa = ruleCaixa;
	}
	
	
	
}
