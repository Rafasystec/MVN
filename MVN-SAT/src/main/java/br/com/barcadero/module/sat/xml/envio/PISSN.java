package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="PISSN")
@XmlAccessorType(XmlAccessType.FIELD)
public class PISSN extends PISGroup
{
	@XmlElement(required=true)
	private String CST;

	public String getCST()
	{
		return this.CST;
	}

	public void setCST(String cst)
	{
		this.CST = cst;
	}
}