package br.com.systeconline.tables.financeiro;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.systeconline.tables.basicos.Entidade;
import br.com.systeconline.tables.basicos.Usuario;

@Entity
public class Usuarios extends Entidade{
	private static final long serialVersionUID = 7317955037945758369L;

	public Usuarios(Usuario usuario) {
		super(usuario);
		// TODO Auto-generated constructor stub
	}
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private long codigo;
	@Column(name="cod_grupo",nullable=false)
	private long codGrupo;
	@Column(name="cod_permissoes",nullable=false)
	private long codPermissoes;
	@Column(name="login",nullable=false,length=30)
	private String login;
	@Column(name="senha",nullable=false,length=60)
	private String senha;
	@Column(name="dt_cadastro",nullable=false)
	private Date dtCadastro;
	@Column(name="nome",nullable=false)
	private String nome;
	@Column(name="cd_emp",nullable=false)
	private long cdEmp;
	
	public long getCdEmp() {
		return cdEmp;
	}
	public void setCdEmp(long cdEmp) {
		this.cdEmp = cdEmp;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
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
	public Date getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	
	
}
