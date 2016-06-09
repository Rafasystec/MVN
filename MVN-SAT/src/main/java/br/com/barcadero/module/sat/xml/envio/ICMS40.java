package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.barcadero.module.sat.enums.EnumCSTICMS40;
import br.com.barcadero.module.sat.enums.EnumOrigICMS;

@XmlRootElement(name="ICMS40")
@XmlAccessorType(XmlAccessType.FIELD)
public class ICMS40
{
	@XmlElement(required=true)
	private EnumOrigICMS Orig;
	@XmlElement(required=true)
	private EnumCSTICMS40 CST;

	public EnumOrigICMS getOrig()
	{
		return this.Orig;
	}

	public void setOrig(EnumOrigICMS orig)
	{
		this.Orig = orig;
	}

	public EnumCSTICMS40 getCST()
	{
		return this.CST;
	}

	public void setCST(EnumCSTICMS40 cst)
	{
		this.CST = cst;
	}
}