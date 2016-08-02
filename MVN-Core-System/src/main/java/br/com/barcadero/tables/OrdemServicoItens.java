package br.com.barcadero.tables;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.barcadero.core.util.GlobalNameParam;

@NamedQueries({
	@NamedQuery(name=OrdemServicoItens.FIND_ALL		,query="FROM OrdemServicoItens WHERE empresa = :empresa"),
	@NamedQuery(name=OrdemServicoItens.FIND_BY_OS	,query="FROM OrdemServicoItens WHERE empresa = :empresa AND ordemservico = :ordemservico")
})
@Entity
@Table(name="ORDEM_SERVICO_ITENS")
public class OrdemServicoItens extends EntidadeLoja {

	public static final String FIND_ALL 	= "OrdemServicoItens.findAll";
	public static final String FIND_BY_OS 	= "OrdemServicoItens.findByOS";
	public OrdemServicoItens(Empresa empresa, Loja loja, Usuario usuario) {
		super(empresa, loja, usuario);
		
	}

	private static final long serialVersionUID = 4079218092887460544L;
	@Column(name="DESCRICAO")
	private String descricao;
	@Column(name="QUANTIDADE")
	private float quantidade = 0.000f;
	@Column(name="NR_ITEM")
	private int nrItem;
	@Column(name="VALOR_UNITARIO")
	private BigDecimal valorUnitario;
	@Column(name="VALOR_TOTAL")
	private BigDecimal valorTotal;
	
	@ManyToOne(fetch=FetchType.LAZY,targetEntity=OrdemServico.class)
	@JoinColumn(name="ordemservico",referencedColumnName="codigo")
	private OrdemServico ordemServico;
	
	@OneToOne
	@JoinColumn(name=GlobalNameParam.PARAM_PRODUTO, referencedColumnName=GlobalNameParam.PARAM_DEFAULT_CODE_COLUMN)
	private Produto produto;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}
	public int getNrItem() {
		return nrItem;
	}
	public void setNrItem(int nrItem) {
		this.nrItem = nrItem;
	}
	public OrdemServico getOrdemServico() {
		return ordemServico;
	}
	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
