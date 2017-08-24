package br.com.barcadero.tables;

import java.math.BigDecimal;
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

import br.com.barcadero.core.enums.EnumAtivo;
import br.com.barcadero.core.enums.EnumEstadoCivil;
import br.com.barcadero.core.enums.EnumSexo;
import br.com.barcadero.core.enums.EnumUF;

/**
 * Classe criada para persistir os funcionarios do sistema
 * @author Rafael Rocha
 * @since Gsind 1.0 Beta 24/09/2013 as 06:38
 */

@NamedQueries({
	@NamedQuery(name=Funcionario.FIND_BY_CODE,query="FROM Funcionario f WHERE codigo = :codigo"),
	@NamedQuery(name=Funcionario.FIND_BY_EMPRESA,query="FROM Funcionario WHERE empresa = :empresa")
})

@Entity
@Table(name="FUNCIONARIO")
public class Funcionario extends EntidadeEmpresa{
	
	public final static String FIND_BY_CODE 	= "br.com.barcadero.tables.funcionario.findByCode";
	public final static String FIND_BY_EMPRESA 	= "br.com.barcadero.tables.funcionario.findByEmpresa";
	
	public Funcionario() {		
	}
	private static final long serialVersionUID = -3927665040219416759L;
	public Funcionario(Usuario usuario,Empresa empresa) {
		super(empresa, usuario);
	}
	@Column(name="cod_interno")
	private long codInterno = 0;
	@Column(name="cod_filiacao")
	private long codFiliacao = 0;
	@Column(name="cod_centro_custo")
	private long codCentroCusto = 0;
	@Column(name="pis",length=15)
	private String pis = "";
	@Column(name="fgts",length=15)
	private String fgts = "";
	@Column(name="cart_trabalho",length=15)
	private String cartTrabalho = "";
	@Column(name="NOME_PAI",nullable=false)
	private String nomePai;
	@Column(name="NOME_MAE",nullable=false)
	private String nomeMae = "";
	@Column(name="NOME_CONJUGE")
	private String nomeConjuge = "";
	@Column(name="DT_ADMISSAO",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtAdmissao = new Date();
	@Column(name="DT_DEMISSAO")
	private Date dtDemissao = null;
	@Column(name="SALARIO_INICIAL")
	private BigDecimal salarioInicial = new BigDecimal(0);
	@Column(name="OBSERVACOES")
	private String observacoes = "";
	
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
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="ENDERECO",referencedColumnName="CODIGO")
	private Endereco endereco = null;
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public long getCodInterno() {
		return codInterno;
	}

	public void setCodInterno(long codInterno) {
		this.codInterno = codInterno;
	}

	public long getCodFiliacao() {
		return codFiliacao;
	}

	public void setCodFiliacao(long codFiliacao) {
		this.codFiliacao = codFiliacao;
	}

	public long getCodCentroCusto() {
		return codCentroCusto;
	}

	public void setCodCentroCusto(long codCentroCusto) {
		this.codCentroCusto = codCentroCusto;
	}

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public String getFgts() {
		return fgts;
	}

	public void setFgts(String fgts) {
		this.fgts = fgts;
	}

	public String getCartTrabalho() {
		return cartTrabalho;
	}

	public void setCartTrabalho(String cartTrabalho) {
		this.cartTrabalho = cartTrabalho;
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

	public Date getDtAdmissao() {
		return dtAdmissao;
	}

	public void setDtAdmissao(Date dtAdmissao) {
		this.dtAdmissao = dtAdmissao;
	}

	public Date getDtDemissao() {
		return dtDemissao;
	}

	public void setDtDemissao(Date dtDemissao) {
		this.dtDemissao = dtDemissao;
	}

	public String getNomeConjuge() {
		return nomeConjuge;
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

	public void setNomeConjuge(String nomeConjuge) {
		this.nomeConjuge = nomeConjuge;
	}

	public BigDecimal getSalarioInicial() {
		return salarioInicial;
	}

	public void setSalarioInicial(BigDecimal salarioInicial) {
		this.salarioInicial = salarioInicial;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	
}
