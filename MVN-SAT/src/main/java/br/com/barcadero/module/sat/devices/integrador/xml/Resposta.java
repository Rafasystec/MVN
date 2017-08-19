package br.com.barcadero.module.sat.devices.integrador.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Resposta")
@XmlAccessorType(XmlAccessType.FIELD)
public class Resposta {

	@XmlElement(name="retorno")
	private String retorno;
	public String getRetorno() {
		return retorno;
	}
	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}

}
