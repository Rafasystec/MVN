package br.com.systeconline.nfe.xml.inutilizacao.retorno;

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
	private String verAplic;
	@XmlElement
	private String cStat;
	@XmlElement
	private String xMotivo;
	@XmlElement
	private String cUF;
	@XmlElement
	private String ano;
	@XmlElement
	private String cNPJ;
	@XmlElement
	private String mod;
	@XmlElement
	private String seerie;
	@XmlElement
	private String nNFIni;
	@XmlElement
	private String nNFFin;
	@XmlElement
	private String dhRecbto;
	@XmlElement
	private String nProt;
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
	public String getSeerie() {
		return seerie;
	}
	public void setSeerie(String seerie) {
		this.seerie = seerie;
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
	public String getDhRecbto() {
		return dhRecbto;
	}
	public void setDhRecbto(String dhRecbto) {
		this.dhRecbto = dhRecbto;
	}
	public String getnProt() {
		return nProt;
	}
	public void setnProt(String nProt) {
		this.nProt = nProt;
	}

	
}
