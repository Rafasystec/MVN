package br.com.barcadero.tables;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="MARCAS")
public class Marcas extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8887073573849216733L;
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
