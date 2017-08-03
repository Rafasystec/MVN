package br.com.barcadero.tables;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.barcadero.core.enums.EnumTipoCentroCusto;

@NamedQueries({
	@NamedQuery(name=CentroDeCusto.FIND_ALL_BY_EMP, query="FROM CentroDeCusto WHERE empresa = :"+CentroDeCusto.PARAM_EMPRESA)
})
@Entity
@Table(name="CENTRO_DE_CUSTO")
public class CentroDeCusto extends EntidadeEmpresa {

	public static final String FIND_ALL_BY_EMP = "br.com.barcadero.tables.CentroDeCusto.findByEmpresa";
	
	public CentroDeCusto() {
		
	}
	
	public CentroDeCusto(Empresa empresa,Usuario usuario) {
		setEmpresa(empresa);
		setUsuario(usuario);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 7619794721199137537L;
	@Column(name="DESCRICAO",nullable=false)
	private String descricao = "";
	@Column(name="FL_ATIVO",nullable=false)
	private boolean flAtivo = true;
	@Column(name="SALDO_ANTERIOR",scale=2,precision=12, nullable=false)
	private BigDecimal saldoAnterior = new BigDecimal("0.00");
	@Column(name="DESPESA_ANTERIOR",scale=2,precision=12,nullable=false)
	private BigDecimal despesaAnterior = new BigDecimal("0.00");
	@Column(name="TIPO" ,nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumTipoCentroCusto tipo = EnumTipoCentroCusto.DESPESA;
	
	@OneToMany(mappedBy="centroDeCusto",fetch=FetchType.LAZY)
	private List<ContaLancamento> contaLancamentos;
	
	@OneToMany(mappedBy="centroDeCusto",fetch=FetchType.LAZY)
	private List<ContaLancamentoReceita> lancamentoReceitas;
	
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
	public EnumTipoCentroCusto getTipo() {
		return tipo;
	}
	public void setTipo(EnumTipoCentroCusto tipo) {
		this.tipo = tipo;
	}
	public List<ContaLancamentoReceita> getLancamentoReceitas() {
		return lancamentoReceitas;
	}
	public void setLancamentoReceitas(List<ContaLancamentoReceita> lancamentoReceitas) {
		this.lancamentoReceitas = lancamentoReceitas;
	}
	
	
}
