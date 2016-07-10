package br.com.barcadero.tables;

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
	@Column(name="QTD_ANTERIOR",length=12)
	private int qtdAnterior;
	@Column(name="QTD_BAIXA",length=12)
	private int qtdBaixa;
	
	@ManyToOne
	@JoinColumn(name="estoque", referencedColumnName="codigo")
	private Estoque estoque;
	
	@OneToOne(cascade=CascadeType.ALL, optional=false,fetch=FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private Produto produto;

	public int getQtdAnterior() {
		return qtdAnterior;
	}

	public void setQtdAnterior(int qtdAnterior) {
		this.qtdAnterior = qtdAnterior;
	}

	public int getQtdBaixa() {
		return qtdBaixa;
	}

	public void setQtdBaixa(int qtdBaixa) {
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
		result = prime * result + qtdAnterior;
		result = prime * result + qtdBaixa;
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
		if (qtdAnterior != other.qtdAnterior)
			return false;
		if (qtdBaixa != other.qtdBaixa)
			return false;
		return true;
	}
	
	

}
