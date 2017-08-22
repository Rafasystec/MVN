package br.com.barcadero.commons.socket;

import java.util.concurrent.Callable;

public class ThreadExecuteCommad implements Callable<String> {

	
	private SocketCommand command;
	public ThreadExecuteCommad(SocketCommand command) {
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
			return "ECF não implementado.";
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
	
	public String executarComandoSAT(SocketCommand command) throws Exception{
		return "";
	}

}
