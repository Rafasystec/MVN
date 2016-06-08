package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.barcadero.module.sat.enums.EnumCSTICMS00;
import br.com.barcadero.module.sat.enums.EnumOrigICMS;

@XmlRootElement(name="ICMS00")
@XmlAccessorType(XmlAccessType.FIELD)
public class ICMS00
{
	@XmlElement(required=true)
	private EnumOrigICMS Orig;
	@XmlElement(required=true)
	private EnumCSTICMS00 CST;
	@XmlElement(required=true)
	private String pICMS;

	public EnumOrigICMS getOrig()
	{
		return this.Orig;
	}

	public void setOrig(EnumOrigICMS orig)
	{
		this.Orig = orig;
	}

	public EnumCSTICMS00 getCST()
	{
		return this.CST;
	}

	public void setCST(EnumCSTICMS00 cst)
	{
		this.CST = cst;
	}

	public String getPICMS()
	{
		return this.pICMS;
	}

	/**
	 * Alíquota efetiva do imposto
	 * @param pICMS
	 */
	public void setPICMS(String pICMS)
	{
		this.pICMS = pICMS;
	}
}