package br.com.systeconline.nfe.xml.nota.impostos.icms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//N10
@XmlRootElement(name="ICMS90")
@XmlAccessorType(XmlAccessType.FIELD)
public class ICMS90 extends ICMS10{


	@XmlElement(name="pRedBC", required=true)
	private String pRedBC;
	@XmlElement(name="vICMSST", required=true)
	private String vICMSST;

	public String getpRedBC() {
		return pRedBC;
	}

	public void setpRedBC(String pRedBC) {
		this.pRedBC = pRedBC;
	}

	public String getvICMSST() {
		return vICMSST;
	}

	public void setvICMSST(String vICMSST) {
		this.vICMSST = vICMSST;
	}
	
}
