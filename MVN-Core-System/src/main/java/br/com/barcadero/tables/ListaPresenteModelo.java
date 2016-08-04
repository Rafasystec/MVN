package br.com.barcadero.tables;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="LISTA_PRESENT_MODELO")
public class ListaPresenteModelo extends EntidadeEmpresa {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -711058771777945556L;
	@OneToMany(mappedBy="listaModelo",cascade=CascadeType.ALL,targetEntity=ListaPresenteModeloProdutos.class,fetch=FetchType.EAGER)
	List<ListaPresenteModeloProdutos> produtos;

	public List<ListaPresenteModeloProdutos> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ListaPresenteModeloProdutos> produtos) {
		this.produtos = produtos;
	}
	
	
	

}
