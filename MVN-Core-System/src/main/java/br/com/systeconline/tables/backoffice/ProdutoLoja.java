package br.com.systeconline.tables.backoffice;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.systeconline.tables.basicos.EntidadeLoja;
import br.com.systeconline.tables.basicos.Loja;
import br.com.systeconline.tables.basicos.Usuario;
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
