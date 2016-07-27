package br.com.barcadero.local.socket;

import java.util.concurrent.Callable;
import br.com.barcadero.commons.socket.SocketCommand;
import br.com.barcadero.commons.socket.SocketDados;
import br.com.barcadero.module.sat.enums.EnumModulosSAT;
import br.com.barcadero.module.sat.handle.HandleSAT;
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
		switch (command.getTipoComando()) {
		case CMD_FOR_ECF:
			return "ECF n�o implementado.";
		case CMD_FOR_SAT:
			return executarComandoSAT(command);
		default:
			return "Tipo de comando não implementado : " + command.getTipoComando().toString() ;
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
		HandleSAT handleSAT = new HandleSAT(command.getModuloSAT());
		String result		= "";
		if(dados instanceof CmdConsultarSAT){
			//CmdConsultarSAT consultarSAT = (CmdConsultarSAT) dados;
			result = handleSAT.consultarSAT();
		}else if(dados instanceof CmdEnviarDadosVenda){
			CmdEnviarDadosVenda dadosVenda = (CmdEnviarDadosVenda) dados;
			result = handleSAT.enviarDadosVenda(dadosVenda.getDadosVenda(), dadosVenda.getCodigoDeAtivacao());
		}else{
			result = "Comando não configurado!";
		}
		return result;
	}

}
