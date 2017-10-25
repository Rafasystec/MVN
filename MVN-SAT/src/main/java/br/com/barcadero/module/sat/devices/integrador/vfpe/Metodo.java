package br.com.barcadero.module.sat.devices.integrador.vfpe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.barcadero.module.sat.devices.integrador.xml.Parametros;

@XmlRootElement(name="Metodo")
@XmlAccessorType(XmlAccessType.FIELD)
public class Metodo {
	@XmlAttribute(name="Nome")
	private String nome;
	@XmlElement(name="Construtor")
	private Construtor construtor;
	@XmlElement(name="Parametros")
	private Parametros parametros;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Construtor getConstrutor() {
		return construtor;
	}
	public void setConstrutor(Construtor construtor) {
		this.construtor = construtor;
	}
	public Parametros getParametros() {
		return parametros;
	}
	public void setParametros(Parametros parametros) {
		this.parametros = parametros;
	}
	
	
}
