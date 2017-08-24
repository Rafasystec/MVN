package br.com.barcadero.tables;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import br.com.barcadero.core.enums.EnumAtividadeEmp;
/**
 * Classe de pesistencia para o cadastro das empresas no sistema.
 * @author Rafael Rocha
 * Nao foi datado o momento da criacao dessa classe pois veio do projeto gsind.
 */
import br.com.barcadero.core.enums.EnumRegimeISSQN;
import br.com.barcadero.core.enums.EnumRegimeTributario;

@NamedQueries({
	@NamedQuery(name=Empresa.FIND			,query="FROM Empresa WHERE codigo = :codigo"),
	@NamedQuery(name=Empresa.FIND_ALL		,query="FROM Empresa"),
	@NamedQuery(name=Empresa.FIND_BY_CODE	,query="FROM Empresa e WHERE e.codigo = :empresa")
})

@Entity
public class Empresa extends Entidade {
	public static final String EMPRESA = "empresa";
	
	private static final long serialVersionUID = 6135467736845199870L;

	public Empresa() {
	}
	
	public Empresa(Usuario usuario) {
		super(usuario);
	}
	public final static String FIND			= "Empresa.find";
	public final static String FIND_ALL 	= "Empresa.FindAll";
	public final static String FIND_BY_CODE	= "Empresa.findByCode";
	
	@Column(name="atividade", nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumAtividadeEmp atividade = EnumAtividadeEmp.COMERCIO;
	@Column(name="img_logo", nullable=false)
	private String imgLogo = "";
	@Column(name="dt_fundacao", nullable=false)
	private Date dtFundacao = new Date();
	@Column(name="observacoes", nullable=false)
	private String observacoes = "";
	@Column(name="CNPJ_SOFTWARE_HOUSE")
	private String cnpjSoftwareHouse = "16716114000172";
	@Column(name="REGIME_TRIBUTACAO_ISSQN")
	@Enumerated(EnumType.ORDINAL)
	private EnumRegimeISSQN regimeISSQN = EnumRegimeISSQN.MICROEMPRESARIO_INDIVIDUAL;
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
	
	@ManyToMany(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	@JoinTable(name="empresa_usuario",joinColumns={
		@JoinColumn(name="empresa_id",nullable=false, updatable=false)
	}, inverseJoinColumns = {@JoinColumn(name="user_id",nullable=false, updatable=false)})
	private List<Usuario> usuarios;
	@OneToMany(mappedBy="empresa", targetEntity=Loja.class, fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	private List<Loja> lojas;
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public EnumAtividadeEmp getAtividade() {
		return atividade;
	}
	public void setAtividade(EnumAtividadeEmp atividade) {
		this.atividade = atividade;
	}
	public String getImgLogo() {
		return imgLogo;
	}
	public void setImgLogo(String imgLogo) {
		this.imgLogo = imgLogo;
	}
	public Date getDtFundacao() {
		return dtFundacao;
	}
	public void setDtFundacao(Date dtFundacao) {
		this.dtFundacao = dtFundacao;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public List<Loja> getLojas() {
		return lojas;
	}

	public void setLojas(List<Loja> lojas) {
		this.lojas = lojas;
	}

	public String getCnpjSoftwareHouse() {
		return cnpjSoftwareHouse;
	}

	public void setCnpjSoftwareHouse(String cnpjSoftwareHouse) {
		this.cnpjSoftwareHouse = cnpjSoftwareHouse;
	}

	public EnumRegimeISSQN getRegimeISSQN() {
		return regimeISSQN;
	}

	public void setRegimeISSQN(EnumRegimeISSQN regimeISSQN) {
		this.regimeISSQN = regimeISSQN;
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
	

}
