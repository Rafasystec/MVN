package br.com.systeconline.nfe.xml.nota;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//Y01
@XmlRootElement(name="cobr")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cobranca {

	@XmlElement(required=false)
	private Fatura fat;

	public Fatura getFat() {
		return fat;
	}

	public void setFat(Fatura fat) {
		this.fat = fat;
	}
}
