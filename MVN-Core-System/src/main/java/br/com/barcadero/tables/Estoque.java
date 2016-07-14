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
	private int quantidade = 0;
	@Column(name="ESTOQ_MAX",length=12)
	private int estoqMax = 0;
	@Column(name="ESTOQ_MIN",length=12)
	private int estoqMin= 0;
	@Column(name="ESTOQ_ANTERIOR",length=12)
	private int estoqAnterior= 0 ;
	
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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getEstoqMax() {
		return estoqMax;
	}

	public void setEstoqMax(int estoqMax) {
		this.estoqMax = estoqMax;
	}

	public int getEstoqMin() {
		return estoqMin;
	}

	public void setEstoqMin(int estoqMin) {
		this.estoqMin = estoqMin;
	}

	public int getEstoqAnterior() {
		return estoqAnterior;
	}

	public void setEstoqAnterior(int estoqAnterior) {
		this.estoqAnterior = estoqAnterior;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((baixas == null) ? 0 : baixas.hashCode());
		result = prime * result + estoqAnterior;
		result = prime * result + estoqMax;
		result = prime * result + estoqMin;
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + quantidade;
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
		if (baixas == null) {
			if (other.baixas != null)
				return false;
		} else if (!baixas.equals(other.baixas))
			return false;
		if (estoqAnterior != other.estoqAnterior)
			return false;
		if (estoqMax != other.estoqMax)
			return false;
		if (estoqMin != other.estoqMin)
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (quantidade != other.quantidade)
			return false;
		return true;
	}
	
}
