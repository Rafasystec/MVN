package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.barcadero.module.sat.enums.EnumOrigICMS;

@XmlRootElement(name="ICMS00")
@XmlAccessorType(XmlAccessType.FIELD)
public class ICMS00
{
	@XmlElement(required=true)
	private EnumOrigICMS Orig;
	@XmlElement(required=true)
	private String CST;
	@XmlElement(required=true)
	private String pICMS;

	public EnumOrigICMS getOrig()
	{
		return this.Orig;
	}

	public void setOrig(EnumOrigICMS orig)
	{
		this.Orig = orig;
	}

	public String getCST()
	{
		return this.CST;
	}

	public void setCST(String cst)
	{
		this.CST = cst;
	}

	public String getPICMS()
	{
		return this.pICMS;
	}

	public void setPICMS(String pICMS)
	{
		this.pICMS = pICMS;
	}
}