package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.barcadero.module.sat.enums.EnumCSTCOFINSOutr;

@XmlRootElement(name="COFINSOutr")
@XmlAccessorType(XmlAccessType.FIELD)
public class COFINSOutr extends SuperCOFINS
{
	@XmlElement(required=true)
	private EnumCSTCOFINSOutr CST;
	@XmlElement
	private String vBC;
	@XmlElement
	private String pCOFINS;
	@XmlElement
	private String qBCProd;
	@XmlElement
	private String vAliqProd;

	public EnumCSTCOFINSOutr getCST()
	{
		return this.CST;
	}

	public void setCST(EnumCSTCOFINSOutr cst)
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

	public String getPCOFINS()
	{
		return this.pCOFINS;
	}

	public void setPCOFINS(String pCOFINS)
	{
		this.pCOFINS = pCOFINS;
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