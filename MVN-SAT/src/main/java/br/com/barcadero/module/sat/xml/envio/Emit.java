package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.barcadero.module.sat.enums.EnumIndRatISSQN;
import br.com.barcadero.module.sat.enums.EnumRegimeTributarioISSQN;

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
	private EnumRegimeTributarioISSQN cRegTribISSQN;
	@XmlElement(required=true)
	private EnumIndRatISSQN indRatISSQN;
	
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
	
	public EnumRegimeTributarioISSQN getCRegTribISSQN()
	{
		return this.cRegTribISSQN;
	}
	
	public void setCRegTribISSQN(EnumRegimeTributarioISSQN regTribISSQN)
	{
		this.cRegTribISSQN = regTribISSQN;
	}
	
	public EnumIndRatISSQN getIndRatISSQN()
	{
		return this.indRatISSQN;
	}
	/**
	 * Indicador de rateio do Desconto sobre
     * subtotal entre itens sujeitos à tributação pelo ISSQN.
	 * @param indRatISSQN
	 */
	public void setIndRatISSQN(EnumIndRatISSQN indRatISSQN)
	{
		this.indRatISSQN = indRatISSQN;
	}
}
