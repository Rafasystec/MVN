package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.barcadero.module.sat.enums.EnumCSTCOFINSNT;

@XmlRootElement(name="COFINSNT")
@XmlAccessorType(XmlAccessType.FIELD)
public class COFINSNT extends SuperCOFINS
{
	@XmlElement(required=true)
	private EnumCSTCOFINSNT CST;

	public EnumCSTCOFINSNT getCST()
	{
		return this.CST;
	}

	public void setCST(EnumCSTCOFINSNT cst)
	{
		this.CST = cst;
	}
}