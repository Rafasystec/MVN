package br.com.systeconline.nfe.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class InscricaoMunicipal {
	@XmlValue
	private final String im;
	public InscricaoMunicipal(String im) {
		this.im = im;
	}
	public String getIm() {
		return im;
	}
}
