package br.com.barcadero.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDEM_SERVICO_ITENS")
public class OrdemServicoItens extends EntidadeLoja {

	public OrdemServicoItens(Empresa empresa, Loja loja, Usuario usuario) {
		super(empresa, loja, usuario);
		
	}

	private static final long serialVersionUID = 4079218092887460544L;
	@Column(name="DESCRICAO")
	private String descricao;
	@Column(name="QUANTIDADE")
	private String quantidade;
	@Column(name="NR_ITEM")
	private int nrItem;
	
	@ManyToOne(fetch=FetchType.LAZY,targetEntity=OrdemServico.class)
	@JoinColumn(name="cod_os",referencedColumnName="codigo")
	private OrdemServico ordemServico;
	
	@ManyToOne(fetch=FetchType.LAZY,targetEntity=ProdutoLoja.class)
	@JoinColumn(name="cod_produto",referencedColumnName="codigo")
	private ProdutoLoja produto;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
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
	public ProdutoLoja getProduto() {
		return produto;
	}
	public void setProduto(ProdutoLoja produto) {
		this.produto = produto;
	}
	
}
