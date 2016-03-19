package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="dest")
@XmlAccessorType(XmlAccessType.FIELD)
public class DestCNPJ
{
	@XmlElement
	private String CNPJ;
	@XmlElement
	private String xNome;

	public String getCNPJ()
	{
		return this.CNPJ;
	}

	public void setCNPJ(String cnpj)
	{
		this.CNPJ = cnpj;
	}

	public String getXNome()
	{
		return this.xNome;
	}

	public void setXNome(String xNome)
	{
		this.xNome = xNome;
	}
}