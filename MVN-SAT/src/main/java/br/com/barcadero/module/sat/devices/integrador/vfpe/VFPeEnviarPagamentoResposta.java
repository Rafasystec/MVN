package br.com.barcadero.module.sat.devices.integrador.vfpe;

/**
 * Este Método notifica o sistema Validador Fiscal de Pagamentos Eletrônicos que o PDV/AC 
 * irá iniciar um processo de pagamento enviando a solicitação para o POS, ele deverá ser 
 * precedido a conclusão da venda e seu retorno IDPAGAMENTO deverá ser guardado na base de 
 * dados para posterior utilização.
	Componente: VFP-e
	Método: EnviarPagamento
 * @author Rafael Rocha
 *
 */
public class VFPeEnviarPagamentoResposta {

	private IntegradorRetorno integrador;

	public IntegradorRetorno getIntegrador() {
		return integrador;
	}

	public void setIntegrador(IntegradorRetorno integrador) {
		this.integrador = integrador;
	}
	
}
