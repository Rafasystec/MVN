package br.com.systeconline.nfe.xml.nota;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//Z07
@XmlRootElement(name="obsFisco")
@XmlAccessorType(XmlAccessType.FIELD)
public class ObsFisco {

	@XmlAttribute(required=true)
	private String xCampo;
	@XmlElement(required=true)
	private String xTexto;
	public String getxCampo() {
		return xCampo;
	}
	public void setxCampo(String xCampo) {
		this.xCampo = xCampo;
	}
	public String getxTexto() {
		return xTexto;
	}
	public void setxTexto(String xTexto) {
		this.xTexto = xTexto;
	}
	
}
