package br.com.barcadero.module.sat.devices.bematech;

import java.io.File;

import com.sun.jna.Native;



import br.com.barcadero.module.sat.handle.AbstractSATSuperClass;
import br.com.barcadero.module.sat.handle.HandleSAT;
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
				library = (Functions)Native.loadLibrary(getLibraryPath() + getLibraryName(), Functions.class);
			} catch (Exception e) {
				
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
		setLibraryNameLinux("satprotocol");
		setRealLibNameLinux("libsatprotocol.so");	
	}


}
