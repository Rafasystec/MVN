package br.com.barcadero.core.xml.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import br.com.barcadero.core.enums.EnumCSTCOFINS;
import br.com.barcadero.core.enums.EnumCSTICMS;
import br.com.barcadero.core.enums.EnumCSTIPI;
import br.com.barcadero.core.enums.EnumCSTPIS;
import br.com.barcadero.core.enums.EnumOrigemCSTICMS;
import br.com.barcadero.core.enums.EnumTipoCOFINS;
import br.com.barcadero.core.enums.EnumTipoICMS;
import br.com.barcadero.core.enums.EnumTipoPIS;
import br.com.barcadero.core.enums.EnumTipoProduto;
import br.com.barcadero.core.enums.EnumUnidadeMedida;

@XmlRootElement(name="produto")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLProduto extends XMLGenericEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4614112293669585850L;
	private String descricao = "";
	private String cdProd = "";
	private EnumUnidadeMedida unidade = EnumUnidadeMedida.UNIDADE;
	private String ippt = "";
	private String sitTributaria = "";
	private BigDecimal aliquota = new BigDecimal(0.00);
	private BigDecimal precoCusto = new BigDecimal(0.00);
	private int cdNcm = 0;
	private String ean = "";
	private String nmAduaneiro = "";
	private int cest = 0;
	private int cfop = 5102;
	private long cdFornecedor;
	private int fator = 0;
	private EnumOrigemCSTICMS origemIcms;
	private EnumCSTIPI cstIpi = EnumCSTIPI.ENTRADA_ISENTA_02;
	private EnumCSTICMS cstIcms;
	private BigDecimal precoVenda = new BigDecimal(0.00);
	private BigDecimal precoPromo = new BigDecimal(0.00);
	private Date dtInicioPromo;
	private Date dtTerminPromo;
	private String obsFisco = "";
	private BigDecimal aliqISSQN = new BigDecimal(0.00);
	private int naturezaOperacaoIssqn = 0;
	private String msgPromocional;
	private EnumTipoProduto tipoProduto = EnumTipoProduto.NORMAL;
	private EnumTipoICMS tipoICMS = EnumTipoICMS.ICMS00;
	private EnumTipoPIS tipoPis = EnumTipoPIS.PIS_ALIQUOTA;
	private EnumTipoCOFINS tipoCofins = EnumTipoCOFINS.COFINS_ALIQ;
	private EnumCSTPIS cstPis = EnumCSTPIS._01;
	private EnumCSTCOFINS cstCOFINS = EnumCSTCOFINS._01;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
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
	public EnumOrigemCSTICMS getOrigemIcms() {
		return origemIcms;
	}
	public void setOrigemIcms(EnumOrigemCSTICMS origemIcms) {
		this.origemIcms = origemIcms;
	}
	public EnumCSTIPI getCstIpi() {
		return cstIpi;
	}
	public void setCstIpi(EnumCSTIPI cstIpi) {
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
	public String getObsFisco() {
		return obsFisco;
	}
	public void setObsFisco(String obsFisco) {
		this.obsFisco = obsFisco;
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
	public String getMsgPromocional() {
		return msgPromocional;
	}
	public void setMsgPromocional(String msgPromocional) {
		this.msgPromocional = msgPromocional;
	}
	public EnumTipoProduto getTipoProduto() {
		return tipoProduto;
	}
	public void setTipoProduto(EnumTipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
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
	public EnumCSTPIS getCstPis() {
		return cstPis;
	}
	public void setCstPis(EnumCSTPIS cstPis) {
		this.cstPis = cstPis;
	}
	public EnumCSTCOFINS getCstCOFINS() {
		return cstCOFINS;
	}
	public void setCstCOFINS(EnumCSTCOFINS cstCOFINS) {
		this.cstCOFINS = cstCOFINS;
	}
	
	
}
