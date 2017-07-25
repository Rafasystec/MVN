package br.com.barcadero.tables;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.barcadero.core.enums.EnumFormaPgto;

/**
 * Tabela para registrar os pagamentos
 * @author Rafael Rocha
 *
 */
@Entity
@Table(name="PAGAMENTO")
public class Pagamento extends EntidadeLoja {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="DT_PAGAMENTO",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtPagamento;
	@Column(name="VALOR_PAGO",nullable=false)
	private BigDecimal valorPago;
	@Column(name="VALOR_JUROS",nullable=false)
	private BigDecimal valorJuros;
	@Column(name="FORMA_PGTO",nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumFormaPgto formaPagto;
	
	public Date getDtPagamento() {
		return dtPagamento;
	}
	public void setDtPagamento(Date dtPagamento) {
		this.dtPagamento = dtPagamento;
	}
	public BigDecimal getValorPago() {
		return valorPago;
	}
	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}
	public BigDecimal getValorJuros() {
		return valorJuros;
	}
	public void setValorJuros(BigDecimal valorJuros) {
		this.valorJuros = valorJuros;
	}
	public EnumFormaPgto getFormaPagto() {
		return formaPagto;
	}
	public void setFormaPagto(EnumFormaPgto formaPagto) {
		this.formaPagto = formaPagto;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dtPagamento == null) ? 0 : dtPagamento.hashCode());
		result = prime * result + ((formaPagto == null) ? 0 : formaPagto.hashCode());
		result = prime * result + ((valorJuros == null) ? 0 : valorJuros.hashCode());
		result = prime * result + ((valorPago == null) ? 0 : valorPago.hashCode());
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
		Pagamento other = (Pagamento) obj;
		if (dtPagamento == null) {
			if (other.dtPagamento != null)
				return false;
		} else if (!dtPagamento.equals(other.dtPagamento))
			return false;
		if (formaPagto != other.formaPagto)
			return false;
		if (valorJuros == null) {
			if (other.valorJuros != null)
				return false;
		} else if (!valorJuros.equals(other.valorJuros))
			return false;
		if (valorPago == null) {
			if (other.valorPago != null)
				return false;
		} else if (!valorPago.equals(other.valorPago))
			return false;
		return true;
	}
	
	
	
}
