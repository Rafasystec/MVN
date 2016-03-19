package br.com.barcadero.module.sat.devices.bematech;

import java.io.File;

import com.sun.jna.Native;



import br.com.barcadero.module.sat.handle.AbstractSATSuperClass;
import br.com.barcadero.module.sat.handle.HandleSAT;
//import br.com.secrel.sat.logs.LogFactory;
import br.com.barcadero.module.sat.handle.HendleFile;


public class SATBematech extends AbstractSATSuperClass{

	
	public final String LIB_PATH_WINDOWS = HendleFile.obterCaminhoRaiz() + "lib" + File.separator + "bema" + File.separator + "bemasat" + File.separator + "window" + File.separator;
	public final String LIB_PATH_WIN32   = LIB_PATH_WINDOWS + "32" + File.separator;
	public final String LIB_PATH_WIN64   = LIB_PATH_WINDOWS + "64" + File.separator;
	public final String LIB_PATH_LINUX	 = HendleFile.obterCaminhoRaiz() + "lib" + File.separator + "bema" + File.separator + "bemasat" + File.separator + "linux" + File.separator;
	public final String PATH_WIND_SYS_32 = "C:" + File.separator + "Windows" + File.separator + "System32" + File.separator;
	public final String PATH_WIND_SYSWOW = "C:" + File.separator + "Windows" + File.separator + "SysWOW64" + File.separator;	
	public final String BEMASAT_XML		 = "bemasat.xml"; 
	
	private Functions library;
	
	public SATBematech() {
		
	}
	
	public SATBematech(String port){
		try {
			initialize();
			detectOS();
			try {
				//Logfactory.adicionar("Preparando-se para carregar a dll do SAT da Bematech");
				//Logfactory.adicionar("Local para carregar: " + getLibraryPath() + getLibraryName());
				library = (Functions)Native.loadLibrary(getLibraryPath() + getLibraryName(), Functions.class);
				//Logfactory.adicionar("OK, dll ou so foi carregada.");
			} catch (Exception e) {
				// TODO: handle exception
				//Logfactory.adicionar("Erro ao tentar carregar a dll. Path: " + getLibraryPath() + " - Nome lib " + getLibraryName());
				//Logfactory.adicionar(e);
			}
			setLibrary(library);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SATBematech getInstance() {
		return new SATBematech();
	}
	
	public int openPort(int canal) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public void closePort() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public String TipoDoModulo() throws Exception {
		// TODO Auto-generated method stub
		return HandleSAT.SAT;
	}

	@Override
	public int getCodModule() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "SAT - Bematech";
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "SAT - Bematech RB - 1000 Fi";
	}
	
	private void initialize() throws Exception {
		copiarLibsParaSistemaOperacional();
		//Logfactory.adicionar("Inicializando as variaveis.");
//		if(SwingHelper.getArchitecture() == SwingHelper.ARC_JRE_32){
//			//Logfactory.adicionar("JRE de 32 bits");
//			setLibraryNameWindows("BemaSAT32");
//			setRealLibNameWindows("BemaSAT32.dll");
//			setLibraryPath("");
//		}else{
//			//Logfactory.adicionar("JRE de 64 bits");
//			setLibraryNameWindows("BemaSAT64");
//			setRealLibNameWindows("BemaSAT64.dll");
//			setLibraryPath("");
//		}
		
		setLibraryNameLinux("satprotocol");
		setRealLibNameLinux("libsatprotocol.so");	
	}
	
	@Override
	public String CancelarUltimaVenda(int numeroSessao,	String codigoDeAtivacao, String chave, String dadosCancelamento)throws Exception {
		return super.CancelarUltimaVenda(numeroSessao, codigoDeAtivacao, "CFe" + chave, dadosCancelamento);
	}
	
	/**
	 * Copia os arquivos necessarios para o bom funcionamento 
	 */
	private void copiarLibsParaSistemaOperacional() {
		//Logfactory.adicionar("Inciando a verificacao do arquivos necessarios");
//		if(SwingHelper.getArchitecture() == SwingHelper.ARC_JRE_32){
//			if(new File(PATH_WIND_SYSWOW).exists()){
//				if(new File(PATH_WIND_SYSWOW + getRealLibraryName()).exists() == false){
//					copiarArquivos(LIB_PATH_WIN32 + getRealLibraryName(), PATH_WIND_SYSWOW);
//					copiarArquivos(LIB_PATH_WIN32 + BEMASAT_XML, PATH_WIND_SYSWOW);
//				}else{
//					//Logfactory.adicionar("Arquivo " + PATH_WIND_SYSWOW + getRealLibraryName());
//				}
//			}else{
//				if(new File(PATH_WIND_SYS_32 + getRealLibraryName()).exists() == false){
//					copiarArquivos(LIB_PATH_WIN32 + getRealLibraryName(), PATH_WIND_SYS_32);
//					copiarArquivos(LIB_PATH_WIN32 + BEMASAT_XML, PATH_WIND_SYS_32);
//				}else{
//					//Logfactory.adicionar(PATH_WIND_SYS_32 + getRealLibraryName() + " ja existe.");
//				}
//			}
//		}else{
//			copiarArquivos(LIB_PATH_WIN64  + getRealLibraryName(), PATH_WIND_SYS_32);
//			copiarArquivos(LIB_PATH_WIN64  + BEMASAT_XML, PATH_WIND_SYS_32);
//		}
	}
	
	/**
	 * Copia os arquivos conforme ele nao vao sendo encontrados em suas pastas.
	 * @param origem: Caminho completo do arquivo de origem
	 * @param destino: Caminho completo do arquivo de destino
	 */
	private void copiarArquivos(String origem, String destino) {
		File fileOrigem		= null;
		File fileDestino	= null;	
		try {
			//Logfactory.adicionar("Iniciando copia de arquivos");
			fileOrigem 	= new File(origem);
			fileDestino	= new File(destino);
			if(fileOrigem.exists()){
				//Logfactory.adicionar("O arquivo de origem: " + origem + " foi encontrado.");
				if(fileDestino.exists()){
					//Logfactory.adicionar("O arquivo de destino : " + destino + " j� existe, n�o ser� copiado.");
				}else{
					//Logfactory.adicionar("Realizando a copia de arquivos ");
					//Logfactory.adicionar("Origem: " + origem);
					//Logfactory.adicionar("Destino: " + destino);
					//new StringHelper().copiarArquivo(origem, destino);
				}
			}else{
				//Logfactory.adicionar("O arquivo de origem: " + origem + " n�o foi encontrado. Imposs�vel realizar a c�pia.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			//Logfactory.adicionar(e);
		}
	}

}
