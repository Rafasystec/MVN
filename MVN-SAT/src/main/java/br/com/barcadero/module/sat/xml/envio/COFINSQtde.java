package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="COFINSQtde")
@XmlAccessorType(XmlAccessType.FIELD)
public class COFINSQtde
{
	@XmlElement(required=true)
	private String CST;
	@XmlElement(required=true)
	private String qBCProd;
	@XmlElement(required=true)
	private String vAliqProd;

	public String getCST()
	{
		return this.CST;
	}

	public void setCST(String cst)
	{
		this.CST = cst;
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