package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="PISOutr")
@XmlAccessorType(XmlAccessType.FIELD)
public class PISOutr extends PISGroup
{
	@XmlElement(required=true)
	private String CST;
	@XmlElement
	private String vBC;
	@XmlElement
	private String pPIS;
	@XmlElement
	private String qBCProd;
	@XmlElement
	private String vAliqProd;

	public String getCST()
	{
		return this.CST;
	}

	public void setCST(String cst)
	{
		this.CST = cst;
	}

	public String getVBC()
	{
		return this.vBC;
	}

	public void setVBC(String vBC)
	{
		this.vBC = vBC;
	}

	public String getPPIS()
	{
		return this.pPIS;
	}

	public void setPPIS(String pPIS)
	{
		this.pPIS = pPIS;
	}

	public String getQBCProd()
	{
		return this.qBCProd;
	}

	public void setQBCProd(String qBCProd)
	{
		this.qBCProd = qBCProd;
	}

	public String getVAliqProd()
	{
		return this.vAliqProd;
	}

	public void setVAliqProd(String vAliqProd)
	{
		this.vAliqProd = vAliqProd;
	}
}