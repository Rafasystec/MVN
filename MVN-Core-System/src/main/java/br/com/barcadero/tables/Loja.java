package br.com.barcadero.tables;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.barcadero.core.enums.EnumRegimeTributario;
import br.com.barcadero.module.sat.enums.EnumCFeXMLVersion;
import br.com.barcadero.module.sat.enums.EnumIndRatISSQN;

@NamedQueries({
	@NamedQuery(name=Loja.FIND_ALL, query="FROM Loja WHERE empresa = :empresa"),
	@NamedQuery(name=Loja.FIND_BY_EMP,query="FROM Loja WHERE empresa = :empresa")
})

@Entity
@Table(name="LOJA")
public class Loja extends EntidadeEmpresa {

	private static final long serialVersionUID = 5116884318377500706L;

	public Loja() {
	}
	
	public Loja(Usuario usuario) {
		super(usuario);
	}
	public static final String FIND_ALL 	= "Loja.findAll";
	public static final String FIND_BY_EMP	= "Loja.findByEmp";
	@Column(name="VERSAO_XML_CFE")
	private EnumCFeXMLVersion verXMLCFe = EnumCFeXMLVersion.V_0_06;
	@Column(name="SIGN_AC_SAT",length=344)
	private String signAC = "SGR-SAT SISTEMA DE GESTAO E RETAGUARDA DO SAT";
	@Column(name="IND_RAT_ISSQN_CFE")
	@Enumerated(EnumType.STRING)
	private EnumIndRatISSQN indRatISSQNSAT = EnumIndRatISSQN.NAO;
	@Column(name="fantasia",nullable=false,length=60)
	private String fantasia;
	@Column(name="razao_social",nullable=false,length=60)
	private String razaoSocial;
	@Column(name="ie",nullable=false,length=15)
	private String ie = "149626224113";
	@Column(name="cnpj",nullable=false,length=14)
	private String cnpj = "08723218000186";
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
	@Column(name="dt_inauguracao")
	@Temporal(TemporalType.DATE)
	private Date dtInauguracao = new Date();
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="ENDERECO",referencedColumnName="CODIGO")
	private Endereco endereco = null;
	
	public Date getDtInauguracao() {
		return dtInauguracao;
	}
	public void setDtInauguracao(Date dtInauguracao) {
		this.dtInauguracao = dtInauguracao;
	}

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

	public EnumCFeXMLVersion getVerXMLCFe() {
		return verXMLCFe;
	}

	public void setVerXMLCFe(EnumCFeXMLVersion verXMLCFe) {
		this.verXMLCFe = verXMLCFe;
	}

	public String getSignAC() {
		return signAC;
	}

	public void setSignAC(String signAC) {
		this.signAC = signAC;
	}

	public EnumIndRatISSQN getIndRatISSQNSAT() {
		return indRatISSQNSAT;
	}

	public void setIndRatISSQNSAT(EnumIndRatISSQN indRatISSQNSAT) {
		this.indRatISSQNSAT = indRatISSQNSAT;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}
