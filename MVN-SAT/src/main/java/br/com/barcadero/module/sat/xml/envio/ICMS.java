package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.barcadero.module.sat.xml.util.CNPJ;
import br.com.barcadero.module.sat.xml.util.CPF;

@XmlRootElement(name="ICMS")
@XmlAccessorType(XmlAccessType.FIELD)
public class ICMS
{
//	@XmlElement
//	private ICMS00 ICMS00;
//	@XmlElement
//	private ICMS40 ICMS40;
//	@XmlElement
//	private ICMSSN102 ICMSSN102;
//	@XmlElement
//	private ICMSSN900 ICMSSN900;

	@XmlElements(value={
			@XmlElement(name="ICMS00",type=ICMS00.class),
			@XmlElement(name="ICMS40",type=ICMS40.class),
			@XmlElement(name="ICMSSN102",type=ICMSSN102.class),
			@XmlElement(name="ICMSSN900",type=ICMSSN900.class),
	})
	
	private Object iCMS;

	public Object getiCMS() {
		return iCMS;
	}

	public void setiCMS(Object iCMS) {
		this.iCMS = iCMS;
	}
	
}