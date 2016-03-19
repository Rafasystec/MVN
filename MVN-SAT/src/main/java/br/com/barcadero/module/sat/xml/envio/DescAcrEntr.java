package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="descAcrEntr")
@XmlAccessorType(XmlAccessType.FIELD)
public class DescAcrEntr
{
	@XmlElement
	private String vDescSubtot;
	@XmlElement
	private String vAcresSubtot;

	public String getVDescSubtot()
	{
		return this.vDescSubtot;
	}

	public void setVDescSubtot(String vDescSubtot)
	{
		this.vDescSubtot = vDescSubtot;
	}

	public String getVAcresSubtot()
	{
		return this.vAcresSubtot;
	}

	public void setVAcresSubtot(String vAcresSubtot)
	{
		this.vAcresSubtot = vAcresSubtot;
	}
}