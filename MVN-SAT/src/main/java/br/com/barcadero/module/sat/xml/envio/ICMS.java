package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ICMS")
@XmlAccessorType(XmlAccessType.FIELD)
public class ICMS
{

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