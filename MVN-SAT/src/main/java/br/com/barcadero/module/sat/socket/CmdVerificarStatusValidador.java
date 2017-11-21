package br.com.barcadero.module.sat.socket;

import br.com.barcadero.commons.socket.SocketDados;
import br.com.barcadero.module.sat.devices.integrador.vfpe.VFPeVerificarStatusValidador;
import br.com.barcadero.module.sat.devices.integrador.vfpe.VFPeVerificarStatusValidadorDadosParaEnviar;
import br.com.barcadero.module.sat.devices.integrador.vfpe.VFPeVerificarStatusValidadorResposta;

public class CmdVerificarStatusValidador extends SocketDados{

	private static final long serialVersionUID = 7396960183590209397L;
	private VFPeVerificarStatusValidadorResposta response;
	private VFPeVerificarStatusValidador statusValidador;
	private VFPeVerificarStatusValidadorDadosParaEnviar dadosParaEnviarAoValidador;
	public VFPeVerificarStatusValidadorResposta getResponse() {
		return response;
	}
	public void setResponse(VFPeVerificarStatusValidadorResposta response) {
		this.response = response;
	}
	public VFPeVerificarStatusValidador getStatusValidador() {
		return statusValidador;
	}
	public void setStatusValidador(VFPeVerificarStatusValidador statusValidador) {
		this.statusValidador = statusValidador;
	}
	public VFPeVerificarStatusValidadorDadosParaEnviar getDadosParaEnviarAoValidador() {
		return dadosParaEnviarAoValidador;
	}
	public void setDadosParaEnviarAoValidador(VFPeVerificarStatusValidadorDadosParaEnviar dadosParaEnviarAoValidador) {
		this.dadosParaEnviarAoValidador = dadosParaEnviarAoValidador;
	}
	
	
}
