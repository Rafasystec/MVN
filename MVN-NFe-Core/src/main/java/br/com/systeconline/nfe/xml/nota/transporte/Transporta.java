package br.com.systeconline.nfe.xml.nota.transporte;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.systeconline.nfe.xml.CNPJ;
import br.com.systeconline.nfe.xml.CPF;

//X03
@XmlRootElement(name="transporta")
@XmlAccessorType(XmlAccessType.FIELD)
public class Transporta {
	
	@XmlElements(value = {
			@XmlElement(name="CNPJ",type=CNPJ.class),
			@XmlElement(name="CPF", type=CPF.class)
	})
	private Object cpfCnpj;
	@XmlElement(name="xNome",required=false)
	private String xNome;
	@XmlElement(name="IE",required=false)
	private String iE;
	@XmlElement(name="xEnder",required=false)
	private String xEnder;
	@XmlElement(name="xMun",required=false)
	private String xMun;
	@XmlElement(name="UF",required=false)
	private String uF;
	public Object getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(Object cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getxNome() {
		return xNome;
	}
	public void setxNome(String xNome) {
		this.xNome = xNome;
	}
	public String getiE() {
		return iE;
	}
	public void setiE(String iE) {
		this.iE = iE;
	}
	public String getxEnder() {
		return xEnder;
	}
	public void setxEnder(String xEnder) {
		this.xEnder = xEnder;
	}
	public String getxMun() {
		return xMun;
	}
	public void setxMun(String xMun) {
		this.xMun = xMun;
	}
	public String getuF() {
		return uF;
	}
	public void setuF(String uF) {
		this.uF = uF;
	}
}
