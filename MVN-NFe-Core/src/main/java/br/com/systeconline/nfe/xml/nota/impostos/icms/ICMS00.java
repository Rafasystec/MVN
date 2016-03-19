package br.com.systeconline.nfe.xml.nota.impostos.icms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//N02
@XmlRootElement(name="ICMS00")
@XmlAccessorType(XmlAccessType.FIELD)
public class ICMS00 extends ICMSSuperClass00{

	@XmlElement(name="orig", required=true)
	private String orig;
	@XmlElement(name="CST",required= true)
	private String cST;

	
	public String getcST() {
		return cST;
	}

	public void setcST(String cST) {
		this.cST = cST;
	}

	public String getOrig() {
		return orig;
	}

	public void setOrig(String orig) {
		this.orig = orig;
	}
	
	
}
