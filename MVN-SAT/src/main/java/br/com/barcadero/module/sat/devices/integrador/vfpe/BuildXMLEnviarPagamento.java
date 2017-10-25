package br.com.barcadero.module.sat.devices.integrador.vfpe;

import java.util.ArrayList;
import java.util.List;

import br.com.barcadero.module.sat.devices.integrador.xml.Identificador;
import br.com.barcadero.module.sat.devices.integrador.xml.Parametro;
import br.com.barcadero.module.sat.devices.integrador.xml.Parametros;

public class BuildXMLEnviarPagamento {
	private ParametrosPagamentoVFPe pagamentoVFPe;
	public BuildXMLEnviarPagamento(ParametrosPagamentoVFPe pagamentoVFPe) {
		setPagamentoVFPe(pagamentoVFPe);
	}
	public ParametrosPagamentoVFPe getPagamentoVFPe() {
		return pagamentoVFPe;
	}
	public void setPagamentoVFPe(ParametrosPagamentoVFPe pagamentoVFPe) {
		this.pagamentoVFPe = pagamentoVFPe;
	}
	
	public VFPeEnviarPagamentoResposta build() {
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
		paramEstabelecimento.setNome("ChaveRequisicao");
		paramEstabelecimento.setValor(pagamentoVFPe.getEstabelecimento());
		listParametrosMetodo.add(paramEstabelecimento);
		//Serial POS
		Parametro paramSerialPOS = new Parametro();
		paramSerialPOS.setNome("ChaveRequisicao");
		paramSerialPOS.setValor(pagamentoVFPe.getSerialPOS());
		listParametrosMetodo.add(paramSerialPOS);
		//
		Parametro paramCNPJ = new Parametro();
		paramCNPJ.setNome("ChaveRequisicao");
		paramCNPJ.setValor(pagamentoVFPe.getEstabelecimento());
		listParametrosMetodo.add(paramCNPJ);
		//
		Parametro paramICMSBase = new Parametro();
		paramICMSBase.setNome("ChaveRequisicao");
		paramICMSBase.setValor(pagamentoVFPe.getIcmsBase());
		listParametrosMetodo.add(paramICMSBase);
		//
		Parametro paramValorTotalVenda = new Parametro();
		paramValorTotalVenda.setNome("ChaveRequisicao");
		paramValorTotalVenda.setValor(pagamentoVFPe.getValorTotalVenda());
		listParametrosMetodo.add(paramValorTotalVenda);
		//
		Parametro paramIdFilaValidador = new Parametro();
		paramIdFilaValidador.setNome("ChaveRequisicao");
		paramIdFilaValidador.setValor(pagamentoVFPe.getIdentificador());
		listParametrosMetodo.add(paramIdFilaValidador);
		//
		Parametro paramHabilitarMultPgto = new Parametro();
		paramHabilitarMultPgto.setNome("ChaveRequisicao");
		paramHabilitarMultPgto.setValor(pagamentoVFPe.getHabilitarMultiplosPagamentos());
		listParametrosMetodo.add(paramHabilitarMultPgto);
		//
		Parametro paramHabilitarControleAntiFraudes = new Parametro();
		paramHabilitarControleAntiFraudes.setNome("ChaveRequisicao");
		paramHabilitarControleAntiFraudes.setValor(pagamentoVFPe.getHabilitarControleAntiFraude());
		listParametrosMetodo.add(paramHabilitarControleAntiFraudes);
		//
		Parametro paramCodigoModeda = new Parametro();
		paramCodigoModeda.setNome("ChaveRequisicao");
		paramCodigoModeda.setValor(pagamentoVFPe.getCodigoMoeda());
		listParametrosMetodo.add(paramCodigoModeda);
		
		parametrosMetodo.setParametro(listParametrosMetodo);
		metodo.setParametros(parametros);
		componente.setMetodo(metodo);
		integrador.setComponente(componente );
		vfPeEnviarPagamento.setIntegrador(integrador );
		
		return null;
	}
}
