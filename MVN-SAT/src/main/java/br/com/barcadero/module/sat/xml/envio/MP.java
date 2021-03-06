package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.barcadero.module.sat.enums.EnumMeioPagamento;

@XmlRootElement(name="MP")
@XmlAccessorType(XmlAccessType.FIELD)
public class MP
{
	@XmlElement(required=true)
	private EnumMeioPagamento cMP;
	@XmlElement(required=true)
	private String vMP;
	@XmlElement
	private String cAdmC;

	public EnumMeioPagamento getCMP()
	{
		return this.cMP;
	}

	public void setCMP(EnumMeioPagamento cMP)
	{
		this.cMP = cMP;
	}

	public String getVMP()
	{
		return this.vMP;
	}

	public void setVMP(String vMP)
	{
		this.vMP = vMP;
	}

	public String getCAdmC()
	{
		return this.cAdmC;
	}

	public void setCAdmC(String cAdmC)
	{
		this.cAdmC = cAdmC;
	}
}