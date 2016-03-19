package br.com.systeconline.nfe.xml.nota;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//ZC10
@XmlRootElement(name="deduc")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeducoesCana {

	@XmlElement(required=true)
	private String xDed;
	@XmlElement(required=true)
	private String vDed;
	public String getxDed() {
		return xDed;
	}
	public void setxDed(String xDed) {
		this.xDed = xDed;
	}
	public String getvDed() {
		return vDed;
	}
	public void setvDed(String vDed) {
		this.vDed = vDed;
	}
	
	
	 	
}
 	 	