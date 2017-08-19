package br.com.barcadero.module.sat.devices.integrador.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Componente")
@XmlAccessorType(XmlAccessType.FIELD)
public class Componente {

	@XmlAttribute(name="Nome")
	private String nome = "MF-e";
	@XmlElement(name="Metodo")
	private Metodo metodo;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Metodo getMetodo() {
		return metodo;
	}
	public void setMetodo(Metodo metodo) {
		this.metodo = metodo;
	}
}
