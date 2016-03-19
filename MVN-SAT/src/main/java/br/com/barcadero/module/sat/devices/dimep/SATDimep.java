package br.com.barcadero.module.sat.devices.dimep;

import java.io.File;

import com.sun.jna.Native;

import br.com.barcadero.module.sat.handle.AbstractSATSuperClass;
import br.com.barcadero.module.sat.handle.HendleFile;
import br.com.barcadero.module.sat.handle.HandleSAT;

public class SATDimep extends AbstractSATSuperClass{	

	private static Functions library			 	 = null;
	private static final String REAL_LIB_NAME_WIN_DEPEND = "zlib.dll";
	
	public SATDimep(){
		
	}
	/**
	 * Este construtor contem a chamada da DLL do febricante.
	 * @param porta
	 * @throws Exception
	 */
	public SATDimep(String porta) throws Exception{
		try{
			initialize();
			detectOS();
			verifyLibrary();
			library = (Functions)Native.loadLibrary(getLibraryPath() + getLibraryName(), Functions.class);
			setLibrary(library);
			loadLibraryDependent();
		}catch (Exception e) {
			// TODO: handle exception
			//Logfactory.adicionar(e);
			throw e;
		}
	}
	
	private void loadLibraryDependent() throws Exception{
		//if(!osName.equalsIgnoreCase(OS_LINUX)){
		if(!getOsName().equalsIgnoreCase(OS_LINUX)){
			//System.loadLibrary(getLibraryPath() + LIBRARY_NAME_ZLIB);
			System.load(getLibraryPath() + REAL_LIB_NAME_WIN_DEPEND);
		}
	}
	
	/**
	 * Obtem uma instacia do SAT Dimep
	 * @return
	 */
	public static SATDimep getInstance() {
		return new SATDimep();
	}
	
	@Override
	public void closePort() throws Exception {
		// TODO Auto-generated method stub
		library.CloseSerial();
	}

	@Override
	public int openPort(int canal) throws Exception {
		// TODO Auto-generated method stub
		int baud  	 = 0;
		int nBits 	 = 0;
		int paridade = 0;
		int nStops	 = 0;
		return library.AbreSerialSAT(canal, baud, nBits, paridade, nStops);
	}
	@Override
	public int getCodModule()  {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "Dimep - D-SAT";
	}
	
	/**
	 * Verifica se as bibliotecas necessarias para o funcionamento correto do SAT se encontram em seu locais.
	 * @return
	 * @throws Exception
	 */
	public boolean verifyLibrary() throws Exception{
		File file 			= null;
		File fileDepend		= null;
		String osName		= "";
		try {
			osName = getOsName();
			//Logfactory.adicionar("Verificando as bibliotecas necessarias.");
			if(osName.equalsIgnoreCase(OS_LINUX)){
				//Logfactory.adicionar("Verificando para o Linux " + osName);
				file = new File(getLibraryPath() + getRealLibNameLinux());
				if(file.exists()){
					//Logfactory.adicionar("OK - biblioteca encontrada : " + getLibraryPath() + getRealLibNameLinux());
					return true;
				}else{
					//Logfactory.adicionar("Erro - biblioteca " + getRealLibNameLinux() + " nao foi encontrada em " + getLibraryPath());
					//Logfactory.adicionar("A presenca dessa biblioteca e necessaria para o funcionamento correto do Modulo D-Sat");
					return false;
				}
			}else{
				file 		= new File(getLibraryPath() + getRealLibNameWindows());
				fileDepend	= new File(getLibraryPath() + REAL_LIB_NAME_WIN_DEPEND);
				if(!file.exists() || !fileDepend.exists()){
					//Logfactory.adicionar("Erro - Biblioteca " + getRealLibNameWindows() + " ou " + REAL_LIB_NAME_WIN_DEPEND + " nao foram encontradas.");
					//Logfactory.adicionar("Elas devem ficar neste local: " + getLibraryPath());
					return false;
				}else{
					//Logfactory.adicionar("OK - Bibliotecas e suas dependecias foram encontradas.");
					return true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			//Logfactory.adicionar(e);
			throw e;
		}
	}
	
	@Override
	public String toString(){
		StringBuilder detalhes = null;
		String saltoLina	   = "\n";
		try {
			detalhes = new StringBuilder();
			detalhes.append("Nome modulo: ").append(getModuleName()).append(saltoLina);
			detalhes.append("Classe do modulo: ").append(getModuleClass()).append(saltoLina);
			detalhes.append("Implementado para  Windows e Linux.");
			detalhes.append("Biblioteca(s) para Windows: ").append(getRealLibNameWindows()).append(" e ").append(REAL_LIB_NAME_WIN_DEPEND).append(saltoLina);
			detalhes.append("Biblioteca(s) para Linux: ").append(getRealLibNameLinux()).append(saltoLina);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return detalhes.toString();
	}
	
	public String TipoDoModulo() throws Exception {
		// TODO Auto-generated method stub
		return HandleSAT.SAT;
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	private void initialize() throws Exception {
		String libPath = HendleFile.obterCaminhoRaiz() + "lib" + File.separator + "dimep" + File.separator;
		setLibraryNameLinux("satprotocol");
		setLibraryNameWindows("dllsat");
		setLibraryPath(libPath);
		setRealLibNameLinux("libsatprotocol.so");
		setRealLibNameWindows("dllsat.dll");
	}
	
	@Override
	public String CancelarUltimaVenda(int numeroSessao,	String codigoDeAtivacao, String chave, String dadosCancelamento)throws Exception {
		return super.CancelarUltimaVenda(numeroSessao, codigoDeAtivacao, "CFe" + chave, dadosCancelamento);
	}
}
