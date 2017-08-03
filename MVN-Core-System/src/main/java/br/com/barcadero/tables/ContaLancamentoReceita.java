package br.com.barcadero.tables;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.barcadero.core.enums.EnumNaturezaReceita;
import br.com.barcadero.core.enums.EnumTipoReceita;

@Entity
@Table(name="CONTA_LANCAMENTO_RECEITA")
public class ContaLancamentoReceita extends EntidadeEmpresa {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1393440907192587383L;
	@Column(name="VALOR",scale=2,precision=10,nullable=false)
	private BigDecimal valor;
	@Column(name="TIPO",nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumTipoReceita tipo;
	@Column(name="NATUREZA",nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumNaturezaReceita natureza;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="COD_CENTRO_CUSTO",referencedColumnName="CODIGO")
	private CentroDeCusto centroDeCusto;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public EnumTipoReceita getTipo() {
		return tipo;
	}

	public void setTipo(EnumTipoReceita tipo) {
		this.tipo = tipo;
	}

	public EnumNaturezaReceita getNatureza() {
		return natureza;
	}

	public void setNatureza(EnumNaturezaReceita natureza) {
		this.natureza = natureza;
	}

	public CentroDeCusto getCentroDeCusto() {
		return centroDeCusto;
	}

	public void setCentroDeCusto(CentroDeCusto centroDeCusto) {
		this.centroDeCusto = centroDeCusto;
	}

}
