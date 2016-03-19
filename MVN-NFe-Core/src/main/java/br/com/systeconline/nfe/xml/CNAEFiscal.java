package br.com.systeconline.nfe.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class CNAEFiscal {
	@XmlValue
	private final String cnae;
	public CNAEFiscal(String cnae) {
		this.cnae = cnae;
	}
	public String getCnae() {
		return cnae;
	}
}
