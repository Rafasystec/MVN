package br.com.systeconline.nfe.xml.nota;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//B20j
@XmlRootElement(name="refECF")
@XmlAccessorType(XmlAccessType.FIELD)
public class RefECF {

	@XmlElement(name="mod", required=true)
	private String mod;
	@XmlElement(name="nECF", required=true)
	private String nECF;
	@XmlElement(name="nCOO", required=true)
	private String nCOO;
	public String getMod() {
		return mod;
	}
	public void setMod(String mod) {
		this.mod = mod;
	}
	public String getnECF() {
		return nECF;
	}
	public void setnECF(String nECF) {
		this.nECF = nECF;
	}
	public String getnCOO() {
		return nCOO;
	}
	public void setnCOO(String nCOO) {
		this.nCOO = nCOO;
	}
	
}
