package br.com.systeconline.nfe.xml.nota;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//ZB01
@XmlRootElement(name="compra")
@XmlAccessorType(XmlAccessType.FIELD)
public class InformacoesDeCompra {

	@XmlElement(required=false)
	private String xNEmp;
	@XmlElement(required=false)
	private String xPed;
	@XmlElement(required=false)
	private String xCont;
	public String getxNEmp() {
		return xNEmp;
	}
	public void setxNEmp(String xNEmp) {
		this.xNEmp = xNEmp;
	}
	public String getxPed() {
		return xPed;
	}
	public void setxPed(String xPed) {
		this.xPed = xPed;
	}
	public String getxCont() {
		return xCont;
	}
	public void setxCont(String xCont) {
		this.xCont = xCont;
	}
}
