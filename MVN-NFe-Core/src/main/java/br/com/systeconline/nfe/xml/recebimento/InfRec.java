package br.com.systeconline.nfe.xml.recebimento;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "infRec")
@XmlAccessorType(XmlAccessType.FIELD)
public class InfRec {

	@XmlElement(name="nRec")
	private String nRec;
	@XmlElement(name="tMed")
	private String tMed;
	public String getnRec() {
		return nRec;
	}
	public void setnRec(String nRec) {
		this.nRec = nRec;
	}
	public String gettMed() {
		return tMed;
	}
	public void settMed(String tMed) {
		this.tMed = tMed;
	}

}
