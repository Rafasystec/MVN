package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="obsFiscoDet")
@XmlAccessorType(XmlAccessType.FIELD)
public class ObsFiscoDet
{
	@XmlElement(required=true)
	private String xCampoDet;
	@XmlElement(required=true)
	private String xTextoDet;

	public String getXCampoDet()
	{
		return this.xCampoDet;
	}

	public void setXCampoDet(String xCampoDet)
	{
		this.xCampoDet = xCampoDet;
	}

	public String getXTextoDet()
	{
		return this.xTextoDet;
	}

	public void setXTextoDet(String xTextoDet)
	{
		this.xTextoDet = xTextoDet;
	}
}