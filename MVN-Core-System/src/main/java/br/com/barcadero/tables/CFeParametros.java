package br.com.barcadero.tables;

import br.com.barcadero.module.sat.enums.EnumCFeXMLVersion;

public class CFeParametros extends Entidade {
	
	private EnumCFeXMLVersion cfeVersion;

	public EnumCFeXMLVersion getCfeVersion() {
		return cfeVersion;
	}

	public void setCfeVersion(EnumCFeXMLVersion cfeVersion) {
		this.cfeVersion = cfeVersion;
	} 

}
