package br.com.systeconline.nfe.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class IdEstrangeiro {
	
	@XmlValue
	private final String value;

	public IdEstrangeiro(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
