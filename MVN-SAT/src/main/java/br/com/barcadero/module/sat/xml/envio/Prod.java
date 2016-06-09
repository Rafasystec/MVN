package br.com.barcadero.module.sat.xml.envio;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.barcadero.module.sat.enums.EnumEAN;
import br.com.barcadero.module.sat.enums.EnumIndRegra;

@XmlRootElement(name="prod")
@XmlAccessorType(XmlAccessType.FIELD)
public class Prod
{
	@XmlElement(required=true)
	private String cProd;
	@XmlElement
	private EnumEAN cEAN;
	@XmlElement(required=true)
	private String xProd;
	@XmlElement
	private String NCM;
	@XmlElement(name="CEST",required=false)
	private String cEST;
	@XmlElement(required=true)
	private String CFOP;
	@XmlElement(required=true)
	private String uCom;
	@XmlElement(required=true)
	private String qCom;
	@XmlElement(required=true)
	private String vUnCom;
	@XmlElement(required=true)
	private EnumIndRegra indRegra;
	@XmlElement
	private String vDesc;
	@XmlElement
	private String vOutro;
	@XmlElement(name="obsFiscoDet")
	private List<ObsFiscoDet> obsFiscoDets;

	public String getCProd()
	{
		return this.cProd;
	}

	/**
	 * Codigo do produto ou servico. Interno do contribuinte
	 * @param cProd
	 */
	public void setCProd(String cProd)
	{
		this.cProd = cProd;
	}

	public EnumEAN getCEAN()
	{
		return this.cEAN;
	}
	/**
	 * GTIN (Global	Trade Item	Number) do produto, antigo 
	codigo EAN ou codigo de barras Preencher com o código GTIN-8,
	GTIN-12, GTIN-13 ou GTIN-14 (antigos códigos EAN, UPC e DUN-14),
	nao informar o conteudo da TAG em caso de o produto não possuir este codigo.
	 * @param cEAN
	 */
	public void setCEAN(EnumEAN cEAN)
	{
		this.cEAN = cEAN;
	}

	public String getXProd()
	{
		return this.xProd;
	}

	public void setXProd(String xProd)
	{
		this.xProd = xProd;
	}

	public String getNCM()
	{
		return this.NCM;
	}

	public void setNCM(String ncm)
	{
	this.NCM = ncm;
	}

	public String getCFOP()
	{
		return this.CFOP;
	}
	/**
	 * Codigo Fiscal de Operacoes e Prestacoes 
	 * CFOPs validos para operacoes  cobertas pelo CF-e
	 * Faixa de 5000
	 * @param cfop
	 */
	public void setCFOP(String cfop)
	{
		this.CFOP = cfop;
	}

	public String getUCom()
	{
		return this.uCom;
	}

	/**
	 * nformar a unidade de comercialização do produto. No
 	 * caso de combustíveis, utilizar a unidade de medida da
	 * codificacao de produtos do Sistema de Informacoes de
  	 * Movimentacao de produtos - SIMP (http://www.anp.gov.br/simp).
	 * @param uCom
	 */
	public void setUCom(String uCom)
	{
		this.uCom = uCom;
	}

	public String getQCom()
	{
		return this.qCom;
	}

	/**
	 * Com 4 casa decimais , entao 1 unidade sera 1.0000 pois o ponto separa as decimais
	 * @param qCom
	 */
	public void setQCom(String qCom)
	{
		this.qCom = qCom;
	}

	public String getVUnCom()
	{
		return this.vUnCom;
	}

	public void setVUnCom(String vUnCom)
	{
		this.vUnCom = vUnCom;
	}

	public EnumIndRegra getIndRegra()
	{
		return this.indRegra;
	}

	public void setIndRegra(EnumIndRegra indRegra)
	{
		this.indRegra = indRegra;
	}

	public String getVDesc()
	{
		return this.vDesc;
	}

	public void setVDesc(String vDesc)
	{
		this.vDesc = vDesc;
	}

	public String getVOutro()
	{
		return this.vOutro;
	}

	public void setVOutro(String vOutro)
	{
		this.vOutro = vOutro;
	}

	public List<ObsFiscoDet> getObsFiscoDets()
	{
		return this.obsFiscoDets;
	}

	public void setObsFiscoDets(List<ObsFiscoDet> obsFiscoDets)
	{
		this.obsFiscoDets = obsFiscoDets;
	}

	public String getcEST() {
		return cEST;
	}
	/**
	 * Codigo CEST que identifica a mercadoria sujeita aos regimes
	de substituicao tributaria e de antecipacao do recolhimento do
    imposto. As alteracoes serao incorporadas na versao 0.08 do leiaute 
    do CF-e-SAT.
	 * @param cEST
	 */
	public void setcEST(String cEST) {
		this.cEST = cEST;
	}
}