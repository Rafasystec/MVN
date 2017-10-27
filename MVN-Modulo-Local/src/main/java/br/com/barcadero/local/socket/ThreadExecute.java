package br.com.barcadero.local.socket;

import java.util.concurrent.Callable;

import br.com.barcadero.commons.loggin.LogFactory;
import br.com.barcadero.commons.socket.SocketCommand;
import br.com.barcadero.commons.socket.SocketDados;
import br.com.barcadero.local.persistence.dao.DaoCFeCancelamento;
import br.com.barcadero.local.persistence.dao.DaoCFeVendas;
import br.com.barcadero.local.persistence.model.CFeCancelamento;
import br.com.barcadero.local.persistence.model.CFeVenda;
import br.com.barcadero.local.persistence.model.SuperCFeEntidade;
import br.com.barcadero.module.sat.handle.HandleRetornoSAT;
import br.com.barcadero.module.sat.handle.HandleSAT;
import br.com.barcadero.module.sat.socket.CmdCancelarUltimaVenda;
import br.com.barcadero.module.sat.socket.CmdConsultarSAT;
import br.com.barcadero.module.sat.socket.CmdEnviarDadosVenda;
import br.com.barcadero.module.sat.socket.CmdEnviarPagamentoVFe;

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
					result = handleSAT.enviarDadosVenda(dadosVenda.getNumeroSessao(), dadosVenda.getDadosVenda(), dadosVenda.getCodigoDeAtivacao());
					salvarRetornoVenda(result);
				}else if(dados instanceof CmdCancelarUltimaVenda){
					CmdCancelarUltimaVenda cancelarUltimaVenda = (CmdCancelarUltimaVenda) dados;
					result = handleSAT.cancelarUltimaVenda(cancelarUltimaVenda.getNumeroSessao(), cancelarUltimaVenda.getChave(), cancelarUltimaVenda.getCodigoDeAtivacao(),cancelarUltimaVenda.getDadosCancelamento());
					salvarCancelamento(result);
				}else if(dados instanceof CmdEnviarPagamentoVFe){
					CmdEnviarPagamentoVFe cmdEnviarPagamentoVFe = (CmdEnviarPagamentoVFe) dados;
					result = handleSAT.executarEnviarPagamentoVFe(cmdEnviarPagamentoVFe);
				}else{
					result = "Comando não configurado!";
				}
			}catch(Exception e){
				result = "Erro ao tentar executar função: "+e.getMessage();
			}
		}
		return result;
	}

	private void salvarCancelamento(String result) {
		try {
			LogFactory.addInfor("Preparando para gravar o cancelamento na base de dadso local.");
			HandleRetornoSAT retornoSAT = HandleSAT.tratarRetornoVenda(result);
			CFeCancelamento cFeCancelamento = new CFeCancelamento();
			cFeCancelamento.setArquivoBase64(retornoSAT.getArquivoCFeSAT());
			cFeCancelamento.setAssinaturaQrcode(retornoSAT.getDigestValue());
			cFeCancelamento.setChaveConsulta(retornoSAT.getChaveDeConsulta());
			cFeCancelamento.setCpfCnpjValue(retornoSAT.getSignatureValue());
			SuperCFeEntidade superCFeEntidade = new SuperCFeEntidade();
			superCFeEntidade.setCodCCCC(retornoSAT.getCod());
			superCFeEntidade.setCodErroSAT(retornoSAT.getCodigoRetorno1());
			superCFeEntidade.setCodSEFAZ(retornoSAT.getCodigoRetorno2());
			superCFeEntidade.setMensagemSAT(retornoSAT.getMensagem());
			superCFeEntidade.setNumeroSessao(retornoSAT.getNumeroSessao());
			cFeCancelamento.setSuperCFeEntidade(superCFeEntidade );
			cFeCancelamento.setTimeStamp(retornoSAT.getTimeStamp());
			cFeCancelamento.setValorTotalCFe(retornoSAT.getValorTotaldoCupom());
			DaoCFeCancelamento daoCFeCancelamento = new DaoCFeCancelamento();
			daoCFeCancelamento.insert(cFeCancelamento);
			LogFactory.addInfor("OK, comando e insecao executado");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void salvarRetornoVenda(String retorno) {
		try {
			LogFactory.addInfor("Prepara para gravar a venda no banco de dados");
			HandleRetornoSAT retornoSAT = HandleSAT.tratarRetornoVenda(retorno);
			if(retornoSAT.getCodigoRetorno1().equals("06000")){
				CFeVenda cFeVenda = new CFeVenda();
				cFeVenda.setArquivoBase64(retornoSAT.getArquivoCFeSAT());
				cFeVenda.setAssinaturaQrcode(retornoSAT.getDigestValue());
				SuperCFeEntidade cFeEntidade = new SuperCFeEntidade();
				cFeEntidade.setCodCCCC(retornoSAT.getCodigoRetorno2());
				cFeEntidade.setCodErroSAT(retornoSAT.getCodigoRetorno1());
				cFeEntidade.setCodSEFAZ(retornoSAT.getCod());
				cFeEntidade.setMensagemSAT(retornoSAT.getMensagem());
				cFeEntidade.setMensagemSEFAZ(retornoSAT.getMensagemSEFAZ());
				cFeEntidade.setNumeroSessao(retornoSAT.getNumeroSessao());
				cFeVenda.setcFeEntidade(cFeEntidade );
				cFeVenda.setChaveConsulta(retornoSAT.getChaveDeConsulta());
				cFeVenda.setCpfCnpjValue(retornoSAT.getSignatureValue());
				cFeVenda.setTimeStamp(retornoSAT.getTimeStamp());
				cFeVenda.setValorTotalCFe(retornoSAT.getValorTotaldoCupom());
				DaoCFeVendas daoCFeVendas = new DaoCFeVendas();
				daoCFeVendas.insert(cFeVenda);
				LogFactory.addInfor("OK comando de insercao executado");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
