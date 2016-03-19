package br.com.barcadero.module.sat.handle;


public abstract class AbstractSATSuperClass implements InterfaceSAT{

	public final String OS_LINUX		= "Linux";
	private String libraryPath			= ""; 
	private String libraryNameWindows 	= "";
	private String libraryNameLinux		= "";
	private String osName				= System.getProperty("os.name");
	private String realLibNameWindows	= "";
	private String realLibNameLinux		= "";
	private String msgDefaulTimout		= "Time out - Modulo nao Responde.";
	private String msgNaoResponde		= "Modulo nao responde.";
	
	private InterfaceGeneralSAT library	= null;
	
	public AbstractSATSuperClass(){
		
	}
	
	public String getMsgDefaulTimout() {
		return msgDefaulTimout;
	}


	public void setMsgDefaulTimout(String msgDefaulTimout) {
		this.msgDefaulTimout = msgDefaulTimout;
	}


	public String getMsgNaoResponde() {
		return msgNaoResponde;
	}


	public void setMsgNaoResponde(String msgNaoResponde) {
		this.msgNaoResponde = msgNaoResponde;
	}


	public String getLibraryPath() {
		return libraryPath;
	}
	
	public void setLibraryPath(String libraryPath) {
		this.libraryPath = libraryPath;
	}

	public String getLibraryNameWindows() {
		return libraryNameWindows;
	}
	/**
	 * Nome da biblioteca de vinculos dinamicos para o windows, ou seja, o nome da dll sem a exten��o .dll
	 * exemplo: SAT.dll devera ficar SAT .
	 * @param libraryNameWindows
	 */
	public void setLibraryNameWindows(String libraryNameWindows) {
		this.libraryNameWindows = libraryNameWindows;
	}
	
	/**
	 * Obtem o nome da biblioteca no linux.
	 * @return
	 */
	public String getLibraryNameLinux() {
		return libraryNameLinux;
	}
	
	/**
	 * Nome da SO que devera ser invocada no Linux. geralmente elas vem com o prefixo lib e a extensao .so.
	 * Entao como exemplo temos: libsatprotocol.so devera ser informado como satprotocol - Sem o prefixo lib e a extensao.
	 * @param libraryNameLinux : Nome da biblioteca no linux sem prefixo e extensao
	 */
	public void setLibraryNameLinux(String libraryNameLinux) {
		this.libraryNameLinux = libraryNameLinux;
	}

	public String getOsName() {
		return osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}

	public String getRealLibNameWindows() {
		return realLibNameWindows;
	}

	public void setRealLibNameWindows(String realLibNameWindows) {
		this.realLibNameWindows = realLibNameWindows;
	}

	public String getRealLibNameLinux() {
		return realLibNameLinux;
	}

	public void setRealLibNameLinux(String realLibNameLinux) {
		this.realLibNameLinux = realLibNameLinux;
	}

	public InterfaceGeneralSAT getLibrary() {
		return library;
	}

	public void setLibrary(InterfaceGeneralSAT library) {
		this.library = library;
	}
	
	public String AssociarAssinatura(int numeroSessao, String codigoDeAtivacao, String cnpjValue, String assinaturaCNPJs) throws Exception {
		// TODO Auto-generated method stub
		return library.AssociarAssinatura(numeroSessao, codigoDeAtivacao, cnpjValue, assinaturaCNPJs);
	}

	public String AtivarSAT(int numeroSessao, int subComando, String codigoDeAtivacao, String cnpj, int cuf) throws Exception {
		// TODO Auto-generated method stub
		return library.AtivarSAT(numeroSessao, subComando, codigoDeAtivacao, cnpj, cuf);
	}

	public String AtualizarSoftwareSAT(int numeroSessao, String codigoDeAtivacao) throws Exception {
		// TODO Auto-generated method stub
		return library.AtualizarSoftwareSAT(numeroSessao, codigoDeAtivacao);
	}

	public String BloquearSAT(int numeroSessao, String codigoDeAtivacao)throws Exception {
		// TODO Auto-generated method stub
		return library.BloquearSAT(numeroSessao, codigoDeAtivacao);
	}

	public String CancelarUltimaVenda(int numeroSessao,	String codigoDeAtivacao, String chave, String dadosCancelamento)throws Exception {
		// TODO Auto-generated method stub
		return library.CancelarUltimaVenda(numeroSessao, codigoDeAtivacao, chave, dadosCancelamento);
	}

	public String ComunicarCertificadoICPBRASIL(int numeroSessao,String codigoDeAtivacao, String certificado) throws Exception {
		// TODO Auto-generated method stub
		return library.ComunicarCertificadoICPBRASIL(numeroSessao, codigoDeAtivacao, certificado);
	}

	public String ConfigurarInterfaceDeRede(int numeroSessao,String codigoDeAtivacao, String dadosConfiguracao) throws Exception {
		// TODO Auto-generated method stub
		return library.ConfigurarInterfaceDeRede(numeroSessao, codigoDeAtivacao, dadosConfiguracao);
	}

	public String ConsultarNumeroSessao(int numeroSessao, String codigoDeAtivacao, int numeroDeSessao) throws Exception {
		// TODO Auto-generated method stub
		//return ConsultarNumeroSessao(numeroSessao, codigoDeAtivacao, numeroDeSessao);
		return library.ConsultarNumeroSessao(numeroSessao, codigoDeAtivacao, numeroDeSessao);
	}

	public String ConsultarSAT(int numeroSessao) throws Exception {
		// TODO Auto-generated method stub
		return library.ConsultarSAT(numeroSessao);
	}

	public String ConsultarStatusOperacional(int numeroSessao, String codigoDeAtivacao) throws Exception {
		// TODO Auto-generated method stub
		return library.ConsultarStatusOperacional(numeroSessao, codigoDeAtivacao);
	}

	public String DesbloquearSAT(int numeroSessao, String codigoDeAtivacao)	throws Exception {
		// TODO Auto-generated method stub
		return library.DesbloquearSAT(numeroSessao, codigoDeAtivacao);
	}

	public String EnviarDadosVenda(int numeroSessao, String codigoDeAtivacao,String dadosVenda) throws Exception {
		// TODO Auto-generated method stub
		return library.EnviarDadosVenda(numeroSessao, codigoDeAtivacao, dadosVenda);
	}

	public String ExtrairLogs(int numeroSessao, String codigoDeAtivacao)throws Exception {
		// TODO Auto-generated method stub
		return library.ExtrairLogs(numeroSessao, codigoDeAtivacao);
	}

	public String TesteFimAFim(int numeroSessao, String codigoDeAtivacao, String dadosVenda) throws Exception {
		// TODO Auto-generated method stub
		return library.TesteFimAFim(numeroSessao, codigoDeAtivacao, dadosVenda);
	}

	public String TrocarCodigoDeAtivacao(int numeroSessao, String codigoDeAtivacao, int opcao, String novoCodigo, String confNovoCodigo) throws Exception {
		// TODO Auto-generated method stub
		return library.TrocarCodigoDeAtivacao(numeroSessao, codigoDeAtivacao, opcao, novoCodigo, confNovoCodigo);
	}
	
	public String getModuleClass() {
		// TODO Auto-generated method stub
		return this.getClass().getName();
	}
	
	/**
	 * Obtem o caminho da biblioteca dependendo do sistema operacional.
	 * @return
	 */
	public String getLibraryName() {
		if(osName.equalsIgnoreCase(OS_LINUX)){
			return this.libraryNameLinux;
		}else {
			return this.libraryNameWindows;
		}
	}
	
	/**
	 * Obtem o verdadeiro nome da biblioteca
	 * @return
	 */
	public String getRealLibraryName() {
		if(osName.equalsIgnoreCase(OS_LINUX)){
			return this.realLibNameLinux;
		}else {
			return this.realLibNameWindows;
		}
	}
	
	public void detectOS() {
		if(osName.equalsIgnoreCase(OS_LINUX)){
			//LogFactory.adicionar("Plataforma Linux. Distribuicao : " + osName);
		}else{
			//LogFactory.adicionar("Provavelmente plataforma Windows. Nome: " + osName);
		}
	}

	
}
