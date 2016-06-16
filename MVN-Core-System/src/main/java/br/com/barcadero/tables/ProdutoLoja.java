package br.com.barcadero.tables;

import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="PRODUTO_LOJA")
public class ProdutoLoja extends EntidadeLoja {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ProdutoLoja() {
		// TODO Auto-generated constructor stub
	}
	public ProdutoLoja(Loja loja, Usuario usuario) {
		super(loja, usuario);
	}

}
