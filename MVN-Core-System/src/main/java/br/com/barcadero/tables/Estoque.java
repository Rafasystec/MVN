package br.com.barcadero.tables;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name=Estoque.FIND_ALL,query="FROM Estoque")
})
@Entity
@Table(name="ESTOQUE")
public class Estoque extends EntidadeEmpresa {

	
	private static final long serialVersionUID = -4543165285278201085L;
	public static final String FIND_ALL		= "Estoque.findAll";
	public Estoque() {
		// TODO Auto-generated constructor stub
	}
	
	public Estoque(Empresa empresa,Usuario usuario){
		super(empresa, usuario);
	}
	
	@Column(name="QUANTIDADE",precision=3,length=12)
	private BigDecimal quantidade;
	@Column(name="ESTOQ_MAX",precision=3,length=12)
	private BigDecimal estoqMax;
	@Column(name="ESTOQ_MIN",precision=3,length=12)
	private BigDecimal estoqMin;
	@Column(name="ESTOQ_ANTERIOR",precision=3,length=12)
	private BigDecimal estoqAnterior;
	
	@ManyToOne
	@JoinColumn(name="produto", referencedColumnName="codigo")
	private Produto produto;
	
	@OneToMany(mappedBy="estoque", targetEntity=EstoqueBaixa.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<EstoqueBaixa> baixas;
	
	public BigDecimal getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getEstoqMax() {
		return estoqMax;
	}
	public void setEstoqMax(BigDecimal estoqMax) {
		this.estoqMax = estoqMax;
	}
	public BigDecimal getEstoqMin() {
		return estoqMin;
	}
	public void setEstoqMin(BigDecimal estoqMin) {
		this.estoqMin = estoqMin;
	}
	public BigDecimal getEstoqAnterior() {
		return estoqAnterior;
	}
	public void setEstoqAnterior(BigDecimal estoqAnterior) {
		this.estoqAnterior = estoqAnterior;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((estoqAnterior == null) ? 0 : estoqAnterior.hashCode());
		result = prime * result + ((estoqMax == null) ? 0 : estoqMax.hashCode());
		result = prime * result + ((estoqMin == null) ? 0 : estoqMin.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
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
		Estoque other = (Estoque) obj;
		if (estoqAnterior == null) {
			if (other.estoqAnterior != null)
				return false;
		} else if (!estoqAnterior.equals(other.estoqAnterior))
			return false;
		if (estoqMax == null) {
			if (other.estoqMax != null)
				return false;
		} else if (!estoqMax.equals(other.estoqMax))
			return false;
		if (estoqMin == null) {
			if (other.estoqMin != null)
				return false;
		} else if (!estoqMin.equals(other.estoqMin))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		return true;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<EstoqueBaixa> getBaixas() {
		return baixas;
	}

	public void setBaixas(List<EstoqueBaixa> baixas) {
		this.baixas = baixas;
	}
	
}
