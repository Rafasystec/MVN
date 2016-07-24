package br.com.barcadero.tables;
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
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_pessoa")
	private Pessoa pessoa;
	@Column(name="UF",nullable=false)
	@Enumerated(EnumType.STRING)
	private EnumUF uf = EnumUF.AC;
	@Column(name="CIDADE",nullable=false)
	private String cidade = "";
//	@Column(name="BAIRRO",nullable=false)
//	private String bairro = "";
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
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + (int) (codBairro ^ (codBairro >>> 32));
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((referencia == null) ? 0 : referencia.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((tpLogradouro == null) ? 0 : tpLogradouro.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (codBairro != other.codBairro)
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (referencia == null) {
			if (other.referencia != null)
				return false;
		} else if (!referencia.equals(other.referencia))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (tpLogradouro != other.tpLogradouro)
			return false;
		if (uf != other.uf)
			return false;
		return true;
	}
		
}
