package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="PISAliq")
@XmlAccessorType(XmlAccessType.FIELD)
public class PISAliq
{
	@XmlElement(required=true)
	private String CST;
	@XmlElement(required=true)
	private String vBC;
	@XmlElement(required=true)
	private String pPIS;

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

	public String getPPIS()
	{
		return this.pPIS;
	}

	/**
	 * Alíquota do PIS (em percentual) 
	 * Ex. Se a alíquota for 0,65% informar 0.0065
	 * @param pPIS
	 */
	public void setPPIS(String pPIS)
	{
		this.pPIS = pPIS;
	}
}