package br.com.systeconline.nfe.xml.nota.impostos.icms;

import javax.xml.bind.annotation.XmlElement;

public class ICMSSuperClass {

	@XmlElement(name="orig", required=true)
	private String orig;
	@XmlElement(name="CST", required=true)
	private String cST;
	public String getOrig() {
		return orig;
	}
	public void setOrig(String orig) {
		this.orig = orig;
	}
	public String getcST() {
		return cST;
	}
	public void setcST(String cST) {
		this.cST = cST;
	}
	
}
