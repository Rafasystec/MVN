package br.com.barcadero.tables;
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
import javax.persistence.OneToOne;

import br.com.barcadero.core.enums.EnumTipoLograd;
import br.com.barcadero.core.enums.EnumUF;
import br.com.barcadero.core.util.GlobalNameParam;

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
	@Column(name="UF",nullable=false)
	@Enumerated(EnumType.STRING)
	private EnumUF uf = EnumUF.AC;
	@Column(name="CIDADE",nullable=false)
	private String cidade = "";
	@Column(name="COMPLEMENTO",nullable=false)
	private String complemento = "";
	@Column(name="REFERENCIA",nullable=false)
	private String referencia = "";
	
	@OneToOne
	@JoinColumn(name="bairro",referencedColumnName=GlobalNameParam.PARAM_DEFAULT_CODE_COLUMN)
	private Bairro bairro;
	
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
	public EnumUF getUf() {
		return uf;
	}
	public void setUf(EnumUF uf) {
		this.uf = uf;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public Bairro getBairro() {
		return bairro;
	}
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
			
}
