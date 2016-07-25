package br.com.barcadero.tables;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import br.com.barcadero.core.enums.EnumCSTICMS;
import br.com.barcadero.core.enums.EnumOrigemCSTICMS;
import br.com.barcadero.core.enums.EnumTipoCOFINS;
import br.com.barcadero.core.enums.EnumTipoICMS;
import br.com.barcadero.core.enums.EnumTipoPIS;
import br.com.barcadero.core.enums.EnumTipoProduto;
import br.com.barcadero.core.enums.EnumUnidadeMedida;

@NamedQueries({
	@NamedQuery(name=Produto.FIND_ALL			,query="FROM Produto"),
	@NamedQuery(name=Produto.FIND_BY_CODE		,query="FROM Produto WHERE codigo = :codigo"),
	@NamedQuery(name=Produto.FIND_BY_DATE		,query="FROM Produto WHERE dt_cadastro = :date"),
	@NamedQuery(name=Produto.FIND_BY_COD_OR_DESC,query="FROM Produto WHERE codigo = :codigo OR descricao Like :descricao")
	
})

@Entity
@Table(name="PRODUTO")
public class Produto extends EntidadeEmpresa {
	
	private static final long serialVersionUID = -6081109651552318379L;
	public Produto() {
		// TODO Auto-generated constructor stub
	}
	public Produto(Empresa empresa, Usuario usuario) {
		super(empresa, usuario);
		// TODO Auto-generated constructor stub
	}
	public static final String FIND_ALL				= "Produto.findAll";
	public static final String FIND_BY_CODE 		= "Produto.findByCode";
	public static final String FIND_BY_DATE 		= "Produto.findByDate";
	public static final String FIND_BY_COD_OR_DESC 	= "Produto.findByCodOrDesc";
	
	@Column(name="descricao", nullable=false)
	private String descricao = "";
	@Column(name="",nullable=false)
	private String cdProd = "";
	@Column(name="unidade",nullable=false)
	@Enumerated(EnumType.STRING)
	private EnumUnidadeMedida unidade = EnumUnidadeMedida.UNIDADE;
	@Column(name="ippt",nullable=false)
	private String ippt = "";
	@Column(name="sit_tributaria",nullable=false)
	private String sitTributaria = "";
	@Column(name="aliquota",nullable=false)
	private BigDecimal aliquota = new BigDecimal(0.00);
	@Column(name="preco_custo",nullable=false)
	private BigDecimal precoCusto = new BigDecimal(0.00);
	@Column(name="cd_ncm",nullable=false)
	private int cdNcm = 0;
	@Column(name="ean",nullable=false)
	private String ean = "";
	@Column(name="nm_aduaneiro",nullable=false)
	private String nmAduaneiro = "";
	@Column(name="cest",nullable=false)
	private int cest = 0;
	@Column(name="cfop",nullable=false)
	private int cfop = 0;
	@Column(name="cd_fornecedor",nullable=false)
	private long cdFornecedor;
	@Column(name="fator",nullable=false)
	private int fator = 0;
	@Column(name="origem_icms",nullable=false)
	private EnumOrigemCSTICMS origemIcms;
	@Column(name="cst_ipi", nullable=false)
	private int cstIpi = 0;
	@Column(name="cst_icms",nullable=false)
	private EnumCSTICMS cstIcms;
	@Column(name="preco_venda",nullable=false)
	private BigDecimal precoVenda = new BigDecimal(0.00);
	@Column(name="preco_promocao", nullable=false)
	private BigDecimal precoPromo = new BigDecimal(0.00);
	@Column(name="dt_inicio_promo", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date dtInicioPromo;
	@Column(name="dt_termino_promo", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date dtTerminPromo;
	@Column(name="obs_fisco", nullable=false)
	private String obsFisco = "";
	@Column(name="cst_pis", nullable=false)
	private int cstPis = 0;
	@Column(name="aliquota_issqn", nullable=false)
	private BigDecimal aliqISSQN = new BigDecimal(0.00);
	@Column(name="natureza_operacao_issqn", nullable=false)
	private int naturezaOperacaoIssqn = 0;
	@Column(name="MSG_PROMOCIONAL")
	private String msgPromocional;
	@Column(name="TIPO_PRODUTO")
	@Enumerated(EnumType.STRING)
	private EnumTipoProduto tipoProduto = EnumTipoProduto.NORMAL;
	@Column(name="TIPO_ICMS")
	@Enumerated(EnumType.STRING)
	private EnumTipoICMS tipoICMS = EnumTipoICMS.ICMS00;
	@Column(name="TIPO_PIS")
	@Enumerated(EnumType.STRING)
	private EnumTipoPIS tipoPis = EnumTipoPIS.PIS_ALIQUOTA;
	@Column(name="TIPO_COFINS")
	@Enumerated(EnumType.STRING)
	private EnumTipoCOFINS tipoCofins;
	
	@OneToMany(mappedBy="produto", targetEntity=Estoque.class)
	private List<Estoque> estoques;
	
	public String getCdProd() {
		return cdProd;
	}
	public void setCdProd(String cdProd) {
		this.cdProd = cdProd;
	}
	public EnumUnidadeMedida getUnidade() {
		return unidade;
	}
	public void setUnidade(EnumUnidadeMedida unidade) {
		this.unidade = unidade;
	}
	public String getIppt() {
		return ippt;
	}
	public void setIppt(String ippt) {
		this.ippt = ippt;
	}
	public String getSitTributaria() {
		return sitTributaria;
	}
	public void setSitTributaria(String sitTributaria) {
		this.sitTributaria = sitTributaria;
	}
	public BigDecimal getAliquota() {
		return aliquota;
	}
	public void setAliquota(BigDecimal aliquota) {
		this.aliquota = aliquota;
	}
	public BigDecimal getPrecoCusto() {
		return precoCusto;
	}
	public void setPrecoCusto(BigDecimal precoCusto) {
		this.precoCusto = precoCusto;
	}
	public int getCdNcm() {
		return cdNcm;
	}
	public void setCdNcm(int cdNcm) {
		this.cdNcm = cdNcm;
	}
	public String getEan() {
		return ean;
	}
	public void setEan(String ean) {
		this.ean = ean;
	}
	public String getNmAduaneiro() {
		return nmAduaneiro;
	}
	public void setNmAduaneiro(String nmAduaneiro) {
		this.nmAduaneiro = nmAduaneiro;
	}
	public int getCest() {
		return cest;
	}
	public void setCest(int cest) {
		this.cest = cest;
	}
	public int getCfop() {
		return cfop;
	}
	public void setCfop(int cfop) {
		this.cfop = cfop;
	}
	public long getCdFornecedor() {
		return cdFornecedor;
	}
	public void setCdFornecedor(long cdFornecedor) {
		this.cdFornecedor = cdFornecedor;
	}
	public int getFator() {
		return fator;
	}
	public void setFator(int fator) {
		this.fator = fator;
	}
	public String getMsgPromocional() {
		return msgPromocional;
	}
	public void setMsgPromocional(String msgPromocional) {
		this.msgPromocional = msgPromocional;
	}
	public EnumOrigemCSTICMS getOrigemIcms() {
		return origemIcms;
	}
	public void setOrigemIcms(EnumOrigemCSTICMS origemIcms) {
		this.origemIcms = origemIcms;
	}
	public int getCstIpi() {
		return cstIpi;
	}
	public void setCstIpi(int cstIpi) {
		this.cstIpi = cstIpi;
	}
	public EnumCSTICMS getCstIcms() {
		return cstIcms;
	}
	public void setCstIcms(EnumCSTICMS cstIcms) {
		this.cstIcms = cstIcms;
	}
	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}
	public BigDecimal getPrecoPromo() {
		return precoPromo;
	}
	public void setPrecoPromo(BigDecimal precoPromo) {
		this.precoPromo = precoPromo;
	}
	public Date getDtInicioPromo() {
		return dtInicioPromo;
	}
	public void setDtInicioPromo(Date dtInicioPromo) {
		this.dtInicioPromo = dtInicioPromo;
	}
	public Date getDtTerminPromo() {
		return dtTerminPromo;
	}
	public void setDtTerminPromo(Date dtTerminPromo) {
		this.dtTerminPromo = dtTerminPromo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		if(descricao != null){
			descricao = descricao.toUpperCase();
		}
		this.descricao = descricao;
	}
	public String getObsFisco() {
		return obsFisco;
	}
	public void setObsFisco(String obsFisco) {
		this.obsFisco = obsFisco;
	}
	public int getCstPis() {
		return cstPis;
	}
	public void setCstPis(int cstPis) {
		this.cstPis = cstPis;
	}
	public BigDecimal getAliqISSQN() {
		return aliqISSQN;
	}
	public void setAliqISSQN(BigDecimal aliqISSQN) {
		this.aliqISSQN = aliqISSQN;
	}
	public int getNaturezaOperacaoIssqn() {
		return naturezaOperacaoIssqn;
	}
	public void setNaturezaOperacaoIssqn(int naturezaOperacaoIssqn) {
		this.naturezaOperacaoIssqn = naturezaOperacaoIssqn;
	}
	public EnumTipoProduto getTipoProduto() {
		return tipoProduto;
	}
	public void setTipoProduto(EnumTipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
	
	public List<Estoque> getEstoques() {
		return estoques;
	}
	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
	}
	public EnumTipoICMS getTipoICMS() {
		return tipoICMS;
	}
	public void setTipoICMS(EnumTipoICMS tipoICMS) {
		this.tipoICMS = tipoICMS;
	}
	public EnumTipoPIS getTipoPis() {
		return tipoPis;
	}
	public void setTipoPis(EnumTipoPIS tipoPis) {
		this.tipoPis = tipoPis;
	}
	public EnumTipoCOFINS getTipoCofins() {
		return tipoCofins;
	}
	public void setTipoCofins(EnumTipoCOFINS tipoCofins) {
		this.tipoCofins = tipoCofins;
	}
	
}
