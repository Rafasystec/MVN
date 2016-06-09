package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.barcadero.module.sat.enums.EnumCSTCOFINSSN;

@XmlRootElement(name="COFINSSN")
@XmlAccessorType(XmlAccessType.FIELD)
public class COFINSSN extends SuperCOFINS
{
	@XmlElement(required=true)
	private EnumCSTCOFINSSN CST;

	public EnumCSTCOFINSSN getCST()
	{
		return this.CST;
	}

	public void setCST(EnumCSTCOFINSSN cst)
	{
		this.CST = cst;
	}
}