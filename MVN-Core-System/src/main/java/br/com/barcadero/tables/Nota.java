package br.com.barcadero.tables;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.barcadero.core.enums.EnumModeloNota;
import br.com.barcadero.core.enums.EnumNaturezaOperacao;
import br.com.barcadero.core.enums.EnumNotaFaturada;
import br.com.barcadero.core.enums.EnumStatusCFeNota;
import br.com.barcadero.core.util.GlobalNameParam;
import br.com.barcadero.module.sat.enums.EnumCFeXMLVersion;

/**
 * Para as notas geradas pelo sistema
 * @author Rafael Rocha
 * @since 2015
 */

@NamedQueries({
		@NamedQuery(name=Nota.FIND_BY_CODE,query="FROM Nota WHERE empresa = :empresa AND loja = :loja AND codigo = :codigo"),
		@NamedQuery(name=Nota.FIND_ALL,query="FROM Nota")
})

@Entity 
@Table(name="NOTA")
public class Nota extends EntidadeLoja {

	private static final long serialVersionUID = -6879906509789228192L;
	public Nota() {
		// TODO Auto-generated constructor stub - Defult Constructor exigido pelo Hibernate
	}

	public Nota(Loja loja, Usuario usuario) {
		super(loja, usuario);
		// TODO Auto-generated constructor stub
	}
	public static final String FIND_BY_CODE = "Nota.findByCode";
	public static final String FIND_ALL 	= "Nota.findAll";
	
	@Column(name="DT_EMISSAO",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtEmissao = new Date();
	@Column(name="HR_EMISSAO",nullable=false)
	@Temporal(TemporalType.TIME)
	private Date hrEmissao = new Date();
	@Column(name="PC_DESC_NOTA",nullable=false)
	private BigDecimal pcDescNota = new BigDecimal("0.00");
	@Column(name="VL_DESC_NOTA",nullable=false)
	private BigDecimal vlDescNota = new BigDecimal("0.00");
	@Column(name="PC_ACRES_NOTA",nullable=false)
	private BigDecimal pcAcresNota = new BigDecimal("0.00");
	@Column(name="VL_ACRES_NOTA",nullable=false)
	private BigDecimal vlAcresNota = new BigDecimal("0.00");;
	@Column(name="MODELO",nullable=false)
	@Enumerated(EnumType.STRING)
	private EnumModeloNota modelo;
	@Column(name="INF_ADICIONAIS",nullable=false)
	private String infAdicionais = "";
	@Column(name="VL_TOT_TRIBUTOS",nullable=false)
	private BigDecimal vlTotTributos = new BigDecimal("0.00");;
	@Column(name="TP_IMPOSTO_ICMS",nullable=false)
	private String tpImpostoIcms = "";
	@Column(name="STATUS_CFE")
	private EnumStatusCFeNota statusCFe = EnumStatusCFeNota.XML_NAO_GERADO;
	@Column(name="VER_XML_CFE")
	private EnumCFeXMLVersion verXMLCFe = EnumCFeXMLVersion.V_0_06;
	
	@Column(name="NATUREZA_OPERACAO", nullable=false)
	@Enumerated(EnumType.STRING)
	private EnumNaturezaOperacao naturezaOperacao;

	@OneToMany(mappedBy="nota",cascade=CascadeType.ALL,targetEntity=NotaItens.class,fetch=FetchType.EAGER)
	private List<NotaItens> itens;
	@OneToMany(mappedBy="nota",cascade=CascadeType.ALL,targetEntity=NotaMeioPgto.class,fetch=FetchType.EAGER)
	private List<NotaMeioPgto> meiosPgto;
	
	@Column(name="FL_FATURADO",nullable=false)
	@Enumerated(EnumType.STRING)
	private EnumNotaFaturada flFaturado = EnumNotaFaturada.NAO;
	@Column(name="",nullable=false)
	private String serieNota = "";
    
	@ManyToOne
	@JoinColumn(name="caixa", referencedColumnName="codigo")
	private Caixa caixa;
	
	@ManyToOne
	@JoinColumn(name="cliente", referencedColumnName="codigo")
	private Cliente cliente;
	
	@OneToOne
	@JoinColumn(name="pedido",referencedColumnName=GlobalNameParam.PARAM_DEFAULT_CODE_COLUMN)
	private Pedido pedido;
	@OneToOne
	@JoinColumn(name="cfe",referencedColumnName=GlobalNameParam.PARAM_DEFAULT_CODE_COLUMN)
	private CupomEletronico cfe;
	
	public String getSerieNota() {
		return serieNota;
	}
	public void setSerieNota(String serieNota) {
		this.serieNota = serieNota;
	}
	
	public Date getDtEmissao() {
		return dtEmissao;
	}
	public void setDtEmissao(Date dtEmissao) {
		this.dtEmissao = dtEmissao;
	}
	public BigDecimal getPcDescNota() {
		return pcDescNota;
	}
	public void setPcDescNota(BigDecimal pcDescNota) {
		this.pcDescNota = pcDescNota;
	}
	public BigDecimal getVlDescNota() {
		return vlDescNota;
	}
	public void setVlDescNota(BigDecimal vlDescNota) {
		this.vlDescNota = vlDescNota;
	}
	public BigDecimal getPcAcresNota() {
		return pcAcresNota;
	}
	public void setPcAcresNota(BigDecimal pcAcresNota) {
		this.pcAcresNota = pcAcresNota;
	}
	public BigDecimal getVlAcresNota() {
		return vlAcresNota;
	}
	public void setVlAcresNota(BigDecimal vlAcresNota) {
		this.vlAcresNota = vlAcresNota;
	}

	public EnumModeloNota getModelo() {
		return modelo;
	}
	public void setModelo(EnumModeloNota modelo) {
		this.modelo = modelo;
	}
	public String getInfAdicionais() {
		return infAdicionais;
	}
	public void setInfAdicionais(String infAdicionais) {
		this.infAdicionais = infAdicionais;
	}

	public BigDecimal getVlTotTributos() {
		return vlTotTributos;
	}
	public void setVlTotTributos(BigDecimal vlTotTributos) {
		this.vlTotTributos = vlTotTributos;
	}
	public String getTpImpostoIcms() {
		return tpImpostoIcms;
	}
	public void setTpImpostoIcms(String tpImpostoIcms) {
		this.tpImpostoIcms = tpImpostoIcms;
	}
	
	public EnumNaturezaOperacao getNaturezaOperacao() {
		return naturezaOperacao;
	}
	public void setNaturezaOperacao(EnumNaturezaOperacao naturezaOperacao) {
		this.naturezaOperacao = naturezaOperacao;
	}

	public List<NotaItens> getItens() {
		return itens;
	}
	public void setItens(List<NotaItens> itens) {
		this.itens = itens;
	}
	public List<NotaMeioPgto> getMeiosPgto() {
		return meiosPgto;
	}
	public void setMeiosPgto(List<NotaMeioPgto> meiosPgto) {
		this.meiosPgto = meiosPgto;
	}
	public EnumNotaFaturada getFlFaturado() {
		return flFaturado;
	}
	public void setFlFaturado(EnumNotaFaturada flFaturado) {
		this.flFaturado = flFaturado;
	}
	public Date getHrEmissao() {
		return hrEmissao;
	}
	public void setHrEmissao(Date hrEmissao) {
		this.hrEmissao = hrEmissao;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public EnumStatusCFeNota getStatusCFe() {
		return statusCFe;
	}

	public void setStatusCFe(EnumStatusCFeNota statusCFe) {
		this.statusCFe = statusCFe;
	}

	public EnumCFeXMLVersion getVerXMLCFe() {
		return verXMLCFe;
	}

	public void setVerXMLCFe(EnumCFeXMLVersion verXMLCFe) {
		this.verXMLCFe = verXMLCFe;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public CupomEletronico getCfe() {
		return cfe;
	}

	public void setCfe(CupomEletronico cfe) {
		this.cfe = cfe;
	}
}
