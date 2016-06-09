package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="total")
@XmlAccessorType(XmlAccessType.FIELD)
public class Total
{
	@XmlElement
	private DescAcrEntr DescAcrEntr;
	@XmlElement
	private String vCFeLei12741;
	  
	public DescAcrEntr getDescAcrEntr()
	{
		return this.DescAcrEntr;
	}
	  
	public void setDescAcrEntr(DescAcrEntr DescAcrEntr)
	{
		this.DescAcrEntr = DescAcrEntr;
	}
	  
	public String getVCFeLei12741()
	{
		return this.vCFeLei12741;
	}
	/**
	 * Valor aproximado dos tributos do CF-e-SAT, declarado pelo
	emitente, conforme Lei 12741/2012. Valor deve ser maior ou igual a zero.
	Campo de preenchimento: - opcional, caso o contribuinte opte por informar o valor em
	painel afixado no estabelecimento, conforme artigo 2o, §2o da referida lei.
 	obrigatório, caso o contribuinte  não opte por informar o valor em
  	painel afixado no estabelecimento, conforme artigo 2o, §2o da referida lei.
	 * @param vCFeLei12741
	 */
	public void setVCFeLei12741(String vCFeLei12741)
	{
		this.vCFeLei12741 = vCFeLei12741;
	}
}