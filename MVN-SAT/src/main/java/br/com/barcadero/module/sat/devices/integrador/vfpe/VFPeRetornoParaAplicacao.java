package br.com.barcadero.module.sat.devices.integrador.vfpe;

import br.com.barcadero.module.sat.enums.EnumCodigoRetIntegrador;

public class VFPeRetornoParaAplicacao {
	private String identificador;
	private EnumCodigoRetIntegrador codigo;
	private String idPagamentoNSU;
	private String mensagem;
	private String detalheRetorno;
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public EnumCodigoRetIntegrador getCodigo() {
		return codigo;
	}
	public void setCodigo(EnumCodigoRetIntegrador codigo) {
		this.codigo = codigo;
	}
	public String getIdPagamentoNSU() {
		return idPagamentoNSU;
	}
	public void setIdPagamentoNSU(String idPagamentoNSU) {
		this.idPagamentoNSU = idPagamentoNSU;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getDetalheRetorno() {
		return detalheRetorno;
	}
	public void setDetalheRetorno(String detalheRetorno) {
		this.detalheRetorno = detalheRetorno;
	}
}
