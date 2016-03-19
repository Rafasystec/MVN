package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="emit")
@XmlAccessorType(XmlAccessType.FIELD)
public class Emit
{
	@XmlElement(required=true)
	private String CNPJ;
	@XmlElement(required=true)
	private String IE;
	@XmlElement
	private String IM;
	@XmlElement
	private String cRegTribISSQN;
	@XmlElement(required=true)
	private String indRatISSQN;
	
	public String getCNPJ()
	{
		return this.CNPJ;
	}
	
	public void setCNPJ(String cnpj)
	{
		this.CNPJ = cnpj;
	}
	
	public String getIE()
	{
		return this.IE;
	}
	
	public void setIE(String ie)
	{
		this.IE = ie;
	}
	
	public String getIM()
	{
		return this.IM;
	}
	
	public void setIM(String im)
	{
		this.IM = im;
	}
	
	public String getCRegTribISSQN()
	{
		return this.cRegTribISSQN;
	}
	
	public void setCRegTribISSQN(String regTribISSQN)
	{
		this.cRegTribISSQN = regTribISSQN;
	}
	
	public String getIndRatISSQN()
	{
		return this.indRatISSQN;
	}
	
	public void setIndRatISSQN(String indRatISSQN)
	{
		this.indRatISSQN = indRatISSQN;
	}
}
