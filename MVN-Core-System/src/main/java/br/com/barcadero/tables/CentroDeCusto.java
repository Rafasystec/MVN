package br.com.barcadero.tables;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CENTRO_DE_CUSTO")
public class CentroDeCusto extends EntidadeEmpresa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7619794721199137537L;
	@Column(name="DESCRICAO",nullable=false)
	private String descricao;
	@Column(name="FL_ATIVO",nullable=false)
	private boolean flAtivo;
	@Column(name="SALDO_ANTERIOR",scale=2,precision=12, nullable=false)
	private BigDecimal saldoAnterior;
	@Column(name="DESPESA_ANTERIOR",scale=2,precision=12,nullable=false)
	private BigDecimal despesaAnterior;
	
	@OneToMany
	@JoinColumn(name="COD_LANCAMENTO" , referencedColumnName="CODIGO")
	private List<ContaLancamento> contaLancamentos;

	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isFlAtivo() {
		return flAtivo;
	}
	public void setFlAtivo(boolean flAtivo) {
		this.flAtivo = flAtivo;
	}
	public BigDecimal getSaldoAnterior() {
		return saldoAnterior;
	}
	public void setSaldoAnterior(BigDecimal saldoAnterior) {
		this.saldoAnterior = saldoAnterior;
	}
	public BigDecimal getDespesaAnterior() {
		return despesaAnterior;
	}
	public void setDespesaAnterior(BigDecimal despesaAnterior) {
		this.despesaAnterior = despesaAnterior;
	}
	public List<ContaLancamento> getContaLancamentos() {
		return contaLancamentos;
	}
	public void setContaLancamentos(List<ContaLancamento> contaLancamentos) {
		this.contaLancamentos = contaLancamentos;
	}
	
	
}
