package br.com.barcadero.tables;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Pessoa extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = -632374975617338535L;

	public Pessoa() {
		// TODO Auto-generated constructor stub
	}
	
	public Pessoa(Usuario usuario) {
		super(usuario);
		// TODO Auto-generated constructor stub
	}

	@OneToMany(mappedBy="pessoa",cascade=CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<Endereco>();

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	
}
