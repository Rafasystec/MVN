package br.com.barcadero.tables;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CONTA_RECEBER")
public class ContaReceber extends EntidadeEmpresa {

	public ContaReceber() {
		// TODO Auto-generated constructor stub
	}
	
	public ContaReceber(Empresa empresa, Usuario usuario) {
		super(empresa,usuario);
	}
	
	private static final long serialVersionUID = -3229007342790706377L;
	@Column(name="DT_PREVISAO")
	private Date dtPrevisao = new Date();
	@Column(name="DT_VENCIMENTO")
	private Date dtVencimento = new Date();
	@Column(name="VALOR_RECEBER",scale=2,precision=14)
	private BigDecimal valorAReceber = new BigDecimal("0.00");
	@Column(name="NR_NOTA_FISCAL")
	private String nrNotaFiscal = "00000";
	@Column(name="DESCRICAO", length=120)
	private String descricao = "";

	
	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
	@JoinColumn(name="CD_PLANO_CONTA",referencedColumnName="codigo")
	private PlanoConta planoConta;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CD_RECEITA")
	private Receita receita;
	
	public Date getDtPrevisao() {
		return dtPrevisao;
	}
	public void setDtPrevisao(Date dtPrevisao) {
		this.dtPrevisao = dtPrevisao;
	}
	public Date getDtVencimento() {
		return dtVencimento;
	}
	public void setDtVencimento(Date dtVencimento) {
		this.dtVencimento = dtVencimento;
	}
	public BigDecimal getValorAReceber() {
		return valorAReceber;
	}
	public void setValorAReceber(BigDecimal valorAReceber) {
		this.valorAReceber = valorAReceber;
	}
	public String getNrNotaFiscal() {
		return nrNotaFiscal;
	}
	public void setNrNotaFiscal(String nrNotaFiscal) {
		this.nrNotaFiscal = nrNotaFiscal;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public PlanoConta getPlanoConta() {
		return planoConta;
	}
	public void setPlanoConta(PlanoConta planoConta) {
		this.planoConta = planoConta;
	}
	public Receita getReceita() {
		return receita;
	}
	public void setReceita(Receita receita) {
		this.receita = receita;
	}

}
