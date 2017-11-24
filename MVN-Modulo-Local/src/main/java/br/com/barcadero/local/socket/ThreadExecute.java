package br.com.barcadero.local.socket;

import java.util.concurrent.Callable;

import br.com.barcadero.commons.loggin.LogFactory;
import br.com.barcadero.commons.socket.SocketCommand;
import br.com.barcadero.commons.socket.SocketDados;
import br.com.barcadero.commons.xml.HandleXML;
import br.com.barcadero.local.persistence.dao.DaoCFeCancelamento;
import br.com.barcadero.local.persistence.dao.DaoCFeVendas;
import br.com.barcadero.local.persistence.dao.DaoEnviarPagamento;
import br.com.barcadero.local.persistence.dao.DaoStatusValidadorFiscal;
import br.com.barcadero.local.persistence.model.CFeCancelamento;
import br.com.barcadero.local.persistence.model.CFeVenda;
import br.com.barcadero.local.persistence.model.VFPeEnviarPagamento;
import br.com.barcadero.local.persistence.model.VFPeVerificarStatusValidadorResp;
import br.com.barcadero.module.sat.devices.integrador.vfpe.IntegradorRetorno;
import br.com.barcadero.module.sat.devices.integrador.vfpe.Resposta;
import br.com.barcadero.module.sat.devices.integrador.vfpe.VFPeEnviarPagamentoResposta;
import br.com.barcadero.module.sat.devices.integrador.vfpe.VFPeVerificarStatusValidadorResposta;
import br.com.barcadero.module.sat.devices.integrador.xml.Identificador;
import br.com.barcadero.module.sat.devices.integrador.xml.IntegradorResposta;
import br.com.barcadero.module.sat.handle.HandleRetornoSAT;
import br.com.barcadero.module.sat.handle.HandleSAT;
import br.com.barcadero.module.sat.socket.CmdCancelarUltimaVenda;
import br.com.barcadero.module.sat.socket.CmdConsultarSAT;
import br.com.barcadero.module.sat.socket.CmdEnviarDadosVenda;
import br.com.barcadero.module.sat.socket.CmdEnviarPagamentoVFe;
import br.com.barcadero.module.sat.socket.CmdRespostaFiscal;
import br.com.barcadero.module.sat.socket.CmdVerificarStatusValidador;

public class ThreadExecute implements Callable<String> {


	private SocketCommand command;
	public ThreadExecute(SocketCommand command) {
		this.command = command;
	}
	
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return execute(getCommand());
	}
	
	private String execute(SocketCommand command) throws Exception {
		try{
			switch (command.getTipoComando()) {
			case CMD_FOR_ECF:
				System.out.println("Comunicacao com o ECF nao implementado");
				return "ECF não implementado.";
			case CMD_FOR_SAT:
				LogFactory.addInfor("Executar comando SAT: "+command.getCommand());
				return executarComandoSAT(command);
			default:
				return "Tipo de comando não implementado : " + command.getTipoComando().toString() ;
			}
		}catch(Exception e){
			return "Erro ao executar comando: " + e.getMessage();
		}
	}

	public SocketCommand getCommand() {
		return command;
	}

	public void setCommand(SocketCommand command) {
		this.command = command;
	}
	/**
	 * Definir o modulo SAT
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public String executarComandoSAT(SocketCommand command) throws Exception{
		SocketDados dados 	= command.getDados();
		HandleSAT handleSAT = null;
		String result		= "";
		try{
			handleSAT = new HandleSAT(command.getModuloSAT());
		}catch(UnsatisfiedLinkError linkErro){ 
			LogFactory.addInfor(result);
			LogFactory.addError(linkErro);
			result = "Erro ao carregar a DLL/SO: "+linkErro.getMessage();
		}catch(Exception e){
			LogFactory.addInfor("ERRO GRAVE: " + result);
			result = "Erro ao tentar instanciar SAT"+e.getMessage();
		}
		if(result.trim().isEmpty()){
			try{
				if(dados instanceof CmdConsultarSAT){
					result = handleSAT.consultarSAT();
				}else if(dados instanceof CmdEnviarDadosVenda){
					CmdEnviarDadosVenda dadosVenda = (CmdEnviarDadosVenda) dados;
					CFeVenda cFeVenda = salvarVendaInicial(dadosVenda.getNumeroSessao(), dadosVenda.getDadosVenda());
					result = handleSAT.enviarDadosVenda(dadosVenda.getNumeroSessao(), dadosVenda.getDadosVenda(), dadosVenda.getCodigoDeAtivacao());
					salvarRetornoVenda(result,cFeVenda);
				}else if(dados instanceof CmdCancelarUltimaVenda){
					CmdCancelarUltimaVenda cancelarUltimaVenda = (CmdCancelarUltimaVenda) dados;
					CFeCancelamento cancelamentoInicial = salvarCancelamentoInicial(cancelarUltimaVenda.getNumeroSessao(), cancelarUltimaVenda.getDadosCancelamento(),cancelarUltimaVenda.getChave());
					result = handleSAT.cancelarUltimaVenda(cancelarUltimaVenda.getNumeroSessao(), cancelarUltimaVenda.getChave(), cancelarUltimaVenda.getCodigoDeAtivacao(),cancelarUltimaVenda.getDadosCancelamento());
					salvarCancelamento(result,cancelamentoInicial);
				}else if(dados instanceof CmdEnviarPagamentoVFe){
					CmdEnviarPagamentoVFe cmdEnviarPagamentoVFe = (CmdEnviarPagamentoVFe) dados;
					result = handleSAT.executarEnviarPagamentoVFe(cmdEnviarPagamentoVFe);
					salvarRetornoEnviarPagamento(result);
				}else if(dados instanceof CmdVerificarStatusValidador) {
					LogFactory.addInfor("Verificar Status validador Fiscal:");
					CmdVerificarStatusValidador cmdVerificarStatusValidador = (CmdVerificarStatusValidador) dados;
					result = handleSAT.executarVerificarStatusValidador(cmdVerificarStatusValidador.getDadosParaEnviarAoValidador());
					LogFactory.addInfor("Retorno do Integrador: ");
					LogFactory.addInfor(result);
					salvarStatusValidador(result);
				}else if(dados instanceof CmdRespostaFiscal){
					//TODO: proceder com a resposta fiscal.
				}else{
					result = "Comando não configurado!";
				}
			}catch(Exception e){
				result = "Erro ao tentar executar função: "+e.getMessage();
			}
		}
		return result;
	}
	
	/**
	 * Salva os dados da resposta ao comando StatusValidadorFiscal
	 * @param xml
	 */
	private void salvarStatusValidador(String xml) {
		LogFactory.addInfor("Preparando para salvar a resposta do Integrador ao comando StatusValidadorFiscal");
		VFPeVerificarStatusValidadorResposta statusValidador = null;
		VFPeVerificarStatusValidadorResp validadorResp       = new VFPeVerificarStatusValidadorResp();
		try {
			statusValidador = (VFPeVerificarStatusValidadorResposta) HandleXML.unMarshal(xml, VFPeVerificarStatusValidadorResposta.class);
			if(statusValidador != null) {
				Identificador identificador = statusValidador.getIdentificador();
				if(identificador != null) {
					validadorResp.setValor( identificador.getValor());
				}
				IntegradorResposta integradorResposta = statusValidador.getIntegradorResposta();
				if(integradorResposta != null) {
					String codigo = integradorResposta.getCodigo();
					if(!codigo.equalsIgnoreCase("AP")) {
						LogFactory.addInfor("Erro retornado do Integrador: "+ codigo);
						String valor = integradorResposta.getValor();
						if(valor != null && !valor.trim().isEmpty()) {
							LogFactory.addError(valor);
						}
					}else {
						Resposta resposta = statusValidador.getResposta();
						if(resposta != null) {
							validadorResp.setBin(resposta.getBin());
							validadorResp.setCodigoAutorizacao(resposta.getCodigoAutorizacao());
							validadorResp.setCodigoPagamento(resposta.getCodigoPagamento());
							validadorResp.setDataExpiracao(resposta.getDataExpiracao());
							validadorResp.setDonoCartao(resposta.getDonoCartao());
							validadorResp.setIdFila(resposta.getIdFila());
							validadorResp.setInstituicaoFinanceira(resposta.getInstituicaoFinanceira());
							validadorResp.setParcelas(resposta.getParcelas());
							validadorResp.setTipo(resposta.getTipo());
							validadorResp.setUltimos4digitos(resposta.getUltimosQuatroDigitos());
							validadorResp.setValor(resposta.getValorPagamento());
							DaoStatusValidadorFiscal daoStatusValidadorFiscal = new DaoStatusValidadorFiscal();
							daoStatusValidadorFiscal.insert(validadorResp);
						}else {
							LogFactory.addInfor("Os dados de resposta não vieram do Integrador - Comando: StatusValidadorFiscal");
						}
					}
				}
			}
		} catch (Exception e) {
			LogFactory.addError(e);
		}
	}
	
	private void salvarRetornoEnviarPagamento(String xmlDeRetorno) {
		if(xmlDeRetorno != null && !xmlDeRetorno.trim().isEmpty()) {
			try {
				VFPeEnviarPagamentoResposta pagamentoResposta = (VFPeEnviarPagamentoResposta) HandleXML.unMarshal(xmlDeRetorno, VFPeEnviarPagamentoResposta.class);
				if(pagamentoResposta != null) {
					IntegradorRetorno integrador = pagamentoResposta.getIntegrador();
					if(integrador != null) {
						String identificador = integrador.getIdentificador().getValor();
						String idPagamento 	 = integrador.getIdPagamento();
						String codigo 		 = integrador.getIntegradorResposta().getCodigo();
						String valor 		 = integrador.getIntegradorResposta().getValor();
						VFPeEnviarPagamento enviarPagamento = new VFPeEnviarPagamento();
						enviarPagamento.setIdentificador(identificador);
						enviarPagamento.setIdPagamento(idPagamento);
						enviarPagamento.setMensagem(valor);
						enviarPagamento.setCodigo(codigo);
						DaoEnviarPagamento daoEnviarPagamento = new DaoEnviarPagamento();
						daoEnviarPagamento.insert(enviarPagamento);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private CFeCancelamento salvarCancelamentoInicial(int numeroSessao, String dadosCancelamento, String chaveCFeACancelar) {
		CFeCancelamento cFeCancelamento = new CFeCancelamento();
		cFeCancelamento.setXml(dadosCancelamento);
		cFeCancelamento.setNumeroSessao(""+numeroSessao);
		cFeCancelamento.setChaveASerCancelada(chaveCFeACancelar);
		DaoCFeCancelamento daoCFeCancelamento = new DaoCFeCancelamento();
		try {
			return daoCFeCancelamento.insert(cFeCancelamento);
		} catch (Exception e) {
			e.printStackTrace();
			return new CFeCancelamento();
		}
		
	}
	private void salvarCancelamento(String result,CFeCancelamento cFeCancelamento) {
		try {
			LogFactory.addInfor("Preparando para gravar o cancelamento na base de dadso local.");
			HandleRetornoSAT retornoSAT = HandleSAT.tratarRetornoVenda(result);
			if(cFeCancelamento == null) {
				cFeCancelamento = new CFeCancelamento();
			}
			cFeCancelamento.setArquivoBase64(retornoSAT.getArquivoCFeSAT());
			cFeCancelamento.setAssinaturaQrcode(retornoSAT.getDigestValue());
			cFeCancelamento.setChaveConsulta(retornoSAT.getChaveDeConsulta());
			cFeCancelamento.setCpfCnpjValue(retornoSAT.getSignatureValue());
			cFeCancelamento.setCodCCCC(retornoSAT.getCod());
			cFeCancelamento.setCodErroSAT(retornoSAT.getCodigoRetorno1());
			cFeCancelamento.setCodSEFAZ(retornoSAT.getCodigoRetorno2());
			cFeCancelamento.setMensagemSAT(retornoSAT.getMensagem());
			cFeCancelamento.setNumeroSessao(retornoSAT.getNumeroSessao());
			cFeCancelamento.setTimeStamp(retornoSAT.getTimeStamp());
			cFeCancelamento.setValorTotalCFe(retornoSAT.getValorTotaldoCupom());
			DaoCFeCancelamento daoCFeCancelamento = new DaoCFeCancelamento();
			daoCFeCancelamento.insert(cFeCancelamento);
			LogFactory.addInfor("OK, comando e insecao executado");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void salvarRetornoVenda(String retorno,CFeVenda cFeVenda) {
		try {
			LogFactory.addInfor("Prepara para gravar a venda no banco de dados");
			HandleRetornoSAT retornoSAT = HandleSAT.tratarRetornoVenda(retorno);
			if(retornoSAT.getCodigoRetorno1().equals("06000")){
				if(cFeVenda == null) {
					cFeVenda = new CFeVenda();
				}
				cFeVenda.setArquivoBase64(retornoSAT.getArquivoCFeSAT());
				cFeVenda.setAssinaturaQrcode(retornoSAT.getDigestValue());

				cFeVenda.setCodCCCC(retornoSAT.getCodigoRetorno2());
				cFeVenda.setCodErroSAT(retornoSAT.getCodigoRetorno1());
				cFeVenda.setCodSEFAZ(retornoSAT.getCod());
				cFeVenda.setMensagemSAT(retornoSAT.getMensagem());
				cFeVenda.setMensagemSEFAZ(retornoSAT.getMensagemSEFAZ());
				cFeVenda.setNumeroSessao(retornoSAT.getNumeroSessao());
				
				cFeVenda.setChaveConsulta(retornoSAT.getChaveDeConsulta());
				cFeVenda.setCpfCnpjValue(retornoSAT.getSignatureValue());
				cFeVenda.setTimeStamp(retornoSAT.getTimeStamp());
				cFeVenda.setValorTotalCFe(retornoSAT.getValorTotaldoCupom());
				DaoCFeVendas daoCFeVendas = new DaoCFeVendas();
				daoCFeVendas.update(cFeVenda);
				LogFactory.addInfor("OK comando de insercao executado");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private CFeVenda salvarVendaInicial(int numeroSessao, String dadosVenda) {
		CFeVenda cFeVenda = new CFeVenda();
		cFeVenda.setNumeroSessao(""+numeroSessao);
		cFeVenda.setXml(dadosVenda);
		DaoCFeVendas daoCFeVendas = new DaoCFeVendas();
		try {
			return daoCFeVendas.insert(cFeVenda);
		} catch (Exception e) {
			e.printStackTrace();
			return new CFeVenda();
		}
	}

}
