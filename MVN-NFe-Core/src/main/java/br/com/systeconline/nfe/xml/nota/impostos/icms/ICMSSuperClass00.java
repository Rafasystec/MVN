package br.com.systeconline.nfe.xml.nota.impostos.icms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ICMSSuperClass00 {
	
	@XmlElement(name="modBC", required=true)
	private String modBC;
	@XmlElement(name="vBC", required=true)
	private String vBC;
	@XmlElement(name="pICMS", required=true)
	private String pICMS;
	@XmlElement(name="vICMS", required=true)
	private String vICMS;
	public String getModBC() {
		return modBC;
	}
	public void setModBC(String modBC) {
		this.modBC = modBC;
	}
	public String getvBC() {
		return vBC;
	}
	public void setvBC(String vBC) {
		this.vBC = vBC;
	}
	public String getpICMS() {
		return pICMS;
	}
	public void setpICMS(String pICMS) {
		this.pICMS = pICMS;
	}
	public String getvICMS() {
		return vICMS;
	}
	public void setvICMS(String vICMS) {
		this.vICMS = vICMS;
	}
}
