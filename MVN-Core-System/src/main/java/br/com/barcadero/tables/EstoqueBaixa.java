package br.com.barcadero.tables;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="ESTOQUE_BAIXA")
public class EstoqueBaixa extends EntidadeEmpresa {

	/**
	 * Somente para o Hibernate, nao utilizar na aplicacao
	 */
	public EstoqueBaixa() {
		// TODO Auto-generated constructor stub
	}
	
	public EstoqueBaixa(Empresa empresa,Usuario usuario) {
		super(empresa, usuario);
	}
	
	private static final long serialVersionUID = 6712079919654584412L;
	@Column(name="QTD_ANTERIOR",precision=3,length=12)
	private BigDecimal qtdAnterior;
	@Column(name="QTD_BAIXA",precision=3,length=12)
	private BigDecimal qtdBaixa;
	
	@ManyToOne
	@JoinColumn(name="estoque", referencedColumnName="codigo")
	private Estoque estoque;
	
	@OneToOne(cascade=CascadeType.ALL, optional=false,fetch=FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private Produto produto;

	public BigDecimal getQtdAnterior() {
		return qtdAnterior;
	}

	public void setQtdAnterior(BigDecimal qtdAnterior) {
		this.qtdAnterior = qtdAnterior;
	}

	public BigDecimal getQtdBaixa() {
		return qtdBaixa;
	}

	public void setQtdBaixa(BigDecimal qtdBaixa) {
		this.qtdBaixa = qtdBaixa;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((estoque == null) ? 0 : estoque.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((qtdAnterior == null) ? 0 : qtdAnterior.hashCode());
		result = prime * result + ((qtdBaixa == null) ? 0 : qtdBaixa.hashCode());
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
		EstoqueBaixa other = (EstoqueBaixa) obj;
		if (estoque == null) {
			if (other.estoque != null)
				return false;
		} else if (!estoque.equals(other.estoque))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (qtdAnterior == null) {
			if (other.qtdAnterior != null)
				return false;
		} else if (!qtdAnterior.equals(other.qtdAnterior))
			return false;
		if (qtdBaixa == null) {
			if (other.qtdBaixa != null)
				return false;
		} else if (!qtdBaixa.equals(other.qtdBaixa))
			return false;
		return true;
	}
	
	

}
