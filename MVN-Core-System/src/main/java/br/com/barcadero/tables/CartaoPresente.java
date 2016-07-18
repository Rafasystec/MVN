package br.com.barcadero.tables;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import br.com.barcadero.core.enums.EnumSimNao;

/**
 * Para registrar cartao presente
 * @author Antonio Rafael
 * @since 1.0 - 18/07/2016 - 09:32
 */
@Entity
@Table(name="CARTAO_PRESENTE")
public class CartaoPresente extends EntidadeLoja {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7231635462253906583L;
	
	public CartaoPresente() {
		// TODO Auto-generated constructor stub
	}
	
	public CartaoPresente(Empresa empresa, Loja loja, Usuario usuario) {
		super(empresa, loja, usuario);
	}
	
	@Column(name="DT_VALIDADE")
	@Temporal(TemporalType.DATE)
	private Date dtValidade;
	@Column(name="DT_HR_VENDA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtHrVenda;
	@Column(name="NUMERO")
	private String numero = "0";
	@Column(name="VALOR")
	private BigDecimal valor = new BigDecimal(0.00);
	@Column(name="FL_CANCELADO")
	@Enumerated
	private EnumSimNao flCancelado = EnumSimNao.NAO;
	@Column(name="MOTIVO_CANCEL")
	private String motivoCancel = "";
	@Column(name="DT_HR_CANCELAMENTO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtHrCancelamento;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name="loja_cancel",referencedColumnName="codigo")
	private Loja lojaCancel;
	@OneToOne
	@PrimaryKeyJoinColumn(name="user_cancel",referencedColumnName="codigo")
	private Usuario userCancel;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Pedido pedido;

	public Date getDtValidade() {
		return dtValidade;
	}

	public void setDtValidade(Date dtValidade) {
		this.dtValidade = dtValidade;
	}

	public Date getDtHrVenda() {
		return dtHrVenda;
	}

	public void setDtHrVenda(Date dtHrVenda) {
		this.dtHrVenda = dtHrVenda;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public EnumSimNao getFlCancelado() {
		return flCancelado;
	}

	public void setFlCancelado(EnumSimNao flCancelado) {
		this.flCancelado = flCancelado;
	}

	public String getMotivoCancel() {
		return motivoCancel;
	}

	public void setMotivoCancel(String motivoCancel) {
		this.motivoCancel = motivoCancel;
	}

	public Date getDtHrCancelamento() {
		return dtHrCancelamento;
	}

	public void setDtHrCancelamento(Date dtHrCancelamento) {
		this.dtHrCancelamento = dtHrCancelamento;
	}

	public Loja getLojaCancel() {
		return lojaCancel;
	}

	public void setLojaCancel(Loja lojaCancel) {
		this.lojaCancel = lojaCancel;
	}

	public Usuario getUserCancel() {
		return userCancel;
	}

	public void setUserCancel(Usuario userCancel) {
		this.userCancel = userCancel;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
}
