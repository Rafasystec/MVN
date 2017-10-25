package br.com.barcadero.module.sat.devices.integrador.vfpe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import br.com.barcadero.module.sat.devices.integrador.xml.Identificador;

@XmlRootElement(name="Integrador")
@XmlAccessorType(XmlAccessType.FIELD)
public class Integrador {
	
	@XmlElement(name="Identificador")
	private Identificador identificador;
	@XmlElement(name="Componente")
	private Componente componente;
	public Identificador getIdentificador() {
		return identificador;
	}
	public void setIdentificador(Identificador identificador) {
		this.identificador = identificador;
	}
	public Componente getComponente() {
		return componente;
	}
	public void setComponente(Componente componente) {
		this.componente = componente;
	}
}
