package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="COFINSAliq")
@XmlAccessorType(XmlAccessType.FIELD)
public class COFINSAliq
{
	@XmlElement(required=true)
	private String CST;
	@XmlElement(required=true)
	private String vBC;
	@XmlElement(required=true)
	private String pCOFINS;

	public String getCST()
	{
		return this.CST;
	}

	public void setCST(String cst)
	{
		this.CST = cst;
	}

	public String getVBC()
	{
		return this.vBC;
	}

	public void setVBC(String vBC)
	{
		this.vBC = vBC;
	}

	public String getPCOFINS()
	{
		return this.pCOFINS;
	}

	public void setPCOFINS(String pCOFINS)
	{
		this.pCOFINS = pCOFINS;
	}
}