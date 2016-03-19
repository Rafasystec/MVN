package br.com.systeconline.nfe.xml.nota;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//ZA01
@XmlRootElement(name="exporta")
@XmlAccessorType(XmlAccessType.FIELD)
public class ComercioExterior {
	
	@XmlElement(name="UFEmbarq",required=true)
	private String uFEmbarq;
	@XmlElement(name="xLocEmbarq",required=true)
	private String xLocEmbarq;
	public String getuFEmbarq() {
		return uFEmbarq;
	}
	public void setuFEmbarq(String uFEmbarq) {
		this.uFEmbarq = uFEmbarq;
	}
	public String getxLocEmbarq() {
		return xLocEmbarq;
	}
	public void setxLocEmbarq(String xLocEmbarq) {
		this.xLocEmbarq = xLocEmbarq;
	}
	
}
