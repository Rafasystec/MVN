package br.com.barcadero.module.sat.devices.integrador.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Metodo")
@XmlAccessorType(XmlAccessType.FIELD)
public class Metodo {
	@XmlAttribute(name="Nome")
	private String nome;
	@XmlElement(name="Parametros")
	private Parametros parametros;

	public Parametros getParametros() {
		return parametros;
	}

	public void setParametros(Parametros parametros) {
		this.parametros = parametros;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
