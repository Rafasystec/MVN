package br.com.barcadero.tables;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.barcadero.core.enums.EnumTpOperacaoCaixa;
/**
 * Para as operacoes de abertura,fechamento, sangria, reforco e etc..
 * @author Rafael Rocha
 * @since Versao 1.0 - dia 12/02/216 as 23:18
 */

@NamedQueries({
	@NamedQuery(name=CaixaOperacoes.FIND_ALL 				,query="FROM CaixaOperacoes WHERE cdEmp = :cdEmp"),
	@NamedQuery(name=CaixaOperacoes.FIND_BY_DT_ABERTURA 	,query="FROM CaixaOperacoes WHERE cdEmp = :cdEmp AND dtAbertura = :dtAbertura"),
	@NamedQuery(name=CaixaOperacoes.FIND_BY_DT_FECHAMENTO 	,query="FROM CaixaOperacoes WHERE cdEmp = :cdEmp AND dtFechamento 	= :dtFechamento"),
	@NamedQuery(name=CaixaOperacoes.FIND_BY_OPERADOR 		,query="FROM CaixaOperacoes WHERE cdEmp = :cdEmp AND cdOperador 	= :cdOperador"),
	@NamedQuery(name=CaixaOperacoes.FIND_BY_CDCX 		,query="FROM CaixaOperacoes WHERE cdEmp = :cdEmp AND cd_caixa 	= :cdCaixa")
})
/**
 * Para as operacoes que forem realizadas pelo o caixa.
 * @author root
 *
 */
@Deprecated
//@Entity
//@Table(name="CAIXA_OPERACOES")
public class CaixaOperacoes extends Entidade {

	private static final long serialVersionUID = -3305591965023198861L;

	public CaixaOperacoes() {
		// TODO Auto-generated constructor stub
	}
	public CaixaOperacoes(Usuario usuario) {
		super(usuario);
		// TODO Auto-generated constructor stub
	}
	public final static String FIND_ALL 				= "CaixaOperacoes.findAll";
	public final static String FIND_BY_DT_ABERTURA 		= "CaixaOperacoes.findByDtAbertura";
	public final static String FIND_BY_DT_FECHAMENTO 	= "CaixaOperacoes.findByDtFechamento";
	public final static String FIND_BY_OPERADOR 		= "CaixaOperacoes.findByOperador";
	public final static String FIND_BY_CDCX 			= "CaixaOperacoes.findByCdCx";
	//Parametros
	public final static String PARAM_DT_ABERTURA 	= "dtAbertura";
	public final static String PARAM_DT_FECHAMENTO 	= "dtFechamento";
	public final static String PARAM_CD_OPERADOR 	= "cdOperador";
	public final static String PARAM_CD_CX 			= "cdCaixa";
	
	public final static String QRY = "FROM caixa_operacoes WERE cdEmp = :cdEmp" ;
	
	@Column(name="dt_abertura",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtAbertura;
	@Column(name="dt_fechamento",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtFechamento;
	@Column(name="hr_abertura",nullable=false)
	@Temporal(TemporalType.TIME)
	private Date hrAbertura;
	@Column(name="hr_fechamento",nullable=false)
	@Temporal(TemporalType.TIME)
	private Date hrFechamento;
	@Column(name="cd_operador",nullable=false)
	private long cdOperador;
	@Column(name="tp_op_cx",nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumTpOperacaoCaixa tpOpCx;
	@ManyToOne
	@JoinColumn(name="cd_caixa", referencedColumnName="codigo")
	private Caixa caixa;
	
	public Date getDtAbertura() {
		return dtAbertura;
	}
	public void setDtAbertura(Date dtAbertura) {
		this.dtAbertura = dtAbertura;
	}
	public Date getDtFechamento() {
		return dtFechamento;
	}
	public void setDtFechamento(Date dtFechamento) {
		this.dtFechamento = dtFechamento;
	}
	public Date getHrAbertura() {
		return hrAbertura;
	}
	public void setHrAbertura(Date hrAbertura) {
		this.hrAbertura = hrAbertura;
	}
	public Date getHrFechamento() {
		return hrFechamento;
	}
	public void setHrFechamento(Date hrFechamento) {
		this.hrFechamento = hrFechamento;
	}
	public long getCdOperador() {
		return cdOperador;
	}
	public void setCdOperador(long cdOperador) {
		this.cdOperador = cdOperador;
	}
//	public int getCdCaixa() {
//		return cdCaixa;
//	}
//	public void setCdCaixa(int cdCaixa) {
//		this.cdCaixa = cdCaixa;
//	}
	public EnumTpOperacaoCaixa getTpOpCx() {
		return tpOpCx;
	}
	public void setTpOpCx(EnumTpOperacaoCaixa tpOpCx) {
		this.tpOpCx = tpOpCx;
	}
	public Caixa getCaixa() {
		return caixa;
	}
	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}
	
}
