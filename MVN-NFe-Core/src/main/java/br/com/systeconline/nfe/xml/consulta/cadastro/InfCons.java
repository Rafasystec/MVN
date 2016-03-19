package br.com.systeconline.nfe.xml.consulta.cadastro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="infCons")
@XmlAccessorType(XmlAccessType.FIELD)
public class InfCons {
	
	@XmlElement
	private String xServ;
	@XmlElement(name="UF")
	private String uf;
	@XmlElement(name="IE")
	private String ie;
	@XmlElement(name="CNPJ")
	private String cnpj;
	@XmlElement(name="CPF")
	private String cpf;
	
	public String getxServ() {
		return xServ;
	}
	public void setxServ(String xServ) {
		this.xServ = xServ;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getIe() {
		return ie;
	}
	public void setIe(String ie) {
		this.ie = ie;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

}
