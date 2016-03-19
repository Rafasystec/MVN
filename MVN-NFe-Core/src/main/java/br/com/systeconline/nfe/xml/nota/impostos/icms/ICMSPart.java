package br.com.systeconline.nfe.xml.nota.impostos.icms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//N10a
@XmlRootElement(name="ICMSPart")
@XmlAccessorType(XmlAccessType.FIELD)
public class ICMSPart extends ICMS10{

	@XmlElement(name="pRedBC", required=true)
	private String pRedBC;
	@XmlElement(name="modBCST", required=true)
	private String modBCST;
	@XmlElement(name="vICMSST", required=true)
	private String vICMSST;
	@XmlElement(name="pBCOp", required=true)
	private String pBCOp;
	@XmlElement(name="UFST", required=true)
	private String UFST;
	public String getpRedBC() {
		return pRedBC;
	}
	public void setpRedBC(String pRedBC) {
		this.pRedBC = pRedBC;
	}
	public String getModBCST() {
		return modBCST;
	}
	public void setModBCST(String modBCST) {
		this.modBCST = modBCST;
	}
	public String getvICMSST() {
		return vICMSST;
	}
	public void setvICMSST(String vICMSST) {
		this.vICMSST = vICMSST;
	}
	public String getpBCOp() {
		return pBCOp;
	}
	public void setpBCOp(String pBCOp) {
		this.pBCOp = pBCOp;
	}
	public String getUFST() {
		return UFST;
	}
	public void setUFST(String uFST) {
		UFST = uFST;
	}
}
