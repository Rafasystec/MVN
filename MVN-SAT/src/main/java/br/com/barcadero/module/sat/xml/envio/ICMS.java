package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ICMS")
@XmlAccessorType(XmlAccessType.FIELD)
public class ICMS
{
	@XmlElement
	private ICMS00 ICMS00;
	@XmlElement
	private ICMS40 ICMS40;
	@XmlElement
	private ICMSSN102 ICMSSN102;
	@XmlElement
	private ICMSSN900 ICMSSN900;

	public ICMS00 getICMS00()
	{
		return this.ICMS00;
	}

	public void setICMS00(ICMS00 icms00)
	{
		this.ICMS00 = icms00;
	}

	public ICMS40 getICMS40()
	{
		return this.ICMS40;
	}

	public void setICMS40(ICMS40 icms40)
	{
		this.ICMS40 = icms40;
	}

	public ICMSSN102 getICMSSN102()
	{
		return this.ICMSSN102;
	}

	public void setICMSSN102(ICMSSN102 icmssn102)
	{
		this.ICMSSN102 = icmssn102;
	}

	public ICMSSN900 getICMSSN900()
	{
		return this.ICMSSN900;
	}

	public void setICMSSN900(ICMSSN900 icmssn900)
	{
		this.ICMSSN900 = icmssn900;
	}
}