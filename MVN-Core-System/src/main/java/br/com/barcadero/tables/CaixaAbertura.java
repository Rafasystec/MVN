package br.com.barcadero.tables;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe para salvar as aberturas de caixa que ocorrerem
 * @author Rafael Rocha
 * @since versao 1.0 dia 24/02/2016 as 10:20
 */
@Entity
@Table(name="CAIXA_ABERTURA")
public class CaixaAbertura extends EntidadeLoja {
	private static final long serialVersionUID = -5256587585543120837L;
	public CaixaAbertura() {
		// TODO Auto-generated constructor stub
	}
	
	public CaixaAbertura(Loja loja, Usuario usuario){
		super(loja,usuario);
	}
	
	@Column(name="SUPRIMENTO")
	private BigDecimal suprimento;
	@ManyToOne
	@JoinColumn(name="caixa", referencedColumnName="codigo")
	private Caixa caixa;
	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public BigDecimal getSuprimento() {
		return suprimento;
	}

	public void setSuprimento(BigDecimal suprimento) {
		this.suprimento = suprimento;
	}
	
	
	
}
