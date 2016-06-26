package br.com.barcadero.tables;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CONTA_RECEBER")
public class ContaReceber extends Entidade {

	private static final long serialVersionUID = -3229007342790706377L;
	@Column(name="DT_PREVISAO")
	private Date dtPrevisao;
	@Column(name="DT_VENCIMENTO")
	private Date dtVencimento;
	@Column(name="VALOR_RECEBER")
	private BigDecimal valorAReceber;
	@Column(name="NR_NOTA_FISCAL")
	private String nrNotaFiscal;
	@Column(name="NR")
	private long nrOS;
	@Column(name="")
	private String descricao;
	@Column(name="")
	private long codCliente;
	@Column(name="")
	private long codCentroCusto;
	@Column(name="")
	private long codBanco;
	@Column(name="")
	private long codPlanoConta;
	
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
	public long getNrOS() {
		return nrOS;
	}
	public void setNrOS(long nrOS) {
		this.nrOS = nrOS;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public long getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(long codCliente) {
		this.codCliente = codCliente;
	}
	public long getCodCentroCusto() {
		return codCentroCusto;
	}
	public void setCodCentroCusto(long codCentroCusto) {
		this.codCentroCusto = codCentroCusto;
	}
	public long getCodBanco() {
		return codBanco;
	}
	public void setCodBanco(long codBanco) {
		this.codBanco = codBanco;
	}
	public long getCodPlanoConta() {
		return codPlanoConta;
	}
	public void setCodPlanoConta(long codPlanoConta) {
		this.codPlanoConta = codPlanoConta;
	}
}
