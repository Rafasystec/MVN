package br.com.barcadero.tables;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.barcadero.core.enums.EnumNaturezaReceita;
import br.com.barcadero.core.enums.EnumTipoReceita;

@Entity
@Table(name="RECEITA")
public class Receita extends EntidadeLoja {



	public Receita() {
		
	}
	
	public Receita(Empresa empresa,Usuario usuario,Loja loja) {
		setEmpresa(empresa);
		setUsuario(usuario);
		setLoja(loja);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="TIPO",nullable=false)
	private EnumTipoReceita tipo = EnumTipoReceita.SALARIO;
	@Column(name="VALOR",nullable=false)
	private BigDecimal valor = new BigDecimal("0.00");
	@Column(name="DT_DA_RECEITA",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtDaReceita = new Date();
	@Column(name="DT_BASE_RECEBIMENTO",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtBaseRecebimento = new Date();
	@Column(name="DESCRICAO",nullable=false,length=60)
	private String descricao = "";
	@Column(name="NATUREZA",nullable=false)
	private EnumNaturezaReceita naturezaReceita = EnumNaturezaReceita.VARIAVEL;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="COD_CENTRO_CUSTO",referencedColumnName="CODIGO")
	private CentroDeCusto centroDeCusto;
	
	public EnumTipoReceita getTipo() {
		return tipo;
	}
	public void setTipo(EnumTipoReceita tipo) {
		this.tipo = tipo;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public EnumNaturezaReceita getNaturezaReceita() {
		return naturezaReceita;
	}

	public void setNaturezaReceita(EnumNaturezaReceita naturezaReceita) {
		this.naturezaReceita = naturezaReceita;
	}

	public CentroDeCusto getCentroDeCusto() {
		return centroDeCusto;
	}

	public void setCentroDeCusto(CentroDeCusto centroDeCusto) {
		this.centroDeCusto = centroDeCusto;
	}

	public Date getDtDaReceita() {
		return dtDaReceita;
	}

	public void setDtDaReceita(Date dtDaReceita) {
		this.dtDaReceita = dtDaReceita;
	}

	public Date getDtBaseRecebimento() {
		return dtBaseRecebimento;
	}

	public void setDtBaseRecebimento(Date dtBaseRecebimento) {
		this.dtBaseRecebimento = dtBaseRecebimento;
	}
	
}
