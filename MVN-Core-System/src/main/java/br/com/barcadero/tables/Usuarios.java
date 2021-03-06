package br.com.barcadero.tables;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Usuarios extends Entidade{
	private static final long serialVersionUID = 7317955037945758369L;

	public Usuarios() {
		// TODO Auto-generated constructor stub
	}
	public Usuarios(Usuario usuario) {
		super(usuario);
	}
	
	@Column(name="cod_grupo",nullable=false)
	private long codGrupo;
	@Column(name="cod_permissoes",nullable=false)
	private long codPermissoes;
	@Column(name="login",nullable=false,length=30)
	private String login;
	@Column(name="senha",nullable=false,length=60)
	private String senha;
	@Column(name="nome",nullable=false)
	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getCodGrupo() {
		return codGrupo;
	}
	public void setCodGrupo(long codGrupo) {
		this.codGrupo = codGrupo;
	}
	public long getCodPermissoes() {
		return codPermissoes;
	}
	public void setCodPermissoes(long codPermissoes) {
		this.codPermissoes = codPermissoes;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
