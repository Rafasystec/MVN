package br.com.barcadero.module.sat.socket;

import br.com.barcadero.commons.socket.SocketDados;
import br.com.barcadero.module.sat.devices.integrador.vfpe.ParametrosPagamentoVFPe;
import br.com.barcadero.module.sat.devices.integrador.vfpe.VFPeRetornoParaAplicacao;

public class CmdEnviarPagamentoVFe extends SocketDados {
	
	private static final long serialVersionUID = 5136829854437855233L;
	private ParametrosPagamentoVFPe pagamentoVFPe;
	private VFPeRetornoParaAplicacao retornoParaAplicacao;

	public ParametrosPagamentoVFPe getPagamentoVFPe() {
		return pagamentoVFPe;
	}

	public void setPagamentoVFPe(ParametrosPagamentoVFPe pagamentoVFPe) {
		this.pagamentoVFPe = pagamentoVFPe;
	}

	public VFPeRetornoParaAplicacao getRetornoParaAplicacao() {
		return retornoParaAplicacao;
	}

	public void setRetornoParaAplicacao(VFPeRetornoParaAplicacao retornoParaAplicacao) {
		this.retornoParaAplicacao = retornoParaAplicacao;
	}

}
