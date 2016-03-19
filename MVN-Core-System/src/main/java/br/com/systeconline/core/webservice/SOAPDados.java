package br.com.systeconline.core.webservice;

public class SOAPDados {
	
	private String serviceName = "nfeRecepcao";
	private String nameSpaceUri= "http://www.portalfiscal.inf.br/nfe/wsdl/NfeRecepcao2";
	private String cUF			= "35";

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getNameSpaceUri() {
		return nameSpaceUri;
	}

	public void setNameSpaceUri(String nameSpaceUri) {
		this.nameSpaceUri = nameSpaceUri;
	}

	public String getcUF() {
		return cUF;
	}

	public void setcUF(String cUF) {
		this.cUF = cUF;
	}

}
