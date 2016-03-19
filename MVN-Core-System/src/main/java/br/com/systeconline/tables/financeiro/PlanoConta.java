package br.com.systeconline.tables.financeiro;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PlanoConta {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="codigo",nullable=false)
	private long codigo;
	@Column(name="cod_emp",nullable=false)
	private long codEmp;
	@Column(name="nivel0",nullable=false)
	private int nivel0;
	@Column(name="nivel1",nullable=false)
	private int nivel1;
	@Column(name="nivel2",nullable=false)
	private int nivel2;
	@Column(name="descricao",nullable=false)
	private String descricao;
	@Column(name="tp_conta",nullable=false)
	private String tpConta;
	@Column(name="local_p",nullable=false)
	private String localP;
	@Column(name="result_p",nullable=false)
	private String resultP;
	@Column(name="saldo_atual",nullable=false)
	private double saldoAtual;
	@Column(name="saldo_anterior",nullable=false)
	private double saldoAnterior;
	@Column(name="taxa_p",nullable=false)
	private double taxaP;
	@Column(name="resume_p",nullable=false)
	private String resumeP;
	@Column(name="mesmov_p",nullable=false)
	private int mesmov;
	@Column(name="destaque_p",nullable=false)
	private String destaqueP;
	@Column(name="dt_cadastro",nullable=false)
	private Date dtCadatro;
	
	public Date getDtCadatro() {
		return dtCadatro;
	}
	public void setDtCadatro(Date dtCadatro) {
		this.dtCadatro = dtCadatro;
	}
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public long getCodEmp() {
		return codEmp;
	}
	public void setCodEmp(long codEmp) {
		this.codEmp = codEmp;
	}
	public int getNivel1() {
		return nivel1;
	}
	public void setNivel1(int nivel1) {
		this.nivel1 = nivel1;
	}
	public int getNivel2() {
		return nivel2;
	}
	public void setNivel2(int nivel2) {
		this.nivel2 = nivel2;
	}
	public int getNivel0() {
		return nivel0;
	}
	public void setNivel0(int nivel0) {
		this.nivel0 = nivel0;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTpConta() {
		return tpConta;
	}
	public void setTpConta(String tpConta) {
		this.tpConta = tpConta;
	}
	public String getLocalP() {
		return localP;
	}
	public void setLocalP(String localP) {
		this.localP = localP;
	}
	public String getResultP() {
		return resultP;
	}
	public void setResultP(String resultP) {
		this.resultP = resultP;
	}
	public double getSaldoAtual() {
		return saldoAtual;
	}
	public void setSaldoAtual(double saldoAtual) {
		this.saldoAtual = saldoAtual;
	}
	public double getSaldoAnterior() {
		return saldoAnterior;
	}
	public void setSaldoAnterior(double saldoAnterior) {
		this.saldoAnterior = saldoAnterior;
	}
	public double getTaxaP() {
		return taxaP;
	}
	public void setTaxaP(double taxaP) {
		this.taxaP = taxaP;
	}
	public String getResumeP() {
		return resumeP;
	}
	public void setResumeP(String resumeP) {
		this.resumeP = resumeP;
	}
	public int getMesmov() {
		return mesmov;
	}
	public void setMesmov(int mesmov) {
		this.mesmov = mesmov;
	}
	public String getDestaqueP() {
		return destaqueP;
	}
	public void setDestaqueP(String destaqueP) {
		this.destaqueP = destaqueP;
	}
}
