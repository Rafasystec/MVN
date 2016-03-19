package br.com.systeconline.nfe.xml.consulta.servico;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="retConsStatServ")
@XmlAccessorType(XmlAccessType.FIELD)
public class RetConsStatServ {
	
	@XmlAttribute
	private String versao;
	@XmlElement
	private String tpAmb;
	@XmlElement
	private String verAplic;
	@XmlElement
	private String cStat;
	@XmlElement
	private String xMotivo;
	@XmlElement
	private String cUF;
	@XmlElement
	private String dhRecbto;
	@XmlElement
	private String tMed;
	@XmlElement
	private String dhRetorno;
	@XmlElement
	private String xObs;
	
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
	public String gettMed() {
		return tMed;
	}
	public void settMed(String tMed) {
		this.tMed = tMed;
	}
	public String getDhRetorno() {
		return dhRetorno;
	}
	public void setDhRetorno(String dhRetorno) {
		this.dhRetorno = dhRetorno;
	}
	public String getxObs() {
		return xObs;
	}
	public void setxObs(String xObs) {
		this.xObs = xObs;
	}
	
	

}
