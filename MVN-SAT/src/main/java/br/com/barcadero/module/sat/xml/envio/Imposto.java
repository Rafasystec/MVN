package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="imposto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Imposto
{
	@XmlElement
	private String vItem12741;
	@XmlElement
	private ICMS ICMS;
	@XmlElement(required=true)
	private PIS PIS;
	@XmlElement
	private PISST PISST;
	@XmlElement(required=true)
	private COFINS COFINS;
	@XmlElement
	private COFINSST COFINSST;
	@XmlElement
	private ISSQN ISSQN;

	public String getVItem12741()
	{
		return this.vItem12741;
	}

	public void setVItem12741(String item12741)
	{
		this.vItem12741 = item12741;
	}

	public ICMS getICMS()
	{
		return this.ICMS;
	}

	public void setICMS(ICMS icms)
	{
		this.ICMS = icms;
	}

	public PIS getPIS()
	{
		return this.PIS;
	}

	public void setPIS(PIS pis)
	{
		this.PIS = pis;
	}

	public PISST getPISST()
	{
		return this.PISST;
	}

	public void setPISST(PISST pisst)
	{
		this.PISST = pisst;
	}

	public COFINS getCOFINS()
	{
		return this.COFINS;
	}

	public void setCOFINS(COFINS cofins)
	{
		this.COFINS = cofins;
	}

	public COFINSST getCOFINSST()
	{
		return this.COFINSST;
	}

	public void setCOFINSST(COFINSST cofinsst)
	{
		this.COFINSST = cofinsst;
	}

	public ISSQN getISSQN()
	{
		return this.ISSQN;
	}

	public void setISSQN(ISSQN issqn)
	{
		this.ISSQN = issqn;
	}
}