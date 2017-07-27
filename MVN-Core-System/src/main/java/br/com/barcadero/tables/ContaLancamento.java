package br.com.barcadero.tables;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.barcadero.core.enums.EnumCentroCusto;
import br.com.barcadero.core.enums.EnumFormaPgto;

@Entity
@Table(name="CONTA_LANCAMENTOS")
public class ContaLancamento extends EntidadeLoja {

	private static final long serialVersionUID = 514493381912312588L;
	@Column(name="DATA",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date data 		 = new Date();
	@Column(name="VALOR", scale=2, precision=10,nullable=false)
	private BigDecimal valor = new BigDecimal("0.00");
	@Column(name="CENTRO_CUSTO",nullable=false)
	private EnumCentroCusto centroCusto = EnumCentroCusto.OUTROS;
	@Column(name="FORMA_PAGTO",nullable=false)
	private EnumFormaPgto formaPgto = EnumFormaPgto.DINHEIRO;
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public EnumCentroCusto getCentroCusto() {
		return centroCusto;
	}
	public void setCentroCusto(EnumCentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}
	public EnumFormaPgto getFormaPgto() {
		return formaPgto;
	}
	public void setFormaPgto(EnumFormaPgto formaPgto) {
		this.formaPgto = formaPgto;
	}
	
}
