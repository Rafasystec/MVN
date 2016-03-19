package br.com.barcadero.module.sat.devices.compsis;

import br.com.barcadero.module.sat.handle.InterfaceGeneralSAT;



public interface Functions extends InterfaceGeneralSAT{
	public int openPort(int canal);
	public void closePort();
}
