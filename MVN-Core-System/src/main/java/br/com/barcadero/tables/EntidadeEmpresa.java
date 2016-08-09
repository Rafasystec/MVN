package br.com.barcadero.tables;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntidadeEmpresa extends Entidade {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntidadeEmpresa() {
		// TODO Auto-generated constructor stub
	}
	
	public EntidadeEmpresa(Empresa empresa,Usuario usuario){
		super(usuario);
		this.setEmpresa(empresa);
	}
	

	public EntidadeEmpresa(Usuario usuario) {
		super(usuario);
		// TODO Auto-generated constructor stub
	}

	@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
	@JoinColumn(name="empresa",referencedColumnName="codigo")
	private Empresa empresa;

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntidadeEmpresa other = (EntidadeEmpresa) obj;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		return true;
	}
	
}
