package br.com.systeconline.tables.financeiro;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.systeconline.core.enums.EnumTipoPlanoConta;
import br.com.systeconline.tables.basicos.Empresa;
import br.com.systeconline.tables.basicos.Entidade;
import br.com.systeconline.tables.basicos.EntidadeEmpresa;
import br.com.systeconline.tables.basicos.Usuario;

@Entity
@Table(name="PLANO_CONTA")
public class PlanoConta extends EntidadeEmpresa{
	
	public PlanoConta() {
		// TODO Auto-generated constructor stub
	}
	
	public PlanoConta(Empresa empresa, Usuario usuario) {
		// TODO Auto-generated constructor stub
		super(empresa, usuario);
		
	}
	
	@Transient
	private static final long serialVersionUID = -103609002772493508L;
	@Column(name="nivel1",nullable=false)
	private int nivel1 = 0;
	@Column(name="nivel2",nullable=false)
	private int nivel2 = 0;
	@Column(name="nivel3",nullable=false)
	private int nivel3 = 0;
	@Column(name="nivel4",nullable=false)
	private int nivel4 = 0;
	@Column(name="nivel5",nullable=false)
	private int nivel5 = 0;
	@Column(name="descricao",nullable=false)
	private String descricao;
	@Column(name="tp_conta",nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumTipoPlanoConta tpConta = EnumTipoPlanoConta.DESPESA;
	@Column(name="saldo_atual",nullable=false)
	private BigDecimal saldoAtual = new BigDecimal(0);
	@Column(name="saldo_anterior",nullable=false)
	private BigDecimal saldoAnterior = new BigDecimal(0);;
	
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getNivel3() {
		return nivel3;
	}
	public void setNivel3(int nivel3) {
		this.nivel3 = nivel3;
	}
	public int getNivel4() {
		return nivel4;
	}
	public void setNivel4(int nivel4) {
		this.nivel4 = nivel4;
	}
	public int getNivel5() {
		return nivel5;
	}
	public void setNivel5(int nivel5) {
		this.nivel5 = nivel5;
	}
	public BigDecimal getSaldoAtual() {
		return saldoAtual;
	}
	public void setSaldoAtual(BigDecimal saldoAtual) {
		this.saldoAtual = saldoAtual;
	}
	public BigDecimal getSaldoAnterior() {
		return saldoAnterior;
	}
	public void setSaldoAnterior(BigDecimal saldoAnterior) {
		this.saldoAnterior = saldoAnterior;
	}
	public EnumTipoPlanoConta getTpConta() {
		return tpConta;
	}
	public void setTpConta(EnumTipoPlanoConta tpConta) {
		this.tpConta = tpConta;
	}

}
