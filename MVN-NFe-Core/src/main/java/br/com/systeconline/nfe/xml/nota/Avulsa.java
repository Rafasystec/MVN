package br.com.systeconline.nfe.xml.nota;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//D01
@XmlRootElement(name="avulsa")
@XmlAccessorType(XmlAccessType.FIELD)
public class Avulsa {
	
	@XmlElement(name="CNPJ",required=true)
	private String cNPJ;
	@XmlElement(name="xOrgao",required=true)
	private String xOrgao;
	@XmlElement(name="matr",required=true)
	private String matr;
	@XmlElement(name="xAgente",required=true)
	private String xAgente;
	@XmlElement(name="fone",required=true)
	private String fone;
	@XmlElement(name="UF",required=true)
	private String uF;
	@XmlElement(name="nDAR",required=true)
	private String nDAR;
	@XmlElement(name="dEmi",required=true)
	private String dEmi;
	@XmlElement(name="vDAR",required=true)
	private String vDAR;
	@XmlElement(name="repEmi",required=true)
	private String repEmi;
	@XmlElement(name="dPag",required=false)
	private String dPag;
	public String getcNPJ() {
		return cNPJ;
	}
	public void setcNPJ(String cNPJ) {
		this.cNPJ = cNPJ;
	}
	public String getxOrgao() {
		return xOrgao;
	}
	public void setxOrgao(String xOrgao) {
		this.xOrgao = xOrgao;
	}
	public String getMatr() {
		return matr;
	}
	public void setMatr(String matr) {
		this.matr = matr;
	}
	public String getxAgente() {
		return xAgente;
	}
	public void setxAgente(String xAgente) {
		this.xAgente = xAgente;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getuF() {
		return uF;
	}
	public void setuF(String uF) {
		this.uF = uF;
	}
	public String getnDAR() {
		return nDAR;
	}
	public void setnDAR(String nDAR) {
		this.nDAR = nDAR;
	}
	public String getdEmi() {
		return dEmi;
	}
	public void setdEmi(String dEmi) {
		this.dEmi = dEmi;
	}
	public String getvDAR() {
		return vDAR;
	}
	public void setvDAR(String vDAR) {
		this.vDAR = vDAR;
	}
	public String getRepEmi() {
		return repEmi;
	}
	public void setRepEmi(String repEmi) {
		this.repEmi = repEmi;
	}
	public String getdPag() {
		return dPag;
	}
	public void setdPag(String dPag) {
		this.dPag = dPag;
	}
	
	

}
