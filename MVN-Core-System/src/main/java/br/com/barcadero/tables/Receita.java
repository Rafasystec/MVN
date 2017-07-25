package br.com.barcadero.tables;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.barcadero.core.enums.EnumTipoReceita;

@Entity
@Table(name="RECEITA")
public class Receita extends EntidadeLoja {




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="TIPO",nullable=false)
	private EnumTipoReceita tipo;
	@Column(name="VALOR",nullable=false)
	private BigDecimal valor;
	@Column(name="DT_PREVISAO",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtPrevisao;
	@Column(name="DESCRICAO",nullable=false,length=60)
	private String descricao;
	public EnumTipoReceita getTipo() {
		return tipo;
	}
	public void setTipo(EnumTipoReceita tipo) {
		this.tipo = tipo;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Date getDtPrevisao() {
		return dtPrevisao;
	}
	public void setDtPrevisao(Date dtPrevisao) {
		this.dtPrevisao = dtPrevisao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((dtPrevisao == null) ? 0 : dtPrevisao.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Receita other = (Receita) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (dtPrevisao == null) {
			if (other.dtPrevisao != null)
				return false;
		} else if (!dtPrevisao.equals(other.dtPrevisao))
			return false;
		if (tipo != other.tipo)
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
	
}
