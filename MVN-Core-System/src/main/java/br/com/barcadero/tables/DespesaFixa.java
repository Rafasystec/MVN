package br.com.barcadero.tables;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.barcadero.core.enums.EnumFreqDespesa;

@Entity
@Table(name="DESPESA_FIXA")
public class DespesaFixa extends EntidadeLoja {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6728027097525106996L;
	@Column(name="DT_DESPESA",nullable=false)
	private Date dtDespesa;
	@Column(name="DT_VENCIMENTO",nullable=false)
	private Date dtVencimento;
	@Column(name="FREQUENCIA",nullable=false)
	private EnumFreqDespesa frequencia;
	@Column(name="QTDE_PARCELAS",nullable=false)
	private int qtdeParcelas;
	@Column(name="DESCRICAO",nullable=false,length=60)
	private String descricao;
	@Column(name="DIA_BASE",nullable=false)
	private int diaBase = 1;
	
	public Date getDtDespesa() {
		return dtDespesa;
	}
	public void setDtDespesa(Date dtDespesa) {
		this.dtDespesa = dtDespesa;
	}
	public Date getDtVencimento() {
		return dtVencimento;
	}
	public void setDtVencimento(Date dtVencimento) {
		this.dtVencimento = dtVencimento;
	}
	public EnumFreqDespesa getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(EnumFreqDespesa frequencia) {
		this.frequencia = frequencia;
	}
	public int getQtdeParcelas() {
		return qtdeParcelas;
	}
	public void setQtdeParcelas(int qtdeParcelas) {
		this.qtdeParcelas = qtdeParcelas;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getDiaBase() {
		return diaBase;
	}
	public void setDiaBase(int diaBase) {
		this.diaBase = diaBase;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + diaBase;
		result = prime * result + ((dtDespesa == null) ? 0 : dtDespesa.hashCode());
		result = prime * result + ((dtVencimento == null) ? 0 : dtVencimento.hashCode());
		result = prime * result + ((frequencia == null) ? 0 : frequencia.hashCode());
		result = prime * result + qtdeParcelas;
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
		DespesaFixa other = (DespesaFixa) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (diaBase != other.diaBase)
			return false;
		if (dtDespesa == null) {
			if (other.dtDespesa != null)
				return false;
		} else if (!dtDespesa.equals(other.dtDespesa))
			return false;
		if (dtVencimento == null) {
			if (other.dtVencimento != null)
				return false;
		} else if (!dtVencimento.equals(other.dtVencimento))
			return false;
		if (frequencia != other.frequencia)
			return false;
		if (qtdeParcelas != other.qtdeParcelas)
			return false;
		return true;
	}
	
}
