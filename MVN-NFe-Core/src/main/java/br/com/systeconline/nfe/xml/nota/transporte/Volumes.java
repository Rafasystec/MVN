package br.com.systeconline.nfe.xml.nota.transporte;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
//X26
@XmlRootElement(name="vol")
@XmlAccessorType(XmlAccessType.FIELD)
public class Volumes {

	@XmlElement(required=false)
	private String qVol;
	@XmlElement(required=false)
	private String esp;
	@XmlElement(required=false)
	private String marca;
	@XmlElement(required=false)
	private String nVol;
	@XmlElement(required=false)
	private String pesoL;
	@XmlElement(required=false)
	private String pesoB;
	@XmlElement(required=false)
	private List<Lacre> lacres;
	public String getqVol() {
		return qVol;
	}
	public void setqVol(String qVol) {
		this.qVol = qVol;
	}
	public String getEsp() {
		return esp;
	}
	public void setEsp(String esp) {
		this.esp = esp;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getnVol() {
		return nVol;
	}
	public void setnVol(String nVol) {
		this.nVol = nVol;
	}
	public String getPesoL() {
		return pesoL;
	}
	public void setPesoL(String pesoL) {
		this.pesoL = pesoL;
	}
	public String getPesoB() {
		return pesoB;
	}
	public void setPesoB(String pesoB) {
		this.pesoB = pesoB;
	}
	public List<Lacre> getLacres() {
		return lacres;
	}
	public void setLacres(List<Lacre> lacres) {
		this.lacres = lacres;
	}
	
}
