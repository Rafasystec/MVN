package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.barcadero.module.sat.enums.EnumCSTCOFINSAliq;

@XmlRootElement(name="COFINSAliq")
@XmlAccessorType(XmlAccessType.FIELD)
public class COFINSAliq extends SuperCOFINS
{
	@XmlElement(required=true)
	private EnumCSTCOFINSAliq CST;
	@XmlElement(required=true)
	private String vBC;
	@XmlElement(required=true)
	private String pCOFINS;

	public EnumCSTCOFINSAliq getCST()
	{
		return this.CST;
	}

	public void setCST(EnumCSTCOFINSAliq cst)
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

	/**
	 * Ex. Se a alíquota for 0,65% informar 0,0065
	 * @param pCOFINS
	 */
	public void setPCOFINS(String pCOFINS)
	{
		this.pCOFINS = pCOFINS;
	}
}