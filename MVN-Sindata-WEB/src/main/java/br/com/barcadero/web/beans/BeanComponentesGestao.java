package br.com.barcadero.web.beans;

/**
 * Classe criada dia 10/10/2013 as 22:17
 * @author Rafael Rocha
 */

public class BeanComponentesGestao {
	private String cargo;
	private String nome;
	private String email;
	private String telefone;
	//NOTE: Codigo da gestão ao qual pertence(Classe gestão entidade)
	private long codGestao;
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
