package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.barcadero.module.sat.enums.EnumCFeCSTPISAliq;
/**
 * Grupo de PIS tributado pela alíquota 
 * CST = 01, 02 e 05
 * @author Rafael Rocha
 * dia 25/07/2016 as 21:42
 */
@XmlRootElement(name="PISAliq")
@XmlAccessorType(XmlAccessType.FIELD)
public class PISAliq extends PISGroup
{
	@XmlElement(required=true)
	private EnumCFeCSTPISAliq CST;
	@XmlElement(required=true)
	private String vBC;
	@XmlElement(required=true)
	private String pPIS;

	public EnumCFeCSTPISAliq getCST(){
		return this.CST;
	}

	public void setCST(EnumCFeCSTPISAliq cst){
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