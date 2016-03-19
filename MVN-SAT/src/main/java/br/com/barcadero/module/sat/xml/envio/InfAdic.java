package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="infAdic")
@XmlAccessorType(XmlAccessType.FIELD)
public class InfAdic
{
	@XmlElement
	private String infCpl;
	
	public String getInfCpl()
	{
		return this.infCpl;
	}
	
	public void setInfCpl(String infCpl)
	{
		this.infCpl = infCpl;
	}
}
