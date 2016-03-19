package br.com.systeconline.tables.basicos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.systeconline.core.enums.EnumModeloNota;
import br.com.systeconline.core.enums.EnumStatusCaixa;

@NamedQueries({
	@NamedQuery(name=Caixa.FIND_ALL		,query="FROM Caixa WHERE cdEmp = :cdEmp"),
	@NamedQuery(name=Caixa.FIND_BY_CDCX	,query="FROM Caixa WHERE cdEmp = :cdEmp AND cdCaix = :cdCaixa"),
	@NamedQuery(name=Caixa.FIND_BY_CODE	,query="FROM Caixa WHERE codigo= :codigo"),
	@NamedQuery(name=Caixa.FIND_BY_IP	,query="FROM Caixa WHERE ip	   = :ip AND cd_loja = :cdLoja")
})

@Entity
@Table(name="CAIXA")
public class Caixa extends EntidadeLoja {

	private static final long serialVersionUID = -7987256315167064742L;

	public Caixa() {
		// TODO Auto-generated constructor stub
	}
	public Caixa(Loja loja, Usuario usuario) {
		// TODO Auto-generated constructor stub
		super(loja, usuario);
	}
	public final static String FIND_ALL 	= "Caixa.findAll";
	public final static String FIND_BY_CDCX = "Caixa.findByCdcx";
	public final static String FIND_BY_CODE = "Caixa.findByCode";
	public final static String FIND_BY_IP 	= "Caixa.findByIp";
	public final static String PARAM_CODE	= "codigo";
	public final static String PARAM_IP	    = "ip";
	public final static String PARAM_CD_LOJA= "cdLoja";
	
	@Column(name="cd_caixa",nullable=false)
	private int cdCaixa;
	@Column(name="ip",nullable=false)
	private String ip = "127.0.0.1";
	@Column(name="tipo_nota",nullable=false)
	@Enumerated(EnumType.STRING)
	private EnumModeloNota tipoNota;
	@Column(name="fl_st_caixa",nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumStatusCaixa flStCaixa = EnumStatusCaixa.ABERTO;
	@Column(name="cod_ativ_cfe",nullable=false)
	private String codAtivCfe = "";
	@Column(name="cod_ativ_cfe_emergen",nullable=false)
	private String codAtivCfeEmergen = "";
	@OneToMany(mappedBy="caixa", targetEntity=CaixaAbertura.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<CaixaAbertura> aberturas = new ArrayList<CaixaAbertura>();
	@OneToMany(mappedBy="caixa", targetEntity=CaixaFechamento.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<CaixaFechamento> fechamentos = new ArrayList<CaixaFechamento>();
	
	public int getCdCaixa() {
		return cdCaixa;
	}
	public void setCdCaixa(int cdCaixa) {
		this.cdCaixa = cdCaixa;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public EnumModeloNota getTipoNota() {
		return tipoNota;
	}
	public void setTipoNota(EnumModeloNota tipoNota) {
		this.tipoNota = tipoNota;
	}
	public EnumStatusCaixa getFlStCaixa() {
		return flStCaixa;
	}
	public void setFlStCaixa(EnumStatusCaixa flStCaixa) {
		this.flStCaixa = flStCaixa;
	}
	public String getCodAtivCfe() {
		return codAtivCfe;
	}
	public void setCodAtivCfe(String codAtivCfe) {
		this.codAtivCfe = codAtivCfe;
	}
	public String getCodAtivCfeEmergen() {
		return codAtivCfeEmergen;
	}
	public void setCodAtivCfeEmergen(String codAtivCfeEmergen) {
		this.codAtivCfeEmergen = codAtivCfeEmergen;
	}
	public List<CaixaAbertura> getAberturas() {
		return aberturas;
	}
	public void setAberturas(List<CaixaAbertura> aberturas) {
		this.aberturas = aberturas;
	}
	public List<CaixaFechamento> getFechamentos() {
		return fechamentos;
	}
	public void setFechamentos(List<CaixaFechamento> fechamentos) {
		this.fechamentos = fechamentos;
	}
	
}
