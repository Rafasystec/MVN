package br.com.barcadero.module.sat.xml.cancelamento;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="CFeCanc")
@XmlAccessorType(XmlAccessType.FIELD)
public class CFeCanc
{
	@XmlElement(required=true)
	private InfCFe infCFe;

	public InfCFe getInfCFe()
	{
		return this.infCFe;
	}

	public void setInfCFe(InfCFe infCFe)
	{
		this.infCFe = infCFe;
	}
}