package br.com.barcadero.commons.loggin;

/**
 * Para a API de Logs
 * @author antoniorafael
 *
 */
public interface ILogger {
	/**
	 * Adicionar um log de informacao --- Prefixo INFOR
	 * @param infor
	 */
	public void infor(String infor);
	/**
	 * Adicionar um log de erro --- Prefixo ERROR
	 * @param error
	 */
	public void error(String error);
	/**
	 * Adiciona um stacktrace de uma excecao
	 * @param throwable
	 */
	public void error(Throwable throwable);

}
