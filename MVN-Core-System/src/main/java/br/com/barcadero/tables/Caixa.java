package br.com.barcadero.tables;

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

import br.com.barcadero.commons.enuns.EnumTipoModuloSAT;
import br.com.barcadero.core.enums.EnumModeloNota;
import br.com.barcadero.core.enums.EnumStatusCaixa;

@NamedQueries({
	@NamedQuery(name=Caixa.FIND_ALL		,query="FROM Caixa WHERE empresa = :empresa"),
	@NamedQuery(name=Caixa.FIND_BY_CDCX	,query="FROM Caixa WHERE empresa = :empresa AND cdCaixa = :cdCaixa"),
	@NamedQuery(name=Caixa.FIND_BY_CODE	,query="FROM Caixa WHERE codigo  = :codigo"),
	@NamedQuery(name=Caixa.FIND_BY_IP	,query="FROM Caixa WHERE ip	     = :ip AND loja = :loja")
})

@Entity
@Table(name="CAIXA")
public class Caixa extends EntidadeLoja {

	private static final long serialVersionUID = -7987256315167064742L;

	public Caixa() {
		// TODO Auto-generated constructor stub
	}

	public Caixa(Empresa empresa, Loja loja, Usuario usuario) {
		// TODO Auto-generated constructor stub
		super(empresa, loja, usuario);
	}
	
	
	public final static String FIND_ALL 	= "Caixa.findAll";
	public final static String FIND_BY_CDCX = "Caixa.findByCdcx";
	public final static String FIND_BY_CODE = "Caixa.findByCode";
	public final static String FIND_BY_IP 	= "Caixa.findByIp";
	public final static String PARAM_CODE	= "codigo";
	public final static String PARAM_IP	    = "ip";
	
	@Column(name="CD_CAIXA",nullable=false)
	private int cdCaixa;
	@Column(name="IP",nullable=false)
	private String ip = "127.0.0.1";
	@Column(name="TIPO_NOTA",nullable=false)
	@Enumerated(EnumType.STRING)
	private EnumModeloNota tipoNota;
	@Column(name="COD_ATIV_CFE",nullable=false)
	private String codAtivCfe = "";
	@Column(name="COD_ATIV_CFE_EMERGEN",nullable=false)
	private String codAtivCfeEmergen = "";
	@Column(name="STATUS_CAIXA")
	@Enumerated(EnumType.STRING)
	private EnumStatusCaixa statusCaixa = EnumStatusCaixa.ABERTO;
	@Column(name="MODULO_SAT", length=20)
	@Enumerated(EnumType.STRING)
	private EnumTipoModuloSAT tipoModuloSAT = EnumTipoModuloSAT.EMULADOR;
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
	public EnumStatusCaixa getStatusCaixa() {
		return statusCaixa;
	}
	public void setStatusCaixa(EnumStatusCaixa statusCaixa) {
		this.statusCaixa = statusCaixa;
	}

	public EnumTipoModuloSAT getTipoModuloSAT() {
		return tipoModuloSAT;
	}

	public void setTipoModuloSAT(EnumTipoModuloSAT tipoModuloSAT) {
		this.tipoModuloSAT = tipoModuloSAT;
	}
	
}
