package br.com.barcadero.module.sat.devices.integrador.vfpe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.barcadero.module.sat.devices.integrador.xml.Identificador;
import br.com.barcadero.module.sat.devices.integrador.xml.IntegradorResposta;


@XmlRootElement(name="Integrador")
@XmlAccessorType(XmlAccessType.FIELD)
public class VFPeVerificarStatusValidadorResposta {
	@XmlElement(name="Identificador")
	private Identificador identificador;
	@XmlElement(name="IntegradorResposta")
	private IntegradorResposta integradorResposta;
	@XmlElement(name="Resposta")
	private Resposta resposta;
	public Identificador getIdentificador() {
		return identificador;
	}
	public void setIdentificador(Identificador identificador) {
		this.identificador = identificador;
	}
	public IntegradorResposta getIntegradorResposta() {
		return integradorResposta;
	}
	public void setIntegradorResposta(IntegradorResposta integradorResposta) {
		this.integradorResposta = integradorResposta;
	}
	public Resposta getResposta() {
		return resposta;
	}
	public void setResposta(Resposta resposta) {
		this.resposta = resposta;
	}

}
