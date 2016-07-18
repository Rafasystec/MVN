package br.com.barcadero.tables;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author antoniorafael
 *
 */
@Entity
@Table(name="CARTAO_PRESENT_TRANSF")
public class CartaoPresenteTransferencia extends EntidadeLoja {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3926910300414474358L;
	@Column(name="DT_HR_TRANSFERENCIA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtHrTransferencia;
	@Column(name="SALDO_TRANSFERIDO")
	private BigDecimal saldoTransferido;
	
	@OneToOne
	@JoinColumn(name="CARTAO_CANCELADO", referencedColumnName="codigo")
	private CartaoPresente cartaoCancelado;
	@OneToOne
	@JoinColumn(name="CARTAO_NOVO", referencedColumnName="codigo")
	private CartaoPresente cartaoNovo;
	public Date getDtHrTransferencia() {
		return dtHrTransferencia;
	}
	public void setDtHrTransferencia(Date dtHrTransferencia) {
		this.dtHrTransferencia = dtHrTransferencia;
	}
	public BigDecimal getSaldoTransferido() {
		return saldoTransferido;
	}
	public void setSaldoTransferido(BigDecimal saldoTransferido) {
		this.saldoTransferido = saldoTransferido;
	}
	public CartaoPresente getCartaoCancelado() {
		return cartaoCancelado;
	}
	public void setCartaoCancelado(CartaoPresente cartaoCancelado) {
		this.cartaoCancelado = cartaoCancelado;
	}
	public CartaoPresente getCartaoNovo() {
		return cartaoNovo;
	}
	public void setCartaoNovo(CartaoPresente cartaoNovo) {
		this.cartaoNovo = cartaoNovo;
	}
}
