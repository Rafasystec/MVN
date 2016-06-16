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

	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
	@JoinColumn(name="cd_emp",referencedColumnName="codigo")
	private Empresa empresa;

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
}
