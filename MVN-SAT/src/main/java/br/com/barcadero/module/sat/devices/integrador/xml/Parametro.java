package br.com.barcadero.module.sat.devices.integrador.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Parametro")
@XmlAccessorType(XmlAccessType.FIELD)
public class Parametro {

	@XmlElement(name="Nome")
	private String nome = "";
	@XmlElement(name="Valor")
	private String valor = "";
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getValor() {
		String value = HandleXML.normalize(valor);
		System.out.println(value);
		return value;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
	
}
