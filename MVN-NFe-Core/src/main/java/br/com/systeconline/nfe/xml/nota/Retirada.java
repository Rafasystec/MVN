package br.com.systeconline.nfe.xml.nota;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.systeconline.nfe.xml.CNPJ;
import br.com.systeconline.nfe.xml.CPF;

//F01
@XmlRootElement(name="retirada")
@XmlAccessorType(XmlAccessType.FIELD)
public class Retirada {

	
	@XmlElements(value ={
			@XmlElement(name="CNPJ",type=CNPJ.class),
			@XmlElement(name="CPF", type=CPF.class)
	})
	private Object choiceCPFCNPJ;
	@XmlElement(name="xLgr", required=true)
	private String xLgr;
	@XmlElement(name="nro", required=true)
	private String nro;
	@XmlElement(name="xCpl", required=true)
	private String xCpl;
	@XmlElement(name="xBairro", required=true)
	private String xBairro;
	@XmlElement(name="cMun", required=true)
	private String cMun;
	@XmlElement(name="xMun", required=true)
	private String xMun;
	@XmlElement(name="UF", required=true)
	private String uF;
	public Object getChoiceCPFCNPJ() {
		return choiceCPFCNPJ;
	}
	public void setChoiceCPFCNPJ(Object choiceCPFCNPJ) {
		this.choiceCPFCNPJ = choiceCPFCNPJ;
	}
	public String getxLgr() {
		return xLgr;
	}
	public void setxLgr(String xLgr) {
		this.xLgr = xLgr;
	}
	public String getNro() {
		return nro;
	}
	public void setNro(String nro) {
		this.nro = nro;
	}
	public String getxCpl() {
		return xCpl;
	}
	public void setxCpl(String xCpl) {
		this.xCpl = xCpl;
	}
	public String getxBairro() {
		return xBairro;
	}
	public void setxBairro(String xBairro) {
		this.xBairro = xBairro;
	}
	public String getcMun() {
		return cMun;
	}
	public void setcMun(String cMun) {
		this.cMun = cMun;
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
