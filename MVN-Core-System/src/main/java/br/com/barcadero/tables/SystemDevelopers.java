package br.com.barcadero.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SYSTEM_DEVELOPERS")
public class SystemDevelopers extends Entidade {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1871180413874796326L;
	@Column(name="NOME",length=60)
	private String nome;
	@Column(name="EMAIL",length=60)
	private String email;
	@Column(name="TELEFONE",length=15)
	private String telefone;
	@Column(name="BREVE_DESCRICAO",length=180)
	private String breveDescricao;
	@Column(name="FOTO",length=10000)
	private String foto;
	@Column(name="PAGE",length=45)
	private String page;
	
	@ManyToOne
	@JoinColumn(name="system", referencedColumnName="codigo")
	private SystemProperties system;
	
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
	public String getBreveDescricao() {
		return breveDescricao;
	}
	public void setBreveDescricao(String breveDescricao) {
		this.breveDescricao = breveDescricao;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public SystemProperties getSystem() {
		return system;
	}
	public void setSystem(SystemProperties system) {
		this.system = system;
	}

}
