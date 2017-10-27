package br.com.barcadero.module.sat.devices.integrador.vfpe;

import java.util.ArrayList;
import java.util.List;

import br.com.barcadero.commons.xml.HandleXML;
import br.com.barcadero.module.sat.devices.integrador.xml.Identificador;
import br.com.barcadero.module.sat.devices.integrador.xml.Parametro;
import br.com.barcadero.module.sat.devices.integrador.xml.Parametros;
import br.com.barcadero.module.sat.enums.EnumCodigoRetIntegrador;

public class HelperEnviarPagamento {
	/**
	 * 
	 * @return
	 */
	private static VFPeEnviarPagamento build(ParametrosPagamentoVFPe pagamentoVFPe) {
		VFPeEnviarPagamento vfPeEnviarPagamento = new VFPeEnviarPagamento();
		Integrador integrador 					= new Integrador();
		Identificador identificador 			= new Identificador();
		identificador.setValor(pagamentoVFPe.getIdentificador());
		integrador.setIdentificador(identificador );
		Componente componente 					= new Componente();
		Metodo metodo 							= new Metodo();
		//NOTE: XML do construtor
		Construtor construtor 					= new Construtor();
		Parametros parametros 					= new Parametros();
		List<Parametro> listParametros 			= new ArrayList<>();
		Parametro parametro 					= new Parametro();
		parametro.setNome("chaveAcessoValidador");
		parametro.setValor(pagamentoVFPe.getChaveAcessoValidador());
		listParametros.add(parametro);
		parametros.setParametro(listParametros );
		construtor.setParametros(parametros );
		metodo.setConstrutor(construtor);
		//NOTE: Parametros do Metodo
		Parametros parametrosMetodo 			= new Parametros();
		List<Parametro> listParametrosMetodo 	= new ArrayList<>();
		//Chave requisicao
		Parametro paramChaveRequisicao = new Parametro();
		paramChaveRequisicao.setNome("ChaveRequisicao");
		paramChaveRequisicao.setValor(pagamentoVFPe.getChaveRequisicao());
		listParametrosMetodo.add(paramChaveRequisicao);
		//Estabelecimento
		Parametro paramEstabelecimento = new Parametro();
		paramEstabelecimento.setNome("Estabelecimento");
		paramEstabelecimento.setValor(pagamentoVFPe.getEstabelecimento());
		listParametrosMetodo.add(paramEstabelecimento);
		//Serial POS
		Parametro paramSerialPOS = new Parametro();
		paramSerialPOS.setNome("SerialPos");
		paramSerialPOS.setValor(pagamentoVFPe.getSerialPOS());
		listParametrosMetodo.add(paramSerialPOS);
		//
		Parametro paramCNPJ = new Parametro();
		paramCNPJ.setNome("Cnpj");
		paramCNPJ.setValor(pagamentoVFPe.getEstabelecimento());
		listParametrosMetodo.add(paramCNPJ);
		//
		Parametro paramICMSBase = new Parametro();
		paramICMSBase.setNome("IcmsBase");
		paramICMSBase.setValor(pagamentoVFPe.getIcmsBase());
		listParametrosMetodo.add(paramICMSBase);
		//
		Parametro paramValorTotalVenda = new Parametro();
		paramValorTotalVenda.setNome("ValorTotalVenda");
		paramValorTotalVenda.setValor(pagamentoVFPe.getValorTotalVenda());
		listParametrosMetodo.add(paramValorTotalVenda);
		//
		Parametro paramIdFilaValidador = new Parametro();
		paramIdFilaValidador.setNome("IdFilaValidador");
		paramIdFilaValidador.setValor(pagamentoVFPe.getIdentificador());
		listParametrosMetodo.add(paramIdFilaValidador);
		//
		Parametro paramHabilitarMultPgto = new Parametro();
		paramHabilitarMultPgto.setNome("HabilitarMultiplosPagamentos");
		paramHabilitarMultPgto.setValor(pagamentoVFPe.getHabilitarMultiplosPagamentos());
		listParametrosMetodo.add(paramHabilitarMultPgto);
		//
		Parametro paramHabilitarControleAntiFraudes = new Parametro();
		paramHabilitarControleAntiFraudes.setNome("HabilitarControleAntiFraude");
		paramHabilitarControleAntiFraudes.setValor(pagamentoVFPe.getHabilitarControleAntiFraude());
		listParametrosMetodo.add(paramHabilitarControleAntiFraudes);
		//
		Parametro paramCodigoModeda = new Parametro();
		paramCodigoModeda.setNome("CodigoMoeda");
		paramCodigoModeda.setValor(pagamentoVFPe.getCodigoMoeda());
		listParametrosMetodo.add(paramCodigoModeda);
		//
		Parametro paramOrigemPgto = new Parametro();
		paramOrigemPgto.setNome("OrigemPagamento");
		paramOrigemPgto.setValor(pagamentoVFPe.getOrigemPagamento());
		listParametrosMetodo.add(paramOrigemPgto);
		//
		Parametro paramEmitirCupomNFCE = new Parametro();
		paramEmitirCupomNFCE.setNome("EmitirCupomNFCE");
		paramEmitirCupomNFCE.setValor(pagamentoVFPe.getEmitirCupomNFCE());
		listParametrosMetodo.add(paramEmitirCupomNFCE);
		
		parametrosMetodo.setParametro(listParametrosMetodo);
		metodo.setParametros(parametros);
		componente.setMetodo(metodo);
		integrador.setComponente(componente );
		vfPeEnviarPagamento.setIntegrador(integrador );
		
		return vfPeEnviarPagamento;
	}
	
	public static VFPeEnviarPagamento buildXML(ParametrosPagamentoVFPe pagamentoVFPe) {
		try {
			return build(pagamentoVFPe);
		} catch (Exception e) {
			e.printStackTrace();
			return new VFPeEnviarPagamento();
		}
	}
	/**
	 * 
	 * @param xmlRetorno
	 * @return
	 */
	public static VFPeRetornoParaAplicacao gerarRetornoParaAplicacao(String xmlRetorno) {
		if(xmlRetorno != null && !xmlRetorno.trim().isEmpty()){
			try {
				IntegradorRetorno integradorRetorno = (IntegradorRetorno) HandleXML.unMarshal(xmlRetorno, IntegradorRetorno.class);
				if(integradorRetorno != null){
					VFPeRetornoParaAplicacao retornoParaAplicacao = new VFPeRetornoParaAplicacao();
					retornoParaAplicacao.setCodigo(EnumCodigoRetIntegrador.getByDescription(integradorRetorno.getIntegradorResposta().getCodigo()));
					retornoParaAplicacao.setIdentificador(integradorRetorno.getIdentificador().getValor());
					retornoParaAplicacao.setIdPagamentoNSU(integradorRetorno.getIdPagamento());
					retornoParaAplicacao.setMensagem(integradorRetorno.getMensagem());
					retornoParaAplicacao.setDetalheRetorno(integradorRetorno.getIntegradorResposta().getValor());
					return retornoParaAplicacao;
				}else{
					return new VFPeRetornoParaAplicacao();
				}
			} catch (Exception e) {
				return new VFPeRetornoParaAplicacao();
			}
		}else{
			return new VFPeRetornoParaAplicacao();
		}
	}
}
