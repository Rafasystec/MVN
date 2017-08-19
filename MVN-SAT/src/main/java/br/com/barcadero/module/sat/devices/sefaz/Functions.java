package br.com.barcadero.module.sat.devices.sefaz;

import br.com.barcadero.module.sat.handle.InterfaceGeneralSAT;



public interface Functions extends InterfaceGeneralSAT{
	public int openPort(int canal);
	public void closePort();
}
