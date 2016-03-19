package br.com.barcadero.module.sat.devices.emulador;

import java.io.File;

import br.com.barcadero.module.sat.handle.AbstractSATSuperClass;
import br.com.barcadero.module.sat.handle.HendleFile;
import br.com.barcadero.module.sat.handle.HandleSAT;

import com.sun.jna.Native;


public class SATEmulador extends AbstractSATSuperClass {

	private Functions library 						= null;

	public SATEmulador(){
		try {
			initialize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Construtor que instancia a lib do Emulador
	 * @param porta
	 * @throws Exception
	 */
	public SATEmulador(String porta) throws Exception, UnsatisfiedLinkError{
		try {
			initialize();
			verificarSeADLLExiste();
			library = (Functions)Native.loadLibrary(getLibraryPath() + getLibraryName(), Functions.class);
			setLibrary(library);
		}catch (UnsatisfiedLinkError e) {
			// TODO: handle exception
			throw e;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	public static SATEmulador getInstance(){
		return new SATEmulador();
	}


	@Override
	public void closePort() throws Exception {
		try {
			System.out.println("Close port. Do nothing."); 
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}

	}

	@Override
	public int openPort(int canal) throws Exception {
		try {
			System.out.println("Open port SAT emulador SEFAZ-SP.");
			return 0;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	@Override
	public int getCodModule() {
		// TODO Auto-generated method stub
		return 2;
	}
	
	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "SAT - Emulador";
	}
	
	@Override
	public String toString(){
		String modelo 		= "";
		String className	= "";
		String codigo		= "";
		StringBuilder ret	= null;
		try {
			ret 		= new StringBuilder();
			modelo 		= getModuleName();
			className	= getModuleClass();
			codigo		= getCodModule()+"";
			ret.append("Modelo: ").append(modelo).append("\n");
			ret.append("Classe: ").append(className).append("\n");
			ret.append("Codigo: ").append(codigo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ret.toString();
	}
	/**
	 * verifica se o arquivo exite.
	 * @throws Exception
	 */
	private void verificarSeADLLExiste() throws Exception {
		File file	= null;
		try {
			file = new File(getLibraryPath() + getRealLibraryName());
			if(!file.exists()){
				throw new Exception("A biblioteca de Funcoes " + getRealLibraryName() + " nao foi encontrada em " + getLibraryPath() + ".");
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	@Override
	public String TipoDoModulo() throws Exception {
		// TODO Auto-generated method stub
		return HandleSAT.SAT;
	}
	
	/**
	 * Inicializar as variaveis necessarias para classe pai abstrata.
	 * @throws Exception
	 */
	private void initialize()throws Exception {
		String libraryPath = HendleFile.obterCaminhoRaiz() + "lib" + File.separator;
		try {
			setLibraryPath(libraryPath);
			setLibraryNameWindows("SAT");
			setLibraryNameLinux("");
			setRealLibNameLinux("");
			setRealLibNameWindows("SAT.dll");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
