package br.com.systeconline.tables.basicos;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe criada para persistir os funcionarios do sistema
 * @author Rafael Rocha
 * @since Gsind 1.0 Beta 24/09/2013 as 06:38
 */

@NamedQueries({
	@NamedQuery(name=Funcionario.FIND_BY_CODE,query="FROM Funcionario f WHERE codigo = :codigo")
})

@Entity
@Table(name="FUNCIONARIO")
public class Funcionario extends Entidade{
	
	public final static String FIND_BY_CODE = "funcionario.findByCode";
	
	public Funcionario() {
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = -3927665040219416759L;
	public Funcionario(Usuario usuario) {
		super(usuario);
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
	
	@ManyToOne
	@JoinColumn(name="COD_EMP",referencedColumnName="codigo")
	private Empresa empresa;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_pessoa", referencedColumnName="codigo")
	private PessoaFisica pessoaFisica = new PessoaFisica();
	
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
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

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public String getNomeConjuge() {
		return nomeConjuge;
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
