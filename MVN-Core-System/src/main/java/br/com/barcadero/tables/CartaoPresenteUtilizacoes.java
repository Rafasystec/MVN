package br.com.barcadero.tables;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Para as utilizacoes de cartao presente
 * @author antoniorafael
 *
 */
@Entity
@Table(name="CARTAO_PRESENT_UTIL")
public class CartaoPresenteUtilizacoes extends EntidadeLoja {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6094081572739368359L;
	public CartaoPresenteUtilizacoes() {

	}
	
	public CartaoPresenteUtilizacoes(Empresa empresa, Loja loja, Usuario usuario) {
		super(empresa, loja, usuario);
	}
	
	@Column(name="DT_HR_UTILIZACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtHrUtilizacao;
	@Column(name="VALOR")
	private BigDecimal valor;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private CartaoPresente cartaoPresente;
	@OneToOne
	@PrimaryKeyJoinColumn
	private Nota nota;
	
	public Date getDtHrUtilizacao() {
		return dtHrUtilizacao;
	}

	public void setDtHrUtilizacao(Date dtHrUtilizacao) {
		this.dtHrUtilizacao = dtHrUtilizacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public CartaoPresente getCartaoPresente() {
		return cartaoPresente;
	}

	public void setCartaoPresente(CartaoPresente cartaoPresente) {
		this.cartaoPresente = cartaoPresente;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}
}
