package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.barcadero.module.sat.enums.EnumCSOSN102;
import br.com.barcadero.module.sat.enums.EnumOrigICMS;

@XmlRootElement(name="ICMSSN102")
@XmlAccessorType(XmlAccessType.FIELD)
public class ICMSSN102
{
	@XmlElement(required=true)
	private EnumOrigICMS Orig;
	@XmlElement(required=true)
	private EnumCSOSN102 CSOSN;

	public EnumOrigICMS getOrig()
	{
		return this.Orig;
	}

	public void setOrig(EnumOrigICMS orig)
	{
		this.Orig = orig;
	}

	public EnumCSOSN102 getCSOSN()
	{
		return this.CSOSN;
	}

	public void setCSOSN(EnumCSOSN102 csosn)
	{
		this.CSOSN = csosn;
	}
}