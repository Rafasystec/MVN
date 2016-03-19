package br.com.systeconline.nfe.xml.inutilizacao;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="infInut")
@XmlAccessorType(XmlAccessType.FIELD)
public class InfInut {
	@XmlID
	private String Id;
	@XmlElement
	private String tpAmb;
	@XmlElement
	private String xServ;
	@XmlElement
	private String cUF;
	@XmlElement
	private String ano;
	@XmlElement
	private String cNPJ;
	@XmlElement
	private String mod;
	@XmlElement
	private String serie;
	@XmlElement
	private String nNFIni;
	@XmlElement
	private String nNFFin;
	@XmlElement
	private String xJust;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
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
	public String getcUF() {
		return cUF;
	}
	public void setcUF(String cUF) {
		this.cUF = cUF;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getcNPJ() {
		return cNPJ;
	}
	public void setcNPJ(String cNPJ) {
		this.cNPJ = cNPJ;
	}
	public String getMod() {
		return mod;
	}
	public void setMod(String mod) {
		this.mod = mod;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getnNFIni() {
		return nNFIni;
	}
	public void setnNFIni(String nNFIni) {
		this.nNFIni = nNFIni;
	}
	public String getnNFFin() {
		return nNFFin;
	}
	public void setnNFFin(String nNFFin) {
		this.nNFFin = nNFFin;
	}
	public String getxJust() {
		return xJust;
	}
	public void setxJust(String xJust) {
		this.xJust = xJust;
	}
	
	

}
