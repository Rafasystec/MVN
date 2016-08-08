package br.com.barcadero.core.xml.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="produtos")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLProdutoLote {
	
	private List<XMLProduto> produtos;

	public List<XMLProduto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<XMLProduto> produtos) {
		this.produtos = produtos;
	}
	

}
