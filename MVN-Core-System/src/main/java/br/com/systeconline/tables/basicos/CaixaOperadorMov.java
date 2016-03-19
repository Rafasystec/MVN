package br.com.systeconline.tables.basicos;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@NamedQueries({
	@NamedQuery(name=CaixaOperadorMov.FIND_ALL, query="FROM CaixaOperadorMov WHERE cdEmp = :cdEmp"),
	@NamedQuery(name=CaixaOperadorMov.FIND_BY_CX, query="FROM CaixaOperadorMov WHERE cdEmp = :cdEmp AND cd_caixa = :cdCaixa")
})

/**
 * Entidade que vai controlar as saidas do operador do caixa.
 * @author Rafael Rocha
 */
@Deprecated
//@Entity
//@Table(name="CAIXA_OPERADOR_MOV")
public class CaixaOperadorMov extends Entidade {

	private static final long serialVersionUID = 115055326709162742L;

	public CaixaOperadorMov() {
		// TODO Auto-generated constructor stub
	}
	public CaixaOperadorMov(Usuario usuario) {
		super(usuario);
		// TODO Auto-generated constructor stub
	}
	public final static String FIND_ALL 	  = "CaixaOperadorMov.findAll";
	public final static String FIND_BY_CX	  = "CaixaOperadorMov.findByCx";
	public final static String PARAM_CD_EMP   = "cdEmp";
	public final static String PARAM_CD_CAIXA = "cdCaixa";
	
	@Column(name="dt_entrada",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtEntrada;
	@Column(name="dt_saida",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtSaida;
	@Column(name="vl_reforco",nullable=false)
	private BigDecimal vlReforco;
	@Column(name="vl_sangria",nullable=false)
	private BigDecimal vlSangria;
	@Column(name="hr_entrada",nullable=false)
	@Temporal(TemporalType.TIME)
	private Date hrEntrada;
	@Column(name="hr_saida",nullable=false)
	@Temporal(TemporalType.TIME)
	private Date hrSaida;
	
	@ManyToOne
	@JoinColumn(name="cd_caixa", referencedColumnName="codigo")
	private Caixa caixa;
	
	public Date getDtEntrada() {
		return dtEntrada;
	}
	public void setDtEntrada(Date dtEntrada) {
		this.dtEntrada = dtEntrada;
	}
	public Date getDtSaida() {
		return dtSaida;
	}
	public void setDtSaida(Date dtSaida) {
		this.dtSaida = dtSaida;
	}
	public BigDecimal getVlReforco() {
		return vlReforco;
	}
	public void setVlReforco(BigDecimal vlReforco) {
		this.vlReforco = vlReforco;
	}
	public BigDecimal getVlSangria() {
		return vlSangria;
	}
	public void setVlSangria(BigDecimal vlSangria) {
		this.vlSangria = vlSangria;
	}
	public Date getHrEntrada() {
		return hrEntrada;
	}
	public void setHrEntrada(Date hrEntrada) {
		this.hrEntrada = hrEntrada;
	}
	public Date getHrSaida() {
		return hrSaida;
	}
	public void setHrSaida(Date hrSaida) {
		this.hrSaida = hrSaida;
	}
	public Caixa getCaixa() {
		return caixa;
	}
	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}
	
	
}
