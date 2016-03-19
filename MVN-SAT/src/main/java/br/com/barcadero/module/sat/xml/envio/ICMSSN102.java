package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ICMSSN102")
@XmlAccessorType(XmlAccessType.FIELD)
public class ICMSSN102
{
	@XmlElement(required=true)
	private String Orig;
	@XmlElement(required=true)
	private String CSOSN;

	public String getOrig()
	{
		return this.Orig;
	}

	public void setOrig(String orig)
	{
		this.Orig = orig;
	}

	public String getCSOSN()
	{
		return this.CSOSN;
	}

	public void setCSOSN(String csosn)
	{
		this.CSOSN = csosn;
	}
}