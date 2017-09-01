package br.com.barcadero.web.beans;

import java.math.BigDecimal;
import java.net.UnknownHostException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.barcadero.rule.RuleCaixa;
import br.com.barcadero.rule.RulePedido;
import br.com.barcadero.rule.RulePedidoItens;
import br.com.barcadero.rule.RuleProduto;
import br.com.barcadero.tables.Caixa;
import br.com.barcadero.tables.Pedido;
import br.com.barcadero.tables.PedidoItens;
import br.com.barcadero.tables.Produto;
import br.com.barcadero.web.functions.HandleFaceContext;
import br.com.barcadero.web.functions.HandleMessage;

@ManagedBean
@ViewScoped
public class BeanPedidoVenda extends SuperBean<Pedido>{


	private static final long serialVersionUID = -1991283788493039890L;
	private Pedido pedido;
	private String vededor;
	private String strProduto;
	private String lastProduto;
	private PedidoItens item;
	private List<PedidoItens> itens;
	private Caixa caixa;
	private BigDecimal vlSubTotal = new BigDecimal(0.00);
	private BigDecimal vlUnitario = new BigDecimal(0.00);
	//--------------------------------------
	//Rules envolvidas
	//--------------------------------------
	@ManagedProperty("#{rulePedidoItens}")
	private RulePedidoItens rulePedidoItens;
	@ManagedProperty("#{ruleProduto}")
	private RuleProduto ruleProduto;
	@ManagedProperty("#{rulePedido}")
	private RulePedido rulePedido;
	@ManagedProperty("#{ruleCaixa}")
	private RuleCaixa ruleCaixa;
	
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@PostConstruct
	public void init() {
		System.out.println("@PostConstruct method init");
		item			= createItem();
		pedido			= new Pedido(getEmpresaLogada(), getLojaLogada(), getUsuarioLogado());
		try {
			caixa			= obterCaixaDeVenda();
		} catch (UnknownHostException e) {
		}
	}
	
	@Override
	public String salvar() throws Exception {
		try {
			System.out.println("Save item called.");
			//beginTransaction();
			if(pedido == null){
				pedido	= createPedido();
			}
			Produto produto = ruleProduto.find(ruleProduto.extrairCodigo(getStrProduto()));
			lastProduto = produto.getDescricao();
			item.setProduto(produto);
			item.setPedido(pedido);
			rulePedidoItens.insert(pedido, item);
			setVlUnitario(item.getVlTotal());
			totalizarSubTotal(item);
			//commit();
			item = createItem();
		} catch (Exception e) {
			HandleMessage.error("Erro ao inserir Item", e.getMessage());
		}
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

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String getVededor() {
		return vededor;
	}

	public void setVededor(String vededor) {
		this.vededor = vededor;
	}
	
	public void salvarItem() {
		try {
			System.out.println("Save item called.");
			if(pedido == null){
				pedido	= createPedido();
			}
			Produto produto = ruleProduto.find(ruleProduto.extrairCodigo(getStrProduto()));
			lastProduto = produto.getDescricao();
			item.setProduto(produto);
			item.setPedido(pedido);
			rulePedidoItens.insert(pedido, item);
			setVlUnitario(item.getVlTotal());
			totalizarSubTotal(item);

			item = createItem();
		} catch (Exception e) {
			HandleMessage.error("Erro ao inserir Item", e.getMessage());
		}
	}
	
	private Pedido createPedido() throws UnknownHostException, Exception {
		return rulePedido.createPedido(getEmpresaLogada(),getLojaLogada() ,getUsuarioLogado(), HandleFaceContext.getIpAddress());
	}

	public void fecharPedido() {
		try {
			pedido.setCaixa(caixa);
			String ret = rulePedido.fecharPedido(pedido);
			System.out.println("Fechar pedido: " + ret);
			HandleMessage.info("Fechar Pedido: ", ret);
			pedido = createPedido();
		} catch (Exception e) {
			HandleMessage.error("Erro no fechamento do Pedido: ", e.getMessage());
		}
	}

	public String getStrProduto() {
		return strProduto;
	}

	public void setStrProduto(String strProduto) {
		this.strProduto = strProduto;
	}

	public String getLastProduto() {
		return lastProduto;
	}

	public void setLastProduto(String lastProduto) {
		this.lastProduto = lastProduto;
	}

	public PedidoItens getItem() {
		return item;
	}

	public void setItem(PedidoItens item) {
		this.item = item;
	}

	public List<PedidoItens> getItens() {
		itens = rulePedidoItens.findByPedido(pedido);
		return itens;
	}

	public void setItens(List<PedidoItens> itens) {
		this.itens = itens;
	}

	public BigDecimal getVlSubTotal() {
		return vlSubTotal;
	}

	public void setVlSubTotal(BigDecimal vlSubTotal) {
		this.vlSubTotal = vlSubTotal;
	}

	public BigDecimal getVlUnitario() {
		return vlUnitario;
	}

	public void setVlUnitario(BigDecimal vlUnitario) {
		this.vlUnitario = vlUnitario;
	}
	
	private void totalizarSubTotal(PedidoItens item) {
		setVlSubTotal(getVlSubTotal().add(item.getVlTotal()));
	}
	
	private void totalizarSubtrairSubTotal(PedidoItens item) {
		setVlSubTotal(getVlSubTotal().subtract(item.getVlTotal()));
	}
	
	private PedidoItens createItem() {
		return new PedidoItens(getEmpresaLogada(), getLojaLogada(), getUsuarioLogado());
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}
	
	public Caixa obterCaixaDeVenda() throws UnknownHostException {
		caixa = ruleCaixa.getCaixaVenda(getLojaLogada(), getSession().getIpAddress(isRealIp()));
		if(caixa == null){
			HandleMessage.error("Sua estação não possui caixa", "Por favor cadastre um caixa primeiro.");
		}
		return caixa;
	}

	@Override
	public boolean validar(Pedido entidade) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public RulePedidoItens getRulePedidoItens() {
		return rulePedidoItens;
	}

	public void setRulePedidoItens(RulePedidoItens rulePedidoItens) {
		this.rulePedidoItens = rulePedidoItens;
	}

	public RuleProduto getRuleProduto() {
		return ruleProduto;
	}

	public void setRuleProduto(RuleProduto ruleProduto) {
		this.ruleProduto = ruleProduto;
	}

	public RulePedido getRulePedido() {
		return rulePedido;
	}

	public void setRulePedido(RulePedido rulePedido) {
		this.rulePedido = rulePedido;
	}

	public RuleCaixa getRuleCaixa() {
		return ruleCaixa;
	}

	public void setRuleCaixa(RuleCaixa ruleCaixa) {
		this.ruleCaixa = ruleCaixa;
	}
	
	public void excuirItem(PedidoItens item) {
		if(item != null){
			if(item.getCodigo() > 0){
				try {
					PedidoItens itemTemp = item;
					rulePedidoItens.delete(item.getCodigo());
					totalizarSubtrairSubTotal(itemTemp);
					itemTemp = null;
				} catch (Exception e) {
				}
			}
		}
	}
}
