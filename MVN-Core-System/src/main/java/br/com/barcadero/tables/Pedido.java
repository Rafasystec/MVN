package br.com.barcadero.tables;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.barcadero.core.enums.EnumFormPgtoPedido;
import br.com.barcadero.core.enums.EnumStatusPedido;
import br.com.barcadero.core.enums.EnumTipoPedido;

@NamedQueries({
	@NamedQuery(name=Pedido.FIND_ALL		,query="FROM Pedido WHERE empresa = :empresa"),
	@NamedQuery(name=Pedido.FIND_BY_LOJA	,query="FROM Pedido WHERE empresa = :empresa AND loja = :loja"),
	@NamedQuery(name=Pedido.FIND_BY_CLIENTE	,query="FROM Pedido WHERE empresa = :empresa AND cliente = :cliente"),
	@NamedQuery(name=Pedido.FIND_ALL		,query="FROM Pedido WHERE empresa = :empresa AND codigo = :codigo"),
})
@Entity
@Table(name="PEDIDO")
public final class Pedido extends EntidadeLoja {

	public static final String FIND_ALL 		= "Pedido.findAll";
	public static final String FIND_BY_LOJA 	= "Pedido.findByLoja";
	public static final String FIND_BY_CLIENTE 	= "Pedido.findByCliente";
	public static final String FIND_BY_CODE 	= "Pedido.findByCode";
	public Pedido() {
	}
	
	private static final long serialVersionUID = -6452091706343711475L;
	public Pedido(Loja loja, Usuario usuario) {
		super(loja, usuario);
	}

	@Column(name="FL_ST_PED", nullable=false, length=1)
	@Enumerated(EnumType.STRING)
	private EnumStatusPedido flStPed        = EnumStatusPedido.ABERTO;
	@Column(name="TP_PEDIDO", nullable=false, length=1)
	private EnumTipoPedido tpPedido       = EnumTipoPedido.PEDIDO;
	@Column(name="ENDERECO_ENT", nullable=false,length=250)
	private String enderecoEnt    = "";
	@Column(name="DT_ENTREGA", nullable=false)
	private Date dtEntrega        = new Date();
	@Column(name="DT_PREV_ENTREGA", nullable=false)
	private Date dtPrevEntrega    = new Date();
	@Column(name="VL_TOTAL", nullable=false)
	private BigDecimal vlTotal    = new BigDecimal(0);
	@Column(name="OBSERVACAO", nullable=false, length=250)
	private String observacao     = "";

	@Column(name="CD_FORMA_PGTO", nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumFormPgtoPedido formaPgtoPedido = EnumFormPgtoPedido.A_VISTA;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="pedido",fetch=FetchType.EAGER,targetEntity=Pedido.class)
	private List<PedidoItens> itens;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,targetEntity=Endereco.class)
	private List<Endereco> enderecos;
	
	@ManyToOne
	@JoinColumn(name="cliente", referencedColumnName="codigo")
	private Cliente cliente;

	/**
	 * Status do pedido: A
	 * @return
	 */
	public EnumStatusPedido getFlStPed() {
		return flStPed;
	}
	
	/**
	 * Estado do pedido: A - aberto; F - faturado; P - Fechado; C - Cancelado
	 * @param flStPed
	 */
	public void setFlStPed(EnumStatusPedido flStPed) {
		this.flStPed = flStPed;
	}
	public EnumTipoPedido getTpPedido() {
		return tpPedido;
	}
	/**
	 * Tipo de pedido: O - Orcamento; P - Pedido de Venda
	 * @param tpPedido
	 */
	public void setTpPedido(EnumTipoPedido tpPedido) {
		this.tpPedido = tpPedido;
	}
	
	public Date getDtEntrega() {
		return dtEntrega;
	}
	/**
	 * Data em que o pedido foi entregue
	 * @param dtEntrega
	 */
	public void setDtEntrega(Date dtEntrega) {
		this.dtEntrega = dtEntrega;
	}
	public Date getDtPrevEntrega() {
		return dtPrevEntrega;
	}
	/**
	 * Data de previsao de entrega caso exista
	 * @param dtPrevEntrega
	 */
	public void setDtPrevEntrega(Date dtPrevEntrega) {
		this.dtPrevEntrega = dtPrevEntrega;
	}
	public BigDecimal getVlTotal() {
		return vlTotal;
	}
	public void setVlTotal(BigDecimal vlTotal) {
		this.vlTotal = vlTotal;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public String getEnderecoEnt() {
		return enderecoEnt;
	}

	/**
	 * Endereco de entrega por extenso em caso de o cliente nao ter cadastro ou nao quiser se cadastrar
	 * entao o vendedor pode por o endereco livremente.
	 * @param enderecoEnt
	 */
	public void setEnderecoEnt(String enderecoEnt) {
		this.enderecoEnt = enderecoEnt;
	}

	public List<PedidoItens> getItens() {
		return itens;
	}

	public void setItens(List<PedidoItens> itens) {
		this.itens = itens;
	}

	public EnumFormPgtoPedido getFormaPgtoPedido() {
		return formaPgtoPedido;
	}

	public void setFormaPgtoPedido(EnumFormPgtoPedido formaPgtoPedido) {
		this.formaPgtoPedido = formaPgtoPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
}
