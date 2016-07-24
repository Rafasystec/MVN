package br.com.barcadero.tables;

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
	@NamedQuery(name=Estoque.FIND_ALL	,query="FROM Estoque WHERE empresa = :empresa"),
	@NamedQuery(name=Estoque.FIND_BY_COD,query="FROM Estoque WHERE empresa = :empresa AND codigo = :codigo")
})

@Entity
@Table(name="ESTOQUE")
public class Estoque extends EntidadeEmpresa {

	
	private static final long serialVersionUID = -4543165285278201085L;
	public static final String FIND_ALL		= "Estoque.findAll";
	public static final String FIND_BY_COD	= "Estoque.findAllByCode";
	public Estoque() {

	}
	
	public Estoque(Empresa empresa,Usuario usuario){
		super(empresa, usuario);
	}
	
	@Column(name="QUANTIDADE",length=12)
	private float quantidade = 0.000f;
	@Column(name="ESTOQ_MAX",length=12)
	private float estoqMax = 0.000f;
	@Column(name="ESTOQ_MIN",length=12)
	private float estoqMin= 0.000f;
	@Column(name="ESTOQ_ANTERIOR",length=12)
	private float estoqAnterior= 0.000f ;
	
	@ManyToOne
	@JoinColumn(name="produto", referencedColumnName="codigo")
	private Produto produto;
	
	@OneToMany(mappedBy="estoque", targetEntity=EstoqueBaixa.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<EstoqueBaixa> baixas;
	
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

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public float getEstoqMax() {
		return estoqMax;
	}

	public void setEstoqMax(float estoqMax) {
		this.estoqMax = estoqMax;
	}

	public float getEstoqMin() {
		return estoqMin;
	}

	public void setEstoqMin(float estoqMin) {
		this.estoqMin = estoqMin;
	}

	public float getEstoqAnterior() {
		return estoqAnterior;
	}

	public void setEstoqAnterior(float estoqAnterior) {
		this.estoqAnterior = estoqAnterior;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Float.floatToIntBits(estoqAnterior);
		result = prime * result + Float.floatToIntBits(estoqMax);
		result = prime * result + Float.floatToIntBits(estoqMin);
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + Float.floatToIntBits(quantidade);
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
		if (Float.floatToIntBits(estoqAnterior) != Float.floatToIntBits(other.estoqAnterior))
			return false;
		if (Float.floatToIntBits(estoqMax) != Float.floatToIntBits(other.estoqMax))
			return false;
		if (Float.floatToIntBits(estoqMin) != Float.floatToIntBits(other.estoqMin))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (Float.floatToIntBits(quantidade) != Float.floatToIntBits(other.quantidade))
			return false;
		return true;
	}

	
}
