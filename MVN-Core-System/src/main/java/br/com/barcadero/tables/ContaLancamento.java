package br.com.barcadero.tables;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.barcadero.core.enums.EnumCentroCusto;
import br.com.barcadero.core.enums.EnumFormaPgto;

@NamedQueries({
	@NamedQuery(name=ContaLancamento.FIND_BY_MONTH,query="FROM ContaLancamento WHERE empresa = :empresa AND loja= :loja AND data BETWEEN :dtIni AND :dtFim ")
})
@Entity
@Table(name="CONTA_LANCAMENTOS")
public class ContaLancamento extends EntidadeLoja {

	public static final String FIND_BY_MONTH = "br.com.barcadero.tables.ContaLancamento.findByMoth";
	
	public ContaLancamento() {
	
	}
	
	public ContaLancamento(Empresa empresa, Usuario usuario, Loja loja) {
		this.setEmpresa(empresa);
		this.setUsuario(usuario);
		this.setLoja(loja);
	}
	
	private static final long serialVersionUID = 514493381912312588L;
	@Column(name="DATA",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date data 		 = new Date();
	@Column(name="DT_VENCIMENTO",nullable=true)
	@Temporal(TemporalType.DATE)
	private Date dtVencimento = new Date();
	@Column(name="VALOR", scale=2, precision=10,nullable=false)
	private BigDecimal valor = new BigDecimal("0.00");
	@Column(name="CENTRO_CUSTO",nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumCentroCusto centroCusto = EnumCentroCusto.OUTROS;
	@Column(name="FORMA_PAGTO",nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumFormaPgto formaPgto = EnumFormaPgto.DINHEIRO;
	@Column(name="DESCRICAO",nullable=false,length=60)
	private String descricao= "";
	@Column(name="VALOR_JUROS", scale=2, precision=10,nullable=false)
	private BigDecimal valorJuros = new BigDecimal("0.00");
	@Column(name="PARCELAS",nullable=false)
	private int parcelas = 0;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CODIGO_CARTAO",unique=false,nullable=true)
	private CartaoCreditoDebito cartaoCreditoDebito;
	
	
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public EnumCentroCusto getCentroCusto() {
		return centroCusto;
	}
	public void setCentroCusto(EnumCentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}
	public EnumFormaPgto getFormaPgto() {
		return formaPgto;
	}
	public void setFormaPgto(EnumFormaPgto formaPgto) {
		this.formaPgto = formaPgto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDtVencimento() {
		return dtVencimento;
	}

	public void setDtVencimento(Date dtVencimento) {
		this.dtVencimento = dtVencimento;
	}

	public BigDecimal getValorJuros() {
		return valorJuros;
	}

	public void setValorJuros(BigDecimal valorJuros) {
		this.valorJuros = valorJuros;
	}

	public int getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

	public CartaoCreditoDebito getCartaoCreditoDebito() {
		return cartaoCreditoDebito;
	}

	public void setCartaoCreditoDebito(CartaoCreditoDebito cartaoCreditoDebito) {
		this.cartaoCreditoDebito = cartaoCreditoDebito;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cartaoCreditoDebito == null) ? 0 : cartaoCreditoDebito.hashCode());
		result = prime * result + ((centroCusto == null) ? 0 : centroCusto.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((dtVencimento == null) ? 0 : dtVencimento.hashCode());
		result = prime * result + ((formaPgto == null) ? 0 : formaPgto.hashCode());
		result = prime * result + parcelas;
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		result = prime * result + ((valorJuros == null) ? 0 : valorJuros.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaLancamento other = (ContaLancamento) obj;
		if (cartaoCreditoDebito == null) {
			if (other.cartaoCreditoDebito != null)
				return false;
		} else if (!cartaoCreditoDebito.equals(other.cartaoCreditoDebito))
			return false;
		if (centroCusto != other.centroCusto)
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (dtVencimento == null) {
			if (other.dtVencimento != null)
				return false;
		} else if (!dtVencimento.equals(other.dtVencimento))
			return false;
		if (formaPgto != other.formaPgto)
			return false;
		if (parcelas != other.parcelas)
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		if (valorJuros == null) {
			if (other.valorJuros != null)
				return false;
		} else if (!valorJuros.equals(other.valorJuros))
			return false;
		return true;
	}
	
	
}
