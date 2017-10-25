package br.com.barcadero.module.sat.devices.integrador.vfpe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.barcadero.module.sat.devices.integrador.xml.Parametros;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Construtor {
	@XmlElement(name="Parametros")
	private Parametros parametros;

	public Parametros getParametros() {
		return parametros;
	}

	public void setParametros(Parametros parametros) {
		this.parametros = parametros;
	}
}
