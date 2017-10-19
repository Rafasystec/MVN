package br.com.barcadero.local.socket;

import java.util.concurrent.Callable;

import br.com.barcadero.commons.socket.SocketCommand;
import br.com.barcadero.commons.socket.SocketDados;
import br.com.barcadero.local.persistence.dao.DaoCFeVendas;
import br.com.barcadero.local.persistence.model.CFeVenda;
import br.com.barcadero.local.persistence.model.SuperCFeEntidade;
import br.com.barcadero.module.sat.handle.HandleRetornoSAT;
import br.com.barcadero.module.sat.handle.HandleSAT;
import br.com.barcadero.module.sat.socket.CmdCancelarUltimaVenda;
import br.com.barcadero.module.sat.socket.CmdConsultarSAT;
import br.com.barcadero.module.sat.socket.CmdEnviarDadosVenda;

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
				//return "Comando Executado sat executado";
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
			result = "Erro ao carregar a DLL/SO: "+linkErro.getMessage();
		}catch(Exception e){
			result = "Erro ao tentar instanciar SAT"+e.getMessage();
		}
		if(result.trim().isEmpty()){
			try{
				if(dados instanceof CmdConsultarSAT){
					result = handleSAT.consultarSAT();
				}else if(dados instanceof CmdEnviarDadosVenda){
					CmdEnviarDadosVenda dadosVenda = (CmdEnviarDadosVenda) dados;
					result = handleSAT.enviarDadosVenda(dadosVenda.getDadosVenda(), dadosVenda.getCodigoDeAtivacao());
					salvarRetornoVenda(result);
				}else if(dados instanceof CmdCancelarUltimaVenda){
					CmdCancelarUltimaVenda cancelarUltimaVenda = (CmdCancelarUltimaVenda) dados;
					result = handleSAT.cancelarUltimaVenda(cancelarUltimaVenda.getChave(), cancelarUltimaVenda.getCodigoDeAtivacao(),cancelarUltimaVenda.getDadosCancelamento());
				}else{
					result = "Comando não configurado!";
				}
			}catch(Exception e){
				result = "Erro ao tentar executar função: "+e.getMessage();
			}
		}
		return result;
	}

	private void salvarRetornoVenda(String retorno) {
		try {
			HandleRetornoSAT retornoSAT = HandleSAT.tratarRetornoVenda(retorno);
			if(retornoSAT.getCodigoRetorno1().equals("06000")){
				CFeVenda cFeVenda = new CFeVenda();
				cFeVenda.setArquivoBase64(retornoSAT.getArquivoCFeSAT());
				cFeVenda.setAssinaturaQrcode(retornoSAT.getDigestValue());
				SuperCFeEntidade cFeEntidade = new SuperCFeEntidade();
				cFeEntidade.setCodCCCC(retornoSAT.getCodigoRetorno2());
				cFeEntidade.setCodErroSAT(retornoSAT.getCodigoRetorno1());
				cFeEntidade.setCodSEFAZ("0");
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
