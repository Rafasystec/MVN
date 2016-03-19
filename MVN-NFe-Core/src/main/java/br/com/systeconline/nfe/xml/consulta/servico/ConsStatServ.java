package br.com.systeconline.nfe.xml.consulta.servico;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="consStatServ")
@XmlAccessorType(XmlAccessType.FIELD)
public class ConsStatServ {
	
	@XmlAttribute
	private String versao;
	@XmlElement
	private String tpAmb;
	@XmlElement
	private String cUF;
	@XmlElement
	private String xServ;
	
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
	public String getcUF() {
		return cUF;
	}
	public void setcUF(String cUF) {
		this.cUF = cUF;
	}
	public String getxServ() {
		return xServ;
	}
	public void setxServ(String xServ) {
		this.xServ = xServ;
	}

	
}
