package br.com.barcadero.core.xml.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="cliente")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLCliente {

	private long codigo = 12L;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
}
