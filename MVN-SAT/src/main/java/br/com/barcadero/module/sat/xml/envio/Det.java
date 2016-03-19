package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="det")
@XmlAccessorType(XmlAccessType.FIELD)
public class Det
{
	@XmlAttribute(required=true)
	private String nItem;
	@XmlElement(required=true)
	private Prod prod;
	@XmlElement(required=true)
	private Imposto imposto;
	@XmlElement
	private String infAdProd;

	public String getNItem()
	{
		return this.nItem;
	}

	public void setNItem(String item)
	{
		this.nItem = item;
	}

	public Prod getProd()
	{
		return this.prod;
	}

	public void setProd(Prod prod)
	{
		this.prod = prod;
	}

	public Imposto getImposto()
	{
		return this.imposto;
	}

	public void setImposto(Imposto imposto)
	{
		this.imposto = imposto;
	}

	public String getInfAdProd()
	{
		return this.infAdProd;
	}

	public void setInfAdProd(String infAdProd)
	{
		this.infAdProd = infAdProd;
	}
}