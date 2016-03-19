package br.com.systeconline.nfe.xml.nota;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
//C05
@XmlRootElement(name="enderEmit")
@XmlAccessorType(XmlAccessType.FIELD)
public class EnderEmitente {
	
	@XmlElement(name="xLgr", required=true)
	private String logradouro;
	@XmlElement(name="nro", required=true)
	private String numero;
	@XmlElement(name="xCpl", required=false)
	private String complemento;
	@XmlElement(name="xBairro", required=true)
	private String xBairro;
	@XmlElement(name="cMun", required=true)
	private String codigoMunicipioIBGE;
	@XmlElement(name="xMun", required=true)
	private String municipio;
	@XmlElement(name="UF", required=true)
	private String uF;
	@XmlElement(name="CEP", required=false)
	private String cEP;
	@XmlElement(name="cPais", required=false)
	private String cPais;
	@XmlElement(name="xPais", required=false)
	private String xPais;
	@XmlElement(name="fone", required=false)
	private String fone;
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getxBairro() {
		return xBairro;
	}
	public void setxBairro(String xBairro) {
		this.xBairro = xBairro;
	}
	public String getCodigoMunicipioIBGE() {
		return codigoMunicipioIBGE;
	}
	public void setCodigoMunicipioIBGE(String codigoMunicipioIBGE) {
		this.codigoMunicipioIBGE = codigoMunicipioIBGE;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getUF() {
		return uF;
	}
	public void setUF(String uF) {
		this.uF = uF;
	}
	public String getCEP() {
		return cEP;
	}
	public void setCEP(String cEP) {
		this.cEP = cEP;
	}
	public String getcPais() {
		return cPais;
	}
	public void setcPais(String cPais) {
		this.cPais = cPais;
	}
	public String getxPais() {
		return xPais;
	}
	public void setxPais(String xPais) {
		this.xPais = xPais;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	
	
	
	

}
