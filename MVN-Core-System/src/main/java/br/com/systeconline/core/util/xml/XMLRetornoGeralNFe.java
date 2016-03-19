package br.com.systeconline.core.util.xml;

import br.com.systeconline.core.webservice.soap.SOAPFaultObject;

public class XMLRetornoGeralNFe {

	public static final int CODIGO_SOAP_FAULT = 10000; 
	private SOAPFaultObject falt;
	private int cStat;
	private String motivo;
	public SOAPFaultObject getFalt() {
		return falt;
	}
	public void setFalt(SOAPFaultObject falt) {
		this.falt = falt;
	}
	public int getcStat() {
		return cStat;
	}
	public void setcStat(int cStat) {
		this.cStat = cStat;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
}
