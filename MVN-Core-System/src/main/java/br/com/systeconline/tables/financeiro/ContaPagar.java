package br.com.systeconline.tables.financeiro;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.systeconline.core.enums.EnumTipoContaPagar;
import br.com.systeconline.tables.basicos.EntidadeLoja;
import br.com.systeconline.tables.basicos.Loja;
import br.com.systeconline.tables.basicos.Usuario;
@NamedQueries({
	@NamedQuery(name=ContaPagar.FIND_ALL		 ,query="FROM ContaPagar"),
	@NamedQuery(name=ContaPagar.FIND_BY_DTVENC	 ,query="FROM ContaPagar WHERE dtVencimento = :dtVenc"),
	@NamedQuery(name=ContaPagar.FIND_BY_CODE	 ,query="FROM ContaPagar WHERE codigo = :codigo"),
	@NamedQuery(name=ContaPagar.FIND_VALID_COUNTS,query="FROM ContaPagar WHERE dtVencimento > :dtVenc")
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
	public static final String PARAM_DT_VENC 		= "dtVenc";
	public static final String PARAM_CODIGO 		= "codigo";
	
	@Column(name="dt_vencimento",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtVencimento;
	@Column(name="qtd_dias_venc",nullable=false)
	private int qtdDiasVenc;
	@Column(name="total",nullable=false)
	private BigDecimal total;
	@Column(name="tipo",nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumTipoContaPagar tipo;
	@Column(name="conta",nullable=false, length=15)
	private String conta  = "";
	@Column(name="pc_juros_am",nullable=false)
	private BigDecimal pcJurosAM = new BigDecimal(0d);
	@Column(name="mora",nullable=false)
	private BigDecimal mora  = new BigDecimal(0d);
	@Column(name="mora_dia",nullable=false)
	private BigDecimal moraDia = new BigDecimal(0d);
	@Column(name="agencia_benef",nullable=false)
	private long agenciaBenef = 0;
	@Column(name="conta_benef",nullable=false)
	private long contaBenef = 0;
	@Column(name="dt_emissao",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtEmissao = new Date();
	@Column(name="nosso_numero",nullable=false,length=15)
	private String nossoNumero = "000000000000000";
	@Column(name="observacao",nullable=false,length=80)
	private String observacao = "";
	
	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
	@JoinColumn(name="cd_plano",referencedColumnName="codigo")
	private PlanoConta planoConta;
		
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
	public EnumTipoContaPagar getTipo() {
		return tipo;
	}
	public void setTipo(EnumTipoContaPagar tipo) {
		this.tipo = tipo;
	}
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public BigDecimal getPcJurosAM() {
		return pcJurosAM;
	}
	public void setPcJurosAM(BigDecimal pcJurosAM) {
		this.pcJurosAM = pcJurosAM;
	}
	public BigDecimal getMora() {
		return mora;
	}
	public void setMora(BigDecimal mora) {
		this.mora = mora;
	}
	public BigDecimal getMoraDia() {
		return moraDia;
	}
	public void setMoraDia(BigDecimal moraDia) {
		this.moraDia = moraDia;
	}
	public long getAgenciaBenef() {
		return agenciaBenef;
	}
	public void setAgenciaBenef(long agenciaBenef) {
		this.agenciaBenef = agenciaBenef;
	}
	public long getContaBenef() {
		return contaBenef;
	}
	public void setContaBenef(long contaBenef) {
		this.contaBenef = contaBenef;
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
	
}
