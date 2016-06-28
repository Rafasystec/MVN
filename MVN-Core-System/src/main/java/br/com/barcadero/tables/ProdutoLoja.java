package br.com.barcadero.tables;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.barcadero.core.enums.EnumRegimeTributario;
@Entity
@Table(name="PRODUTO_LOJA")
public class ProdutoLoja extends EntidadeLoja {

	
	private static final long serialVersionUID = 1L;
	public ProdutoLoja() {
		// TODO Auto-generated constructor stub
	}
	public ProdutoLoja(Loja loja, Usuario usuario) {
		super(loja, usuario);
	}
	
	private BigDecimal prCusto 	= new BigDecimal(0.00);
	private int qtdMinEstoque	= 0;
	private Enum o; 
	
	@ManyToOne
	@JoinColumn(name="cod_produto", referencedColumnName="codigo")
	private Produto produto;
	
	
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	

}
