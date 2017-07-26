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

import br.com.barcadero.core.enums.EnumCentroCusto;

@Entity
@Table(name="DESPESA_GASTO")
public class DespesaGasto extends EntidadeLoja {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5513656000365054432L;
	@Column(name="DT_DESPESA",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtDespesa = new Date();
	@Column(name="DESCRICAO",nullable=false,length=60)
	private String descricao = "";
	@Column(name="CENTRO_CUSTO",nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumCentroCusto centroCusto = EnumCentroCusto.OUTROS;
	@Column(name="VALOR",nullable=false)
	private BigDecimal valor = new BigDecimal("0.00");
	
	public Date getDtDespesa() {
		return dtDespesa;
	}
	public void setDtDespesa(Date dtDespesa) {
		this.dtDespesa = dtDespesa;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public EnumCentroCusto getCentroCusto() {
		return centroCusto;
	}
	public void setCentroCusto(EnumCentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((centroCusto == null) ? 0 : centroCusto.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((dtDespesa == null) ? 0 : dtDespesa.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		DespesaGasto other = (DespesaGasto) obj;
		if (centroCusto != other.centroCusto)
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (dtDespesa == null) {
			if (other.dtDespesa != null)
				return false;
		} else if (!dtDespesa.equals(other.dtDespesa))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
	
	
	
}
