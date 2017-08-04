package br.com.barcadero.tables;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@NamedQueries({
	@NamedQuery(name=ContaPagar.FIND_ALL		 ,query="FROM ContaPagar"),
	@NamedQuery(name=ContaPagar.FIND_BY_DTVENC	 ,query="FROM ContaPagar WHERE dtVencimento = :dtVenc"),
	@NamedQuery(name=ContaPagar.FIND_BY_CODE	 ,query="FROM ContaPagar WHERE codigo = :codigo"),
	@NamedQuery(name=ContaPagar.FIND_VALID_COUNTS,query="FROM ContaPagar WHERE dtVencimento > :dtVenc"),
	@NamedQuery(name=ContaPagar.FIND_CURRENT_MONTH,query="FROM ContaPagar WHERE empresa =:empresa AND dtVencimento BETWEEN :dtIni AND :dtFim")
	
})
@Entity
@Table(name="CONTA_APAGAR")
public class ContaPagar extends EntidadeLoja {
	
	public ContaPagar() {
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 6763710498754248545L;

	public ContaPagar(Loja loja,Usuario usuario) {
		super(loja,usuario);
	}

	public static final String FIND_ALL 			= "ContaPagar.findAll";
	public static final String FIND_BY_CODE			= "ContaPagar.findByCode";
	public static final String FIND_BY_DTVENC 		= "ContaPagar.findByDtVencimento";
	public static final String FIND_VALID_COUNTS 	= "ContaPagar.findValidCount";
	public static final String FIND_CURRENT_MONTH 	= "br.com.barcadero.tables.ContaPagar.findCurrentMonth";
	public static final String PARAM_DT_VENC 		= "dtVenc";
	public static final String PARAM_CODIGO 		= "codigo";
	
	@Column(name="dt_vencimento",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtVencimento;
	@Column(name="qtd_dias_venc",nullable=false)
	private int qtdDiasVenc;
	@Column(name="total",nullable=false)
	private BigDecimal total = new BigDecimal("0.00");
	@Column(name="mora",nullable=false)
	private BigDecimal mora  = new BigDecimal(0d);
	@Column(name="dt_emissao",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtEmissao = new Date();
	@Column(name="nosso_numero",nullable=false,length=15)
	private String nossoNumero = "000000000000000";
	@Column(name="observacao",nullable=false,length=80)
	private String observacao = "";
	@Column(name="NUMERO_PARCELA")
	private int numeroParcela = 0;
	
	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
	@JoinColumn(name="cd_plano",referencedColumnName="codigo")
	private PlanoConta planoConta;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CD_CONTA_LANCAMENTO")
	private ContaLancamento contaLancamento;
	
	public Date getDtVencimento() {
		return dtVencimento;
	}
	public void setDtVencimento(Date dtVencimento) {
		this.dtVencimento = dtVencimento;
	}
	public int getQtdDiasVenc() {
		return qtdDiasVenc;
	}
	public void setQtdDiasVenc(int qtdDiasVenc) {
		this.qtdDiasVenc = qtdDiasVenc;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public BigDecimal getMora() {
		return mora;
	}
	public void setMora(BigDecimal mora) {
		this.mora = mora;
	}
	public Date getDtEmissao() {
		return dtEmissao;
	}
	public void setDtEmissao(Date dtEmissao) {
		this.dtEmissao = dtEmissao;
	}
	public String getNossoNumero() {
		return nossoNumero;
	}
	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getObservacao() {
		return observacao;
	}
	public PlanoConta getPlanoConta() {
		return planoConta;
	}
	public void setPlanoConta(PlanoConta planoConta) {
		this.planoConta = planoConta;
	}
	public ContaLancamento getContaLancamento() {
		return contaLancamento;
	}
	public void setContaLancamento(ContaLancamento contaLancamento) {
		this.contaLancamento = contaLancamento;
	}
	public int getNumeroParcela() {
		return numeroParcela;
	}
	public void setNumeroParcela(int numeroParcela) {
		this.numeroParcela = numeroParcela;
	}
	
}
