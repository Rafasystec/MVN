package br.com.barcadero.module.sat.devices.integrador.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlRootElement(name="IntegradorResposta")
@XmlAccessorType(XmlAccessType.FIELD)
public class IntegradorResposta {

	@XmlElement(name="Codigo")
	private String codigo;
	@XmlElement(name="Valor")
	private String valor;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

}
