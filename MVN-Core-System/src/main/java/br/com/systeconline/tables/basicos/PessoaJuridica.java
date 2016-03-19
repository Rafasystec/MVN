package br.com.systeconline.tables.basicos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.systeconline.core.enums.EnumRegimeTributario;
/**
 * Para as entidades que serao pessoas juridicas como: Empresas, lojas, fornecedores e etc.
 * @author Rafael Rocha
 * @since versao 1.0 dia 14/02/2016 as 15:17 
 */
@Entity
@PrimaryKeyJoinColumn(name="cod_pessoa")
@Table(name="pessoajuridica")
public class PessoaJuridica extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2292283049560752201L;

	public PessoaJuridica() {
		// TODO Auto-generated constructor stub
	}
	
	public PessoaJuridica(Usuario usuario) {
		super(usuario);
		// TODO Auto-generated constructor stub
	}
	@Column(name="fantasia",nullable=false,length=60)
	private String fantasia;
	@Column(name="razao_social",nullable=false,length=60)
	private String razaoSocial;
	@Column(name="ie",nullable=false,length=15)
	private String ie;
	@Column(name="cnpj",nullable=false,length=14)
	private String cnpj;
	@Column(name="ie_subst_tributaria",nullable=false,length=15)
	private String ieSubsTributaria;
	@Column(name="im",nullable=false,length=15)
	private String im;
	@Column(name="cnae_fiscal",nullable=false,length=10)
	private String cnaeFiscal = "";
	@Column(name="cod_reg_tribut",nullable=false,length=2)
	@Enumerated(EnumType.ORDINAL)
	private EnumRegimeTributario codRegTribut;
	@Column(name="fone",nullable=false,length=15)
	private String fone;
	@Column(name="uf",nullable=false,length=2)
	private String uf;
	@Column(name="email",nullable=false,length=60)
	private String email;
	@Column(name="web_site",nullable=false,length=60)
	private String webSite;
	@Column(name="dt_ult_alteracao",nullable=false)
	private Date dtUltAlteracao;
	
	public String getFantasia() {
		return fantasia;
	}
	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getIe() {
		return ie;
	}
	public void setIe(String ie) {
		this.ie = ie;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getIeSubsTributaria() {
		return ieSubsTributaria;
	}
	public void setIeSubsTributaria(String ieSubsTributaria) {
		this.ieSubsTributaria = ieSubsTributaria;
	}
	public String getIm() {
		return im;
	}
	public void setIm(String im) {
		this.im = im;
	}
	public String getCnaeFiscal() {
		return cnaeFiscal;
	}
	public void setCnaeFiscal(String cnaeFiscal) {
		this.cnaeFiscal = cnaeFiscal;
	}
	public EnumRegimeTributario getCodRegTribut() {
		return codRegTribut;
	}
	public void setCodRegTribut(EnumRegimeTributario codRegTribut) {
		this.codRegTribut = codRegTribut;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	public Date getDtUltAlteracao() {
		return dtUltAlteracao;
	}
	public void setDtUltAlteracao(Date dtUltAlteracao) {
		this.dtUltAlteracao = dtUltAlteracao;
	}
	
	
}
