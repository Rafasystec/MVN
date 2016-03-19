package br.com.systeconline.nfe.xml.nota;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//I18
@XmlRootElement(name="DI")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeclaracaoDeImportacao {
	
	@XmlElement(required=true)
	private String nDI;
	@XmlElement(required=true)
	private String dDI;
	@XmlElement(required=true)
	private String xLocDesemb;
	@XmlElement(required=true)
	private String UFDesemb;
	@XmlElement(required=true)
	private String dDesemb;
	@XmlElement(required=true)
	private String cEmportador;
	@XmlElement(required=true)
	private List<Adicoes> adi;
	public String getnDI() {
		return nDI;
	}
	public void setnDI(String nDI) {
		this.nDI = nDI;
	}
	public String getdDI() {
		return dDI;
	}
	public void setdDI(String dDI) {
		this.dDI = dDI;
	}
	public String getxLocDesemb() {
		return xLocDesemb;
	}
	public void setxLocDesemb(String xLocDesemb) {
		this.xLocDesemb = xLocDesemb;
	}
	public String getUFDesemb() {
		return UFDesemb;
	}
	public void setUFDesemb(String uFDesemb) {
		UFDesemb = uFDesemb;
	}
	public String getdDesemb() {
		return dDesemb;
	}
	public void setdDesemb(String dDesemb) {
		this.dDesemb = dDesemb;
	}
	public String getcEmportador() {
		return cEmportador;
	}
	public void setcEmportador(String cEmportador) {
		this.cEmportador = cEmportador;
	}
	public List<Adicoes> getAdi() {
		return adi;
	}
	public void setAdi(List<Adicoes> adi) {
		this.adi = adi;
	}
	
}
