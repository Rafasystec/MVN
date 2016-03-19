package br.com.systeconline.nfe.xml.nota;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//Y07
@XmlRootElement(name="dup")
@XmlAccessorType(XmlAccessType.FIELD)
public class Duplicata {
	
	@XmlElement(required=false)
	private String nDup;
	@XmlElement(required=false)
	private String dVenc;
	@XmlElement(required=false)
	private String vDup;
	public String getnDup() {
		return nDup;
	}
	public void setnDup(String nDup) {
		this.nDup = nDup;
	}
	public String getdVenc() {
		return dVenc;
	}
	public void setdVenc(String dVenc) {
		this.dVenc = dVenc;
	}
	public String getvDup() {
		return vDup;
	}
	public void setvDup(String vDup) {
		this.vDup = vDup;
	}
}
