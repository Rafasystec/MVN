package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.barcadero.module.sat.enums.EnumCSOSN900;
import br.com.barcadero.module.sat.enums.EnumOrigICMS;

@XmlRootElement(name="ICMSSN900")
@XmlAccessorType(XmlAccessType.FIELD)
public class ICMSSN900
{
	@XmlElement(required=true)
	private EnumOrigICMS Orig;
	@XmlElement(required=true)
	private EnumCSOSN900 CSOSN;
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

	/**
	 * Codigo de Situação da Operação – SIMPLES NACIONAL 
	 * @return
	 */
	public EnumCSOSN900 getCSOSN()
	{
		return this.CSOSN;
	}

	public void setCSOSN(EnumCSOSN900 csosn)
	{
		this.CSOSN = csosn;
	}

	public String getPICMS()
	{
		return this.pICMS;
	}

	public void setPICMS(String pICMS)
	{
		this.pICMS = pICMS;
	}
}