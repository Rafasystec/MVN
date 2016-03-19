package br.com.barcadero.module.sat.xml.cancelamento;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="dest")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dest
{
	@XmlElement
	private String CNPJ;
	@XmlElement
	private String CPF;

	public String getCNPJ()
	{
		return this.CNPJ;
	}

	public void setCNPJ(String cnpj)
	{
		this.CNPJ = cnpj;
	}

	public String getCPF()
	{
		return this.CPF;
	}

	public void setCPF(String cpf)
	{
		this.CPF = cpf;
	}
}