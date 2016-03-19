package br.com.barcadero.module.sat.devices.sweda;

import java.io.File;

import br.com.barcadero.module.sat.handle.AbstractSATSuperClass;
import br.com.barcadero.module.sat.handle.HendleFile;
import br.com.barcadero.module.sat.handle.HandleSAT;

import com.sun.jna.Native;


public class SATSweda extends AbstractSATSuperClass {
	
	private static Functions library		  = null;
	public static final String DIR_LIBRARY 	  = HendleFile.obterCaminhoRaiz() + "lib" 	 + File.separator + "sweda" + File.separator;
	public static final String DIR_32_BITS 	  = DIR_LIBRARY + File.separator  + "32" 	 + File.separator;
	public static final String DIR_64_BITS 	  = DIR_LIBRARY + File.separator  + "64" 	 + File.separator;
	public static final String DIR_DEPEND_32  = DIR_32_BITS + File.separator  + "depend" + File.separator;
	public static final String DIR_DEPEND_64  = DIR_64_BITS + File.separator  + "depend" + File.separator;
	public static final String ICONV_DLL	  = "iconv.dll";
	public static final String LIBXML2_DLL	  = "libxml2.dll";
	public static final String ZLIB1_DLL	  = "zlib1.dll";
	
	public SATSweda() {
		// TODO Auto-generated constructor stub
		//Construtor somente para mostrar na Enumeracao ModulosSat
	}
	
	public SATSweda(String port) throws Exception {
		// TODO Auto-generated constructor stub
		//---------------------------------------------------------
		//Inicializando os componentes
		//---------------------------------------------------------
		//Logfactory.adicionar("Initialize SWEDA SS-1000");
		initialize();
		//---------------------------------------------------------
		//Carregando a dll que contem as funcoes
		//---------------------------------------------------------
		//Logfactory.adicionar("Carregando a dll ou so principal que contem as funcoes");
		library = (Functions)Native.loadLibrary(getLibraryPath() + getLibraryName(), Functions.class);
		//---------------------------------------------------------
		//Colocando a dll para que as classes superiores a encontrem
		//---------------------------------------------------------
		//Logfactory.adicionar("Permitindo que ad camadas superiores possam ver as funcoes");
		setLibrary(library);
		//---------------------------------------------------------
		//Carregando dll dependentes
		//---------------------------------------------------------
		//Logfactory.adicionar("Carregando as dependencias.");
		loadLibraryDepend();
	}
	public static SATSweda getInstance() {
		return new SATSweda();
	}
	
	@Override
	public String TipoDoModulo() throws Exception {
		// TODO Auto-generated method stub
		return HandleSAT.SAT;
	}

	@Override
	public void closePort() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public int getCodModule() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "SAT - Sweda SS-1000";
	}

	@Override
	public int openPort(int canal) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString(){
		return "Modulo SAT SWEDA SS-1000";
	}
	
	/**
	 * Inicializar o SAT
	 * @throws Exception
	 */
	private void initialize() throws Exception {
		setLibraryNameLinux("SATDLL");
		setLibraryNameWindows("SATDLL");
		setLibraryPath(getLibraryPathByOS());
		setRealLibNameLinux("libSATDLL.so");
		setRealLibNameWindows("SATDLL.dll");
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	private boolean is64Bits() throws Exception{
		File file = null;
		try {
			file = new File("C:\\Windows\\SysWOW64");
			if(file.exists()){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	private void loadLibraryDepend() throws Exception{
		File fileLibs	= null;
		try {
			if(!getOsName().equalsIgnoreCase(OS_LINUX)){
				if(is64Bits()){
					fileLibs = new File(DIR_DEPEND_64);
				}else{
					fileLibs = new File(DIR_DEPEND_32);
				}
				if(fileLibs != null && fileLibs.exists()){
					//Carregar as bibliotecas
					for(String fileName : fileLibs.list()){
						System.load(fileName);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	private String getLibraryPathByOS() throws Exception{
		try {
			if(getOsName().equalsIgnoreCase(OS_LINUX)){
				return DIR_32_BITS;
			}else {
				if(is64Bits()){
					return DIR_64_BITS;
				}else{
					return DIR_32_BITS;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			return DIR_32_BITS;
		}
	}

}
