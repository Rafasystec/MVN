package br.com.systeconline.tables.basicos;
import javax.persistence.CascadeType;
import javax.persistence.Column;
/**
 * Classe criada para persistir o endereco dos Filiados, funcionarios ou qualquer outra pressoa
 * @author Rafael Rocha
 * @since Gsind 1.0 Beta 24/09/2013 : 06:20
 */
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.systeconline.core.enums.EnumTipoLograd;

@Entity
public class Endereco extends Entidade{
	public Endereco() {
		// TODO Auto-generated constructor stub
	}
	
	private static final long serialVersionUID = -1696667317211901817L;
	public Endereco(Usuario usuario) {
		super(usuario);
		// TODO Auto-generated constructor stub
	}
	@Column(name="cod_bairro",nullable=false)
	private long codBairro;
	@Column(name="tipo",nullable=false)
	private String tipo = ""; //Indica se o endereco eh de entrega, comercial e etc...
	@Column(name="numero",nullable=false,length=10)
	private String numero = "";
	@Column(name="cep",nullable=false,length=10)
	private String cep = "";
	@Column(name="logradouro",nullable=false)
	private String logradouro = "";
	@Enumerated(EnumType.STRING)
	@Column(name="tp_lograd",nullable=false,length=25)
	private EnumTipoLograd tpLogradouro;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_pessoa")
	private Pessoa pessoa;
	//------------------------------------------------
	//Methods Getters and Setters
	//------------------------------------------------
	public long getCodBairro() {
		return codBairro;
	}
	public void setCodBairro(long codBairro) {
		this.codBairro = codBairro;
	}

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public EnumTipoLograd getTpLogradouro() {
		return tpLogradouro;
	}
	public void setTpLogradouro(EnumTipoLograd tpLogradouro) {
		this.tpLogradouro = tpLogradouro;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
		
}
