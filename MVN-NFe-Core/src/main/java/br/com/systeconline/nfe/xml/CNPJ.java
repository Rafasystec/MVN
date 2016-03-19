package br.com.systeconline.nfe.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class CNPJ {
	
	@XmlValue
	private final String cnpj;
	public CNPJ(String cnpj){
		this.cnpj = cnpj;
	}
	
	public String getCnpj(){
		return cnpj;
	}

}
