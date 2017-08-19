package br.com.barcadero.module.sat.devices.integrador.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Parametros")
@XmlAccessorType(XmlAccessType.FIELD)
public class Parametros {
	
	@XmlElement(name="Parametro")
	private List<Parametro> parametro;

	public List<Parametro> getParametro() {
		return parametro;
	}

	public void setParametro(List<Parametro> parametro) {
		this.parametro = parametro;
	}

}
