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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.barcadero.core.enums.EnumFormPgtoPedido;
import br.com.barcadero.core.enums.EnumStatusPedido;
import br.com.barcadero.core.enums.EnumTipoPedido;
import br.com.barcadero.core.util.GlobalNameParam;

@NamedQueries({
	@NamedQuery(name=Pedido.FIND_ALL		,query="FROM Pedido WHERE empresa = :empresa"),
	@NamedQuery(name=Pedido.FIND_BY_LOJA	,query="FROM Pedido WHERE empresa = :empresa AND loja = :loja"),
	@NamedQuery(name=Pedido.FIND_BY_CLIENTE	,query="FROM Pedido WHERE empresa = :empresa AND cliente = :cliente"),
	@NamedQuery(name=Pedido.FIND_BY_CODE	,query="FROM Pedido WHERE empresa = :empresa AND codigo = :codigo"),
	@NamedQuery(name=Pedido.FIND_BY_DATE	,query="FROM Pedido WHERE empresa = :empresa AND loja = :loja AND dtCadastro = :dtCadastro"),
	@NamedQuery(name=Pedido.FIND_AFATURAR	,query="FROM Pedido WHERE empresa = :empresa AND loja = :loja AND dtCadastro = :dtCadastro AND flStPed = :flStPed")
})
@Entity
@Table(name="PEDIDO")
public class Pedido extends EntidadeLoja {

	public static final String FIND_ALL 		= "Pedido.findAll";
	public static final String FIND_BY_LOJA 	= "Pedido.findByLoja";
	public static final String FIND_BY_CLIENTE 	= "Pedido.findByCliente";
	public static final String FIND_BY_CODE 	= "Pedido.findByCode";
	public static final String FIND_BY_DATE 	= "Pedido.findByDate";
	public static final String FIND_AFATURAR	= "Pedido.findAFaturar";
	
	public Pedido() {
	}
	
	private static final long serialVersionUID = -6452091706343711475L;
	public Pedido(Empresa empresa, Loja loja, Usuario usuario) {
		super(empresa, loja, usuario);
	}

	@Column(name="FL_ST_PED", nullable=false)
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
	
	@OneToMany(mappedBy="pedido",fetch=FetchType.EAGER,targetEntity=PedidoItens.class)
	private List<PedidoItens> itens;
	
	@OneToOne
	@JoinColumn(name="endereco", referencedColumnName=GlobalNameParam.PARAM_DEFAULT_CODE_COLUMN)
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn(name="cliente", referencedColumnName="codigo")
	private Cliente cliente;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="caixa", referencedColumnName="codigo")
	private Caixa caixa;

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

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((caixa == null) ? 0 : caixa.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((dtEntrega == null) ? 0 : dtEntrega.hashCode());
		result = prime * result + ((dtPrevEntrega == null) ? 0 : dtPrevEntrega.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((enderecoEnt == null) ? 0 : enderecoEnt.hashCode());
		result = prime * result + ((flStPed == null) ? 0 : flStPed.hashCode());
		result = prime * result + ((formaPgtoPedido == null) ? 0 : formaPgtoPedido.hashCode());
		result = prime * result + ((itens == null) ? 0 : itens.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((tpPedido == null) ? 0 : tpPedido.hashCode());
		result = prime * result + ((vlTotal == null) ? 0 : vlTotal.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (caixa == null) {
			if (other.caixa != null)
				return false;
		} else if (!caixa.equals(other.caixa))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (dtEntrega == null) {
			if (other.dtEntrega != null)
				return false;
		} else if (!dtEntrega.equals(other.dtEntrega))
			return false;
		if (dtPrevEntrega == null) {
			if (other.dtPrevEntrega != null)
				return false;
		} else if (!dtPrevEntrega.equals(other.dtPrevEntrega))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (enderecoEnt == null) {
			if (other.enderecoEnt != null)
				return false;
		} else if (!enderecoEnt.equals(other.enderecoEnt))
			return false;
		if (flStPed != other.flStPed)
			return false;
		if (formaPgtoPedido != other.formaPgtoPedido)
			return false;
		if (itens == null) {
			if (other.itens != null)
				return false;
		} else if (!itens.equals(other.itens))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (tpPedido != other.tpPedido)
			return false;
		if (vlTotal == null) {
			if (other.vlTotal != null)
				return false;
		} else if (!vlTotal.equals(other.vlTotal))
			return false;
		return true;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}
