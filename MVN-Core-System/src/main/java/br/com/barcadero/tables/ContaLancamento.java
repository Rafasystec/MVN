package br.com.barcadero.tables;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.barcadero.core.enums.EnumCentroCusto;
import br.com.barcadero.core.enums.EnumFormaPgto;

@NamedQueries({
	@NamedQuery(name=ContaLancamento.FIND_BY_MONTH,query="FROM ContaLancamento WHERE empresa = :empresa AND loja= :loja AND data BETWEEN :dtIni AND :dtFim ")
})
@Entity
@Table(name="CONTA_LANCAMENTOS")
public class ContaLancamento extends EntidadeLoja {

	public static final String FIND_BY_MONTH = "br.com.barcadero.tables.ContaLancamento.findByMoth";
	
	public ContaLancamento() {
	
	}
	
	public ContaLancamento(Empresa empresa, Usuario usuario, Loja loja) {
		this.setEmpresa(empresa);
		this.setUsuario(usuario);
		this.setLoja(loja);
	}
	
	private static final long serialVersionUID = 514493381912312588L;
	@Column(name="DATA",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date data 		 = new Date();
	@Column(name="VALOR", scale=2, precision=10,nullable=false)
	private BigDecimal valor = new BigDecimal("0.00");
	@Column(name="CENTRO_CUSTO",nullable=false)
	private EnumCentroCusto centroCusto ;
	@Column(name="FORMA_PAGTO",nullable=false)
	private EnumFormaPgto formaPgto ;
	@Column(name="DESCRICAO",nullable=false,length=60)
	private String descricao= "";
	
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
		result = prime * result + ((centroCusto == null) ? 0 : centroCusto.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((formaPgto == null) ? 0 : formaPgto.hashCode());
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
		ContaLancamento other = (ContaLancamento) obj;
		if (centroCusto != other.centroCusto)
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (formaPgto != other.formaPgto)
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
	
	
}
