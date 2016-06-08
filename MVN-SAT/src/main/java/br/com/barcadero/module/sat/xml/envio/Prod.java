package br.com.barcadero.module.sat.xml.envio;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="prod")
@XmlAccessorType(XmlAccessType.FIELD)
public class Prod
{
	@XmlElement(required=true)
	private String cProd;
	@XmlElement
	private String cEAN;
	@XmlElement(required=true)
	private String xProd;
	@XmlElement
	private String NCM;
	@XmlElement(required=true)
	private String CFOP;
	@XmlElement(required=true)
	private String uCom;
	@XmlElement(required=true)
	private String qCom;
	@XmlElement(required=true)
	private String vUnCom;
	@XmlElement(required=true)
	private String indRegra;
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

	public String getCEAN()
	{
		return this.cEAN;
	}

	public void setCEAN(String cEAN)
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

	public void setCFOP(String cfop)
	{
		this.CFOP = cfop;
	}

	public String getUCom()
	{
		return this.uCom;
	}

	public void setUCom(String uCom)
	{
		this.uCom = uCom;
	}

	public String getQCom()
	{
		return this.qCom;
	}

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

	public String getIndRegra()
	{
		return this.indRegra;
	}

	public void setIndRegra(String indRegra)
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
}