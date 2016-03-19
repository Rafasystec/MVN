package br.com.systeconline.nfe.xml.cancelamento;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="infCanc")
public class InfCanc {
	
	@XmlID
	private String id;
	@XmlElement(name="tpAmb", required=true)
	private String tpAmb;
	@XmlElement(name="xServ", required=true)
	private String xServ;
	@XmlElement(name="chNFe", required=true)
	private String chNFe;
	@XmlElement(name="nProt", required=true)
	private String nProt;
	@XmlElement(name="xJust", required=true)
	private String xJust;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTpAmb() {
		return tpAmb;
	}
	public void setTpAmb(String tpAmb) {
		this.tpAmb = tpAmb;
	}
	public String getxServ() {
		return xServ;
	}
	public void setxServ(String xServ) {
		this.xServ = xServ;
	}
	public String getChNFe() {
		return chNFe;
	}
	public void setChNFe(String chNFe) {
		this.chNFe = chNFe;
	}
	public String getnProt() {
		return nProt;
	}
	public void setnProt(String nProt) {
		this.nProt = nProt;
	}
	public String getxJust() {
		return xJust;
	}
	public void setxJust(String xJust) {
		this.xJust = xJust;
	}
	
	

}
