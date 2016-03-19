package br.com.systeconline.nfe.xml.consulta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="conSitNFe")
@XmlAccessorType(XmlAccessType.FIELD)
public class ConSitNFe {
	
	@XmlAttribute
	private String versao;
	@XmlElement
	private String tpAmb;
	@XmlElement
	private String xServ;
	@XmlElement
	private String chNFe;
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
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
	

}
