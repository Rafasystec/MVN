package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="dest")
@XmlAccessorType(XmlAccessType.FIELD)
public class DestCPF
{
	@XmlElement
	private String CPF;
	@XmlElement
	private String xNome;

	public String getCPF()
	{
		return this.CPF;
	}

	public void setCPF(String cpf)
	{
		this.CPF = cpf;
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