package br.com.barcadero.tables;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.barcadero.core.util.GlobalNameParam;

@Entity
@Table(name="LISTA_PRES_MOD_PROD")
public class ListaPresenteModeloProdutos extends EntidadeEmpresa {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1807013757350943188L;
	@ManyToOne
	@JoinColumn(name="lista",referencedColumnName="codigo")
	private ListaPresenteModelo listaModelo;
	@OneToOne
	@JoinColumn(name=GlobalNameParam.PARAM_PRODUTO, referencedColumnName=GlobalNameParam.PARAM_DEFAULT_CODE_COLUMN)
	private Produto produto;
	public ListaPresenteModelo getListaModelo() {
		return listaModelo;
	}
	public void setListaModelo(ListaPresenteModelo listaModelo) {
		this.listaModelo = listaModelo;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
