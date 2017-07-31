package br.com.barcadero.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name=Bancos.FIND_BY_EMPRESA,query="FROM Bancos WHERE empresa = :"+Entidade.PARAM_EMPRESA)
	
})

@Entity
@Table(name="BANCOS")
public class Bancos extends EntidadeEmpresa {

	public static final String FIND_BY_EMPRESA = "br.com.barcadero.tables.Bancos.findByEmpresa";
	
	public Bancos() {
		
	}
	
	public Bancos(Empresa empresa) {
		setEmpresa(empresa);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -7337805333217740903L;
	@Column(name="COD_BANCO",nullable=false,length=5)
	private String codBanco  = "";
	@Column(name="DESCRICAO",nullable=false,length=50)
	private String descricao = "";
	@Column(name="SITE",nullable=false,length=60)
	private String site      = "";
	@Column(name="CONTATO_1",nullable=false,length=20)
	private String contato1  = "";
	@Column(name="CONTATO_2",nullable=false,length=20)
	private String contato2  = "";
	@Column(name="EMAIL",nullable=false,length=60)
	private String email	 = "";
	@Column(name="NOME_GERENTE",nullable=false,length=60)
	private String nomeGerente="";
	
	public String getCodBanco() {
		return codBanco;
	}
	public void setCodBanco(String codBanco) {
		this.codBanco = codBanco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getContato1() {
		return contato1;
	}
	public void setContato1(String contato1) {
		this.contato1 = contato1;
	}
	public String getContato2() {
		return contato2;
	}
	public void setContato2(String contato2) {
		this.contato2 = contato2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNomeGerente() {
		return nomeGerente;
	}
	public void setNomeGerente(String nomeGerente) {
		this.nomeGerente = nomeGerente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codBanco == null) ? 0 : codBanco.hashCode());
		result = prime * result + ((contato1 == null) ? 0 : contato1.hashCode());
		result = prime * result + ((contato2 == null) ? 0 : contato2.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nomeGerente == null) ? 0 : nomeGerente.hashCode());
		result = prime * result + ((site == null) ? 0 : site.hashCode());
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
		Bancos other = (Bancos) obj;
		if (codBanco == null) {
			if (other.codBanco != null)
				return false;
		} else if (!codBanco.equals(other.codBanco))
			return false;
		if (contato1 == null) {
			if (other.contato1 != null)
				return false;
		} else if (!contato1.equals(other.contato1))
			return false;
		if (contato2 == null) {
			if (other.contato2 != null)
				return false;
		} else if (!contato2.equals(other.contato2))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nomeGerente == null) {
			if (other.nomeGerente != null)
				return false;
		} else if (!nomeGerente.equals(other.nomeGerente))
			return false;
		if (site == null) {
			if (other.site != null)
				return false;
		} else if (!site.equals(other.site))
			return false;
		return true;
	}
	
	
	
}
