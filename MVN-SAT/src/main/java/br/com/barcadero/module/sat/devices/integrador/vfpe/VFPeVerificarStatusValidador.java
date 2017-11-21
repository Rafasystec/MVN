package br.com.barcadero.module.sat.devices.integrador.vfpe;

import br.com.barcadero.module.sat.devices.integrador.xml.Identificador;

/**
 * Neste método o PDV/AC poderá consultar no Validador Fiscal de Pagamentos Eletrônicos se a sua solicitação de pagamento 
 * realizada anteriormente já foi processada pelo POS, caso afirmativo o PDV/AC receberá os dados de pagamento para gravação 
 * em seu banco de dados e utilização para seus registros e envios ao documento fiscal. Para realização da consulta é necessário 
 * que o PDV/AC informe ao Validador Fiscal de Pagamentos Eletrônicos o número do IDPAGAMENTO recebido na solicitação de pagamento 
 * realizada no método “EnviarPagamento”.
 * Não havendo internet este processo retornará um arquivo com um IDPAGAMENTO local gerado pelo Integrador Fiscal, estritamente 
 * para que o AC/PDV possa seguir seu fluxo de trabalho, porém ao retornar a internet deverá ser reenviado a solicitação ao VFP-e 
 * através da interface ENVIARPAGAMENTO e recuperar o IDPAGAMENTO gerado pela SEFAZ, o qual será utilizado para cumprimento dos 
 * requisitos estipulados
 * @author Rafael Rocha
 */
public class VFPeVerificarStatusValidador {
	
	public static Integrador montarXMLVerificarStatusValidador(VFPeVerificarStatusValidadorDadosParaEnviar dadosParaEnviar) {
		Integrador integrador 		= new Integrador();
		Componente componente 		= new  Componente();
		Metodo metodo 				= new Metodo();
		Identificador identificador = new Identificador();
		Construtor construtor 		= new Construtor();
		metodo.setConstrutor(construtor );
		metodo.setNome("VFP-e");
		componente.setMetodo(metodo);
		integrador.setComponente(componente );
		identificador.setValor(dadosParaEnviar.getValorIdentificador());
		integrador.setIdentificador(identificador );
		return integrador;
	}
}
