package br.com.systeconline.nfe.xml.nota.impostos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//Q02
@XmlRootElement(name="PISAliq")
@XmlAccessorType(XmlAccessType.FIELD)
public class PISAliq {

	@XmlElement(name="CST", required=true)
	private String cst;
	@XmlElement(name="vBC", required=true)
	private String vBC;
	@XmlElement(name="pPIS", required=true)
	private String pPis;
	@XmlElement(name="vPIS", required=true)
	private String vPis;
	public String getCst() {
		return cst;
	}
	public void setCst(String cst) {
		this.cst = cst;
	}
	public String getvBC() {
		return vBC;
	}
	public void setvBC(String vBC) {
		this.vBC = vBC;
	}
	public String getpPis() {
		return pPis;
	}
	public void setpPis(String pPis) {
		this.pPis = pPis;
	}
	public String getvPis() {
		return vPis;
	}
	public void setvPis(String vPis) {
		this.vPis = vPis;
	}
	
}
