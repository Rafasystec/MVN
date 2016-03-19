package br.com.systeconline.nfe.xml.nota;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//Z10
@XmlRootElement(name="procRef")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProcessoReferenciado {

	@XmlElement(required=true)
	private String nProc;
	@XmlElement(required=true)
	private String indProc;
	public String getnProc() {
		return nProc;
	}
	public void setnProc(String nProc) {
		this.nProc = nProc;
	}
	public String getIndProc() {
		return indProc;
	}
	public void setIndProc(String indProc) {
		this.indProc = indProc;
	}
}
