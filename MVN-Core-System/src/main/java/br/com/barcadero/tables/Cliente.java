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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.barcadero.core.enums.EnumAtivo;
import br.com.barcadero.core.enums.EnumEstadoCivil;
import br.com.barcadero.core.enums.EnumRegimeTributario;
import br.com.barcadero.core.enums.EnumSexo;
import br.com.barcadero.core.enums.EnumTipoPessoa;
import br.com.barcadero.core.enums.EnumUF;

@NamedQueries({
			@NamedQuery(name=Cliente.FIND		 			,query="FROM Cliente WHERE empresa = :empresa"),
			@NamedQuery(name=Cliente.FIND_BY_CODE			,query="FROM Cliente WHERE codigo = :codigo"),
			@NamedQuery(name=Cliente.FIND_CLIENTES_CAD_HOJE	,query="FROM Cliente WHERE empresa = :empresa AND dtCadastro = :dtCadastro"),
			@NamedQuery(name=Cliente.FIND_BY_NAME_OR_CODIGO	,query="FROM Cliente c WHERE c.empresa = :empresa AND (c.codigo = :codigo OR c.nome LIKE :nome)")
			
})
@Entity
@Table(name="CLIENTE")
public class Cliente extends EntidadeEmpresa{

	
	private static final long serialVersionUID = 6408718672593326415L;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(Empresa empresa, Usuario usuario) {
		super(empresa, usuario);
		// TODO Auto-generated constructor stub
	}
	public final static String FIND 					= "Cliente.find";
	public final static String FIND_CLIENTES_CAD_HOJE	= "Cliente.findClienteCadHoje";
	public final static String FIND_BY_CODE 			= "Cliente.findByCode";
	public final static String FIND_BY_NAME_OR_CODIGO 	= "Cliente.findByNameOrCodigo";

	
	@Column(name="NOME_PAI",nullable=false)
	private String nomePai = "";
	@Column(name="NOME_MAE",nullable=false)
	private String nomeMae = "";
	@Column(name="TIPO_PESSOA")
	@Enumerated(EnumType.STRING)
	private EnumTipoPessoa tipoPessoa = EnumTipoPessoa.FISICA;

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
	@Column(name="web_site",nullable=false,length=60)
	private String webSite;
	@Column(name="dt_ult_alteracao",nullable=false)
	private Date dtUltAlteracao;
	@Column(name="email",nullable=false)
	private String email = "";
	@Column(name="matricula", nullable=false)
	private long matricula = 0;
	@Column(name="tipo",length=2,nullable=false)
	private String tipo = "";
	@Column(length=100,nullable=false)
	private String nome = "";
	@Column(nullable=false)
	private int sessao = 0;
	@Column(nullable=false)
	private int zona = 0;
	@Column(name="observacao",length=200,nullable=false)
	private String observacao = "";
	@Column(length=40,nullable=false)
	private String profissao = "";
	@Column(length=50,nullable=false)
	private String instrucao = "";
	@Column(name="estado_civil",length=20,nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumEstadoCivil estCivil = EnumEstadoCivil.SOLTEIRO;
	@Column(name="sexo",length=1,nullable=false)
	@Enumerated(EnumType.STRING)
	private EnumSexo sexo = EnumSexo.M;
	@Column(length=30)
	private String ocupacao = "";
	@Column(length=15,nullable=false)
	private String cpf = "";
	@Column(length=20,nullable=false)
	private String rg = "";
	@Column(name="emissor_rg",length=15,nullable=false)
	private String emissorRg = "";
	@Column(name="habilitacao",length=20,nullable=false)
	private String habilitacao = "";
	@Column(name="categoria",length=5,nullable=false)
	private String categoria = "";
	@Column(name="titulo",length=20,nullable=false)
	private String titulo = "";
	@Column(name="nacionalidade",length=30,nullable=false)
	private String nacionalidade = "";
	@Column(name="naturalidade",length=30,nullable=false)
	private String naturalidade = "";
	@Column(name="dt_nascimento",nullable=false)
	private Date dtNascimento;
	
	@Column(name="fl_status",length=3,nullable=false)
	@Enumerated(EnumType.STRING)
	private EnumAtivo flStatus= EnumAtivo.S;
	
	@Column(name="telefone",nullable=false)
	private String telefone = "0";
	@Column(name="celular",nullable=false)
	private String celular = "0";
	@Column(name="uf_natural",nullable=false)
	@Enumerated(EnumType.STRING)
	private EnumUF ufNatural = EnumUF.AC;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="cliente", targetEntity=OrdemServico.class)
	private List<OrdemServico> ordensServicos;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="ENDERECO",referencedColumnName="CODIGO")
	private Endereco endereco = null;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public List<OrdemServico> getOrdensServicos() {
		return ordensServicos;
	}

	public void setOrdensServicos(List<OrdemServico> ordensServicos) {
		this.ordensServicos = ordensServicos;
	}

	public EnumTipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(EnumTipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSessao() {
		return sessao;
	}

	public void setSessao(int sessao) {
		this.sessao = sessao;
	}

	public int getZona() {
		return zona;
	}

	public void setZona(int zona) {
		this.zona = zona;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getInstrucao() {
		return instrucao;
	}

	public void setInstrucao(String instrucao) {
		this.instrucao = instrucao;
	}

	public EnumEstadoCivil getEstCivil() {
		return estCivil;
	}

	public void setEstCivil(EnumEstadoCivil estCivil) {
		this.estCivil = estCivil;
	}

	public EnumSexo getSexo() {
		return sexo;
	}

	public void setSexo(EnumSexo sexo) {
		this.sexo = sexo;
	}

	public String getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmissorRg() {
		return emissorRg;
	}

	public void setEmissorRg(String emissorRg) {
		this.emissorRg = emissorRg;
	}

	public String getHabilitacao() {
		return habilitacao;
	}

	public void setHabilitacao(String habilitacao) {
		this.habilitacao = habilitacao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public EnumAtivo getFlStatus() {
		return flStatus;
	}

	public void setFlStatus(EnumAtivo flStatus) {
		this.flStatus = flStatus;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public EnumUF getUfNatural() {
		return ufNatural;
	}

	public void setUfNatural(EnumUF ufNatural) {
		this.ufNatural = ufNatural;
	}
}
