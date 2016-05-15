package br.com.systeconline.tables.basicos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="VENDEDOR")
public class Vendedor extends EntidadeLoja{

	private static final long serialVersionUID = -7368157567275782914L;
	private Usuario usuario;
	
	public Vendedor(Loja loja, Usuario usuario) {
		// TODO Auto-generated constructor stub
		super(loja, usuario);
		setUsuario(usuario);
	}
		
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_pessoa", referencedColumnName="codigo")
	private Funcionario funcionario = new Funcionario(getUsuario());

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
}
