package br.com.barcadero.tables;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntidadeLoja extends EntidadeEmpresa {
	
	private static final long serialVersionUID = 1L;

	public EntidadeLoja() {
		// TODO Auto-generated constructor stub
	}
	
	public EntidadeLoja(Empresa empresa, Loja loja, Usuario usuario) {
		super(usuario);
		this.setLoja(loja);
		this.setEmpresa(empresa);
	}
	
	public EntidadeLoja(Loja loja, Usuario usuario) {
		super(usuario);
		this.setLoja(loja);
	}
	
	public EntidadeLoja(Usuario usuario) {
		super(usuario);
		// TODO Auto-generated constructor stub
	}

	@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
	@JoinColumn(name="loja",referencedColumnName="codigo")
	private Loja loja;
	
	
	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	
	
}
