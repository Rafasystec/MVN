package br.com.barcadero.tables;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.barcadero.core.util.GlobalNameParam;
@NamedQueries({
	@NamedQuery(name=PedidoItens.FIND_ALL		,query="FROM PedidoItens WHERE empresa = :empresa"),
	@NamedQuery(name=PedidoItens.FIND_BY_PEDIDO	,query="FROM PedidoItens WHERE empresa = :empresa AND pedido = :pedido")
})
@Entity
@Table(name="PEDIDO_ITENS")
public class PedidoItens extends EntidadeLoja {

	public static final String FIND_ALL 		= "PedidoItens.findAll";
	public static final String FIND_BY_PEDIDO 	= "PedidoItens.findByPedido";
	
	public PedidoItens() {
		// TODO Auto-generated constructor stub
	}
	
	public PedidoItens(Empresa empresa, Loja loja, Usuario usuario) {
		super(empresa, loja, usuario);
	}
	
	private static final long serialVersionUID = -437268462584764920L;

	@Column(name="NR_ITEM", nullable=false)
	private int nrItem            = 0;     
	
	@Column(name="QUANTIDADE", nullable=false)
	private float quantidade = 0.000f;
	@Column(name="VL_UNITARIO", nullable=false)
	private BigDecimal vlUnitario = new BigDecimal(0);
	@Column(name="VL_TOTAL", nullable=false)
	private BigDecimal vlTotal    = new BigDecimal(0);
	@Column(name="DT_ENTREGA", nullable=false)
	private Date dtEntrega        = new Date();
	@Column(name="DT_PREV_ENTREGA", nullable=false)
	private Date dtPrevEntrega    = new Date();
	@Column(name="VL_DESCONTO", nullable=false)
	private BigDecimal vlDesconto = new BigDecimal(0);
	@Column(name="VL_ACRESCIMO", nullable=false)
	private BigDecimal vlAcrescimo= new BigDecimal(0);
	@Column(name="PC_DESCONTO", nullable=false)
	private BigDecimal pcDesconto = new BigDecimal(0);
	@Column(name="PC_ACRESCIMO", nullable=false)
	private BigDecimal pcAcrescimo= new BigDecimal(0);
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pedido",referencedColumnName="codigo")
	private Pedido pedido;
	
	@OneToOne
	@JoinColumn(name=GlobalNameParam.PARAM_PRODUTO, referencedColumnName=GlobalNameParam.PARAM_DEFAULT_CODE_COLUMN)
	private Produto produto;
	
	public int getNrItem() {
		return nrItem;
	}
	public void setNrItem(int nrItem) {
		this.nrItem = nrItem;
	}

	public float getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getVlUnitario() {
		return vlUnitario;
	}
	public void setVlUnitario(BigDecimal vlUnitario) {
		this.vlUnitario = vlUnitario;
	}
	public BigDecimal getVlTotal() {
		return vlTotal;
	}
	public void setVlTotal(BigDecimal vlTotal) {
		this.vlTotal = vlTotal;
	}
	public Date getDtEntrega() {
		return dtEntrega;
	}
	public void setDtEntrega(Date dtEntrega) {
		this.dtEntrega = dtEntrega;
	}
	public Date getDtPrevEntrega() {
		return dtPrevEntrega;
	}
	public void setDtPrevEntrega(Date dtPrevEntrega) {
		this.dtPrevEntrega = dtPrevEntrega;
	}
	public BigDecimal getVlDesconto() {
		return vlDesconto;
	}
	public void setVlDesconto(BigDecimal vlDesconto) {
		this.vlDesconto = vlDesconto;
	}
	public BigDecimal getVlAcrescimo() {
		return vlAcrescimo;
	}
	public void setVlAcrescimo(BigDecimal vlAcrescimo) {
		this.vlAcrescimo = vlAcrescimo;
	}
	public BigDecimal getPcDesconto() {
		return pcDesconto;
	}
	public void setPcDesconto(BigDecimal pcDesconto) {
		this.pcDesconto = pcDesconto;
	}
	public BigDecimal getPcAcrescimo() {
		return pcAcrescimo;
	}
	public void setPcAcrescimo(BigDecimal pcAcrescimo) {
		this.pcAcrescimo = pcAcrescimo;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
