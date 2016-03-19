package br.com.systeconline.nfe.xml.recebimento;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="retEnviNFe")
@XmlAccessorType(XmlAccessType.FIELD)
public class RetEnviNFe {
	
	@XmlAttribute(name="versao")
	private String versao;
	@XmlElement(name="tpAmb")
	private String tpAmb;
	@XmlElement(name="verAplic")
	private String verAplic;
	@XmlElement(name="cStat")
	private String cStat;
	@XmlElement(name="xMotivo")
	private String xMotivo;
	@XmlElement(name="cUF")
	private String cUF;
	@XmlElement(name="dhRecbto")
	private String dhRecbto;
	@XmlElement(name="infRec", required=false)
	private InfRec infRec;
	@XmlElement(required=true)
	private String nRec;
	@XmlElement(required=true)
	private String tMed;
	
	
	public InfRec getInfRec() {
		return infRec;
	}
	public void setInfRec(InfRec infRec) {
		this.infRec = infRec;
	}
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
	public String getVerAplic() {
		return verAplic;
	}
	public void setVerAplic(String verAplic) {
		this.verAplic = verAplic;
	}
	public String getcStat() {
		return cStat;
	}
	public void setcStat(String cStat) {
		this.cStat = cStat;
	}
	public String getxMotivo() {
		return xMotivo;
	}
	public void setxMotivo(String xMotivo) {
		this.xMotivo = xMotivo;
	}
	public String getcUF() {
		return cUF;
	}
	public void setcUF(String cUF) {
		this.cUF = cUF;
	}
	public String getDhRecbto() {
		return dhRecbto;
	}
	public void setDhRecbto(String dhRecbto) {
		this.dhRecbto = dhRecbto;
	}
	
	
	

}
