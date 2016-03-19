package br.com.barcadero.module.sat.xml.cancelamento;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ide")
@XmlAccessorType(XmlAccessType.FIELD)
public class Ide
{
	@XmlElement(required=true)
	private String CNPJ;
	@XmlElement(required=true)
	private String signAC;
	@XmlElement(required=true)
	private String numeroCaixa;

	public String getCNPJ()
	{
		return this.CNPJ;
	}

	public void setCNPJ(String cnpj)
	{
		this.CNPJ = cnpj;
	}

	public String getSignAC()
	{
		return this.signAC;
	}

	public void setSignAC(String signAC)
	{
		this.signAC = signAC;
	}

	public String getNumeroCaixa()
	{
		return this.numeroCaixa;
	}

	public void setNumeroCaixa(String numeroCaixa)
	{
		this.numeroCaixa = numeroCaixa;
	}
}