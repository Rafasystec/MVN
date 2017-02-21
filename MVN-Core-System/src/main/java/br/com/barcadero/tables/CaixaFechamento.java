package br.com.barcadero.tables;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
/**
 * Classe para salvar os fechamnetos de caixa que ocorrerem
 * @author Rafael Rocha
 * @since versao 1.0 dia 24/02/2016 as 10:34
 */
@Audited
@Entity
@Table(name="CAIXA_FECHAMENTO")
public class CaixaFechamento extends EntidadeLoja {
	private static final long serialVersionUID = -870748154010428784L;
	
	@Column(name="VL_SANGRIA")
	private BigDecimal sangria;
	
	public CaixaFechamento() {
		// TODO Auto-generated constructor stub
	}
	public CaixaFechamento(Loja loja, Usuario usuario) {
		// TODO Auto-generated constructor stub
		super(loja, usuario);
	}
	@ManyToOne
	@JoinColumn(name="caixa", referencedColumnName="codigo")
	private Caixa caixa;
	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}
	public BigDecimal getSangria() {
		return sangria;
	}
	public void setSangria(BigDecimal sangria) {
		this.sangria = sangria;
	}
	
}
