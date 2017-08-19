package br.com.barcadero.module.sat.devices.integrador.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Identificador")
@XmlAccessorType(XmlAccessType.FIELD)
public class Identificador {

	@XmlElement(name="Valor")
	private String valor = "";

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}
