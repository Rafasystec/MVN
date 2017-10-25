package br.com.barcadero.module.sat.devices.integrador.vfpe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.barcadero.module.sat.devices.integrador.xml.Identificador;
import br.com.barcadero.module.sat.devices.integrador.xml.IntegradorResposta;

@XmlRootElement(name="Integrador")
@XmlAccessorType(XmlAccessType.FIELD)
public class IntegradorRetorno {
	@XmlElement(name="Identificador")
	private Identificador identificador;
	@XmlElement(name="IntegradorResposta")
	private IntegradorResposta integradorResposta;
	@XmlElement(name="IdPagamento")
	private String idPagamento;
	@XmlElement(name="Mensagem")
	private String mensagem;
	@XmlElement(name="StatusPagamento")
	private String statusPagamento;
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
	public String getIdPagamento() {
		return idPagamento;
	}
	public void setIdPagamento(String idPagamento) {
		this.idPagamento = idPagamento;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getStatusPagamento() {
		return statusPagamento;
	}
	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

}
