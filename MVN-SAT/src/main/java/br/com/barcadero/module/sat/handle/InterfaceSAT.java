package br.com.barcadero.module.sat.handle;

public interface InterfaceSAT {
	
	public String AtivarSAT(int numeroSessao, int subComando, String codigoDeAtivacao, String cnpj, int cUF) throws Exception ;
	public String ComunicarCertificadoICPBRASIL(int numeroSessao, String codigoDeAtivacao, String certificado) throws Exception;
	public String EnviarDadosVenda(int numeroSessao, String codigoDeAtivacao, String dadosVenda) throws Exception;
	public String CancelarUltimaVenda(int numeroSessao, String codigoDeAtivacao, String chave, String dadosCancelamento) throws Exception;
	public String ConsultarSAT(int numeroSessao) throws Exception;
	public String TesteFimAFim(int numeroSessao, String codigoDeAtivacao, String dadosVenda) throws Exception;
	public String ConsultarStatusOperacional(int numeroSessao, String codigoDeAtivacao) throws Exception;
	public String ConsultarNumeroSessao(int numeroSessao, String codigoDeAtivacao, int cNumeroDeSessao) throws Exception;
	public String ConfigurarInterfaceDeRede(int numeroSessao, String codigoDeAtivacao, String dadosConfiguracao) throws Exception;
	public String AssociarAssinatura(int numeroSessao, String codigoDeAtivacao, String cnpjValue, String assinaturaCNPJs) throws Exception;
	public String AtualizarSoftwareSAT(int numeroSessao, String codigoDeAtivacao) throws Exception;
	public String ExtrairLogs(int numeroSessao, String codigoDeAtivacao) throws Exception;
	public String BloquearSAT(int numeroSessao, String codigoDeAtivacao) throws Exception;
	public String DesbloquearSAT(int numeroSessao, String codigoDeAtivacao) throws Exception;
	public String TrocarCodigoDeAtivacao(int numeroSessao, String codigoDeAtivacao, int opcao, String novoCodigo, String confNovoCodigo) throws Exception;
	public int openPort(int canal) throws Exception;
	public void closePort() throws Exception;
	public String TipoDoModulo() throws Exception;
	/**
	 * Devera retornar o codigo do modulo associado
	 * @return
	 * @throws Exception
	 */
	public abstract int getCodModule()throws Exception;
	/**
	 * Retornara o nome do modulo
	 * @return
	 * @throws Exception
	 */
	public String getModuleName()throws Exception;
	/**
	 * Retornara o caminho completo da classe. Exemplo: br.com.secrel.sat.MySat
	 * @return
	 * @throws Exception
	 */
	public String getModuleClass()throws Exception;
}
