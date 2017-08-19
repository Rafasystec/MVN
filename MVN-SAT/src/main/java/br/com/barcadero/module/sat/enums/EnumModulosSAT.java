package br.com.barcadero.module.sat.enums;

import br.com.barcadero.module.sat.devices.bematech.*;
import br.com.barcadero.module.sat.devices.dimep.*;
import br.com.barcadero.module.sat.devices.emulador.*;
import br.com.barcadero.module.sat.devices.sefaz.*;
import br.com.barcadero.module.sat.devices.sweda.*;
import br.com.barcadero.module.sat.devices.tanca.ts1000.*;

/**
 * Enumeracao para configurar os modulos SAT-MFe
 * @author Rafael Roca
 * @since SAT-MFe dia 31/01/2015 as 22:28
 */
public enum EnumModulosSAT {
	COMPSIS(MFeSEFAZ.getInstance().getCodModule(),MFeSEFAZ.getInstance().getModuleName(),MFeSEFAZ.getInstance().getModuleClass()),
	EMULADOR(SATEmuladorSP.getInstance().getCodModule(),SATEmuladorSP.getInstance().getModuleName(), SATEmuladorSP.getInstance().getModuleClass()),
	DIMEP(SATDimep.getInstance().getCodModule(),SATDimep.getInstance().getModuleName(), SATDimep.getInstance().getModuleClass()),
	TANCA(SATTanca.getInstance().getCodModule(),SATTanca.getInstance().getModuleName(),SATTanca.getInstance().getModuleClass()),
	SWEDA(SATSweda.getInstance().getCodModule(),SATSweda.getInstance().getModuleName(),SATSweda.getInstance().getModuleClass()),
	BEMATECH(SATBematech.getInstance().getCodModule(),SATBematech.getInstance().getModuleName(),SATBematech.getInstance().getModuleClass());
	
	private int codModule		= 0;
	private String moduleName 	= "";
	private String className	= "";
	
	EnumModulosSAT(int codModule, String moduleName, String className){
		this.codModule 	= codModule;
		this.moduleName = moduleName;
		this.className  = className;
	}

	public int getCodModule() {
		return codModule;
	}

	public void setCodModule(int codModule) {
		this.codModule = codModule;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
