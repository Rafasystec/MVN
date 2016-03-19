package br.com.systeconline.nfe.xml.nota;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//ZC04
@XmlRootElement(name="forDia")
@XmlAccessorType(XmlAccessType.FIELD)
public class FornecDiarioCana {

	@XmlAttribute(required=true)
	private String dia;
	@XmlElement(required=true)
	private String qtde;
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getQtde() {
		return qtde;
	}
	public void setQtde(String qtde) {
		this.qtde = qtde;
	}
	
	
}
