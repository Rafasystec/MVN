package br.com.barcadero.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MEDICOS")
public class Medicos extends Entidade {
	
	
	private static final long serialVersionUID = -348936082706054134L;
	@Column(name="NOME")
	private String nome;
	@Column(name="CRM")
	private String crm;
	@Column(name="TELEFONE")
	private String telefone;
	
	@ManyToOne
	@JoinColumn(name="cod_endereco", referencedColumnName="codigo")
	private Endereco endereco;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	

}
