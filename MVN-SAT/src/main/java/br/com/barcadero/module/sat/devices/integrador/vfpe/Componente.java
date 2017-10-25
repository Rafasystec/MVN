package br.com.barcadero.module.sat.devices.integrador.vfpe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Componente")
@XmlAccessorType(XmlAccessType.FIELD)
public class Componente {
	@XmlElement(name="Metodo")
	private Metodo metodo;

	public Metodo getMetodo() {
		return metodo;
	}

	public void setMetodo(Metodo metodo) {
		this.metodo = metodo;
	}
}
