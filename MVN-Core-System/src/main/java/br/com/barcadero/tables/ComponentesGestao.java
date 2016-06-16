package br.com.barcadero.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ComponentesGestao")
public class ComponentesGestao extends Entidade{
	private static final long serialVersionUID = 7446425245435925375L;

	public ComponentesGestao(Usuario usuario) {
		super(usuario);
		// TODO Auto-generated constructor stub
	}

	@Column(name="cargo",length=50,nullable=false)
	private String cargo;
	@Column(name="nome",length=60,nullable=false)
	private String nome;
	
	@Column(name="email",length=35,nullable=false)
	private String email;
	@Column(name="telefone",length=12,nullable=false)
	private String telefone;
	
	@Column(name="cod_gestao",length=3,nullable=false)
	private long codGestao; //Codigo da gestão ao qual pertence(Classe gestão entidade)
	
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public long getCodGestao() {
		return codGestao;
	}

	public void setCodGestao(long codGestao) {
		this.codGestao = codGestao;
	}

}
