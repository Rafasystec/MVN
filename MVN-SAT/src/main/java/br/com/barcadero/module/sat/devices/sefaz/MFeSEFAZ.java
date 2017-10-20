package br.com.barcadero.module.sat.devices.sefaz;

import java.io.File;

import com.sun.jna.Native;

import br.com.barcadero.module.sat.handle.AbstractSATSuperClass;
import br.com.barcadero.module.sat.handle.HandleSAT;
import br.com.barcadero.module.sat.handle.HendleFile;

public class MFeSEFAZ extends AbstractSATSuperClass {
	private static Functions library			= null;
	private static final String DIR_LIB_LINUX	= File.separator + "usr" + File.separator + "lib" + File.separator;
	public MFeSEFAZ () {
		
	}
	
	public static MFeSEFAZ getInstance(){
		return new MFeSEFAZ();
	}
	public MFeSEFAZ (boolean event) throws Exception{			
		try{
			initialize();
			loadLibrary();
		}catch (UnsatisfiedLinkError e) {
			// TODO: handle exception
			throw new Exception(e);
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}	
	}
	
	public void closePort() throws Exception {
		try {
			library.closePort();
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
	}
	@Override
	public int openPort(int canal) throws Exception {
		try {
			return library.openPort(canal);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

	@Override
	public int getCodModule() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "SAT - Compsis";
	}
	
	/**
	 * Verifica se o arquivo da dll existe.
	 * @return
	 * @throws Exception
	 */
	public boolean exists() throws Exception{
		File file = null;
		try {
			file = new File(getLibraryPath() + getRealLibraryName());
			if(file.exists()){
				//Logfactory.adicionar("OK - Arquivo " + getRealLibraryName() + " foi encontrado no diretorio " + getLibraryPath());
				return true;
			}else{
				//Logfactory.adicionar("Arquivo " + getRealLibraryName() + " nao foi encontrado no diretorio " + getLibraryPath());
				//Logfactory.adicionar("Se o sistema operacional for Linux - o mesmo sera copiado.");
				copiarLibsNecessariasLinux();
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

	@Override
	public String TipoDoModulo() throws Exception {
		// TODO Auto-generated method stub
		return HandleSAT.MFE;
	}
	
	private void initialize() throws Exception{
		String libraryPath = ""; //FileHelper.obterCaminhoRaiz() + "lib" + File.separator;
		//Logfactory.adicionar("Inicializando os parametros para carregar a lib");
		if(getOsName().equalsIgnoreCase(OS_LINUX)){
			//libraryPath =  DIR_LIB_LINUX; //Comentar por enquanto
			////Logfactory.adicionar("Sistema operacional Linux");
			//libraryPath = FileHelper.obterCaminhoRaiz() + "lib" + File.separator;
			libraryPath = "";
		}else{
			libraryPath = HendleFile.obterCaminhoRaiz() + "lib" + File.separator;
		}
		//Logfactory.adicionar("Local onde a lib devera ser inicializada: " + libraryPath);
		setLibraryPath(libraryPath);
		setLibraryNameWindows("libFuncSat");
		setRealLibNameWindows("libFuncSat.dll");
		setRealLibNameLinux("libmfe.so");
		setLibraryNameLinux("mfe");
	}
	
	private void loadLibrary() {
		try {
			//Logfactory.adicionar("Load library: " + getLibraryPath() + getLibraryName());
			library 			= (Functions) Native.loadLibrary(getLibraryPath() + getLibraryName(), Functions.class);
			setLibrary(library);
			//Logfactory.adicionar("OK lib " + getLibraryName() + " foi carregada.");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * Copiar as lib necessarias para o modulo funcionar em ambiente Linux.
	 */
	private void copiarLibsNecessariasLinux() {
		if(getOsName().equalsIgnoreCase(OS_LINUX)){
			File libLibLinux = new File(HendleFile.obterCaminhoRaiz() + "lib" + File.separator + getRealLibNameLinux());
			File libUsrLinux = new File(DIR_LIB_LINUX + getRealLibNameLinux());
			if(!libUsrLinux.exists()){
				//Logfactory.adicionar("A lib para linux realmente. A mesma sera copiada.");
				copiarArquivos(libLibLinux.getAbsolutePath(), libUsrLinux.getAbsolutePath());
			}else{
				//Logfactory.adicionar("OK - A lib ja esta no local correto - Linux.");
			}
		}
	}
	
	/**
	 * Copia um determidano arquivo.
	 * @param origem
	 * @param destino
	 */
	private void copiarArquivos(String origem,String destino) {
//		StringHelper helper = null;
//		try {
//			helper = new StringHelper();
//			helper.copiarArquivo(origem, destino);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
	}


}
