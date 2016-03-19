package br.com.systeconline.tables.basicos;

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

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	
}
