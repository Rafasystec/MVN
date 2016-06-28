package br.com.barcadero.tables;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntidadeLoja extends Entidade {
	
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

	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
	@JoinColumn(name="cd_loja",referencedColumnName="codigo")
	private Loja loja;
	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY,targetEntity=Empresa.class)
	@JoinColumn(name="cod_empresa",referencedColumnName="codigo")
	private Empresa empresa;

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
}
